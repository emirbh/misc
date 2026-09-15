package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.HKMAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.shared.Party;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReportingRegimeToHKMAPartyInformation.MapReportingRegimeToHKMAPartyInformationDefault.class)
public abstract class MapReportingRegimeToHKMAPartyInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCorporateSector mapCorporateSector;

	/**
	* @param fpmlReportingRegime 
	* @param fpmlParty 
	* @param supervisoryBody 
	* @return hKMAPartyInformation 
	*/
	public HKMAPartyInformation evaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
		HKMAPartyInformation.HKMAPartyInformationBuilder hKMAPartyInformationBuilder = doEvaluate(fpmlReportingRegime, fpmlParty, supervisoryBody);
		
		final HKMAPartyInformation hKMAPartyInformation;
		if (hKMAPartyInformationBuilder == null) {
			hKMAPartyInformation = null;
		} else {
			hKMAPartyInformation = hKMAPartyInformationBuilder.build();
			objectValidator.validate(HKMAPartyInformation.class, hKMAPartyInformation);
		}
		
		return hKMAPartyInformation;
	}

	protected abstract HKMAPartyInformation.HKMAPartyInformationBuilder doEvaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperS<String> hkmaCorporateSectorScheme(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	public static class MapReportingRegimeToHKMAPartyInformationDefault extends MapReportingRegimeToHKMAPartyInformation {
		@Override
		protected HKMAPartyInformation.HKMAPartyInformationBuilder doEvaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			HKMAPartyInformation.HKMAPartyInformationBuilder hKMAPartyInformation = HKMAPartyInformation.builder();
			return assignOutput(hKMAPartyInformation, fpmlReportingRegime, fpmlParty, supervisoryBody);
		}
		
		protected HKMAPartyInformation.HKMAPartyInformationBuilder assignOutput(HKMAPartyInformation.HKMAPartyInformationBuilder hKMAPartyInformation, ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			if (areEqual(MapperS.of(supervisoryBody), MapperS.of(SupervisoryBodyEnum.HKMA), CardinalityOperator.All).getOrDefault(false)) {
				hKMAPartyInformation = toBuilder(HKMAPartyInformation.builder()
					.setNatureOfParty(MapperS.of(fpmlReportingRegime).<EntityClassification>map("getEntityClassification", reportingRegime -> reportingRegime.getEntityClassification()).<String>map("getValue", entityClassification -> entityClassification.getValue()).checkedMap("to-enum", NatureOfPartyEnum::fromDisplayName, IllegalArgumentException.class).get())
					.setCorporateSector(mapCorporateSector.evaluate(hkmaCorporateSectorScheme(fpmlReportingRegime, fpmlParty, supervisoryBody).get(), fpmlParty))
					.build());
			} else {
				hKMAPartyInformation = null;
			}
			
			return Optional.ofNullable(hKMAPartyInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<String> hkmaCorporateSectorScheme(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			return MapperS.of("http://www.fpml.org/coding-scheme/hkma-rewrite-regulatory-corporate-sector");
		}
	}
}
