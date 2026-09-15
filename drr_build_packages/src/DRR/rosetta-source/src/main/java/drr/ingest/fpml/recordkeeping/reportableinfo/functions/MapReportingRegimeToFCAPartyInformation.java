package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.FCAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.shared.Party;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReportingRegimeToFCAPartyInformation.MapReportingRegimeToFCAPartyInformationDefault.class)
public abstract class MapReportingRegimeToFCAPartyInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCorporateSector mapCorporateSector;

	/**
	* @param fpmlReportingRegime 
	* @param fpmlParty 
	* @param supervisoryBody 
	* @return fCAPartyInformation 
	*/
	public FCAPartyInformation evaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
		FCAPartyInformation.FCAPartyInformationBuilder fCAPartyInformationBuilder = doEvaluate(fpmlReportingRegime, fpmlParty, supervisoryBody);
		
		final FCAPartyInformation fCAPartyInformation;
		if (fCAPartyInformationBuilder == null) {
			fCAPartyInformation = null;
		} else {
			fCAPartyInformation = fCAPartyInformationBuilder.build();
			objectValidator.validate(FCAPartyInformation.class, fCAPartyInformation);
		}
		
		return fCAPartyInformation;
	}

	protected abstract FCAPartyInformation.FCAPartyInformationBuilder doEvaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperS<String> esmaCorporateSectorScheme(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	public static class MapReportingRegimeToFCAPartyInformationDefault extends MapReportingRegimeToFCAPartyInformation {
		@Override
		protected FCAPartyInformation.FCAPartyInformationBuilder doEvaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			FCAPartyInformation.FCAPartyInformationBuilder fCAPartyInformation = FCAPartyInformation.builder();
			return assignOutput(fCAPartyInformation, fpmlReportingRegime, fpmlParty, supervisoryBody);
		}
		
		protected FCAPartyInformation.FCAPartyInformationBuilder assignOutput(FCAPartyInformation.FCAPartyInformationBuilder fCAPartyInformation, ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			if (areEqual(MapperS.of(supervisoryBody), MapperS.of(SupervisoryBodyEnum.FCA), CardinalityOperator.All).getOrDefault(false)) {
				fCAPartyInformation = toBuilder(FCAPartyInformation.builder()
					.setNatureOfParty(MapperS.of(fpmlReportingRegime).<EntityClassification>map("getEntityClassification", reportingRegime -> reportingRegime.getEntityClassification()).<String>map("getValue", entityClassification -> entityClassification.getValue()).checkedMap("to-enum", NatureOfPartyEnum::fromDisplayName, IllegalArgumentException.class).get())
					.setCorporateSector(mapCorporateSector.evaluate(esmaCorporateSectorScheme(fpmlReportingRegime, fpmlParty, supervisoryBody).get(), fpmlParty))
					.setExceedsClearingThreshold(MapperS.of(fpmlReportingRegime).<Boolean>map("getExceedsClearingThreshold", reportingRegime -> reportingRegime.getExceedsClearingThreshold()).get())
					.setDirectlyLinkedActivity(MapperS.of(fpmlReportingRegime).<Boolean>map("getDirectlyLinkedActivity", reportingRegime -> reportingRegime.getDirectlyLinkedActivity()).get())
					.build());
			} else {
				fCAPartyInformation = null;
			}
			
			return Optional.ofNullable(fCAPartyInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<String> esmaCorporateSectorScheme(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			return MapperS.of("http://www.fpml.org/coding-scheme/esma-emir-refit-regulatory-corporate-sector");
		}
	}
}
