package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.ESMAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.PartyEntityClassification;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReportingRegimeToESMAPartyInformation.MapReportingRegimeToESMAPartyInformationDefault.class)
public abstract class MapReportingRegimeToESMAPartyInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCorporateSector mapCorporateSector;

	/**
	* @param fpmlReportingRegime 
	* @param fpmlParty 
	* @param supervisoryBody 
	* @return esmaPartyInformation 
	*/
	public ESMAPartyInformation evaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
		ESMAPartyInformation.ESMAPartyInformationBuilder esmaPartyInformationBuilder = doEvaluate(fpmlReportingRegime, fpmlParty, supervisoryBody);
		
		final ESMAPartyInformation esmaPartyInformation;
		if (esmaPartyInformationBuilder == null) {
			esmaPartyInformation = null;
		} else {
			esmaPartyInformation = esmaPartyInformationBuilder.build();
			objectValidator.validate(ESMAPartyInformation.class, esmaPartyInformation);
		}
		
		return esmaPartyInformation;
	}

	protected abstract ESMAPartyInformation.ESMAPartyInformationBuilder doEvaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperS<String> esmaCorporateSectorScheme(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperS<String> partyEntityClassifications(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperS<NatureOfPartyEnum> natureOfParty(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	public static class MapReportingRegimeToESMAPartyInformationDefault extends MapReportingRegimeToESMAPartyInformation {
		@Override
		protected ESMAPartyInformation.ESMAPartyInformationBuilder doEvaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			ESMAPartyInformation.ESMAPartyInformationBuilder esmaPartyInformation = ESMAPartyInformation.builder();
			return assignOutput(esmaPartyInformation, fpmlReportingRegime, fpmlParty, supervisoryBody);
		}
		
		protected ESMAPartyInformation.ESMAPartyInformationBuilder assignOutput(ESMAPartyInformation.ESMAPartyInformationBuilder esmaPartyInformation, ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			if (areEqual(MapperS.of(supervisoryBody), MapperS.of(SupervisoryBodyEnum.ESMA), CardinalityOperator.All).getOrDefault(false)) {
				esmaPartyInformation = toBuilder(ESMAPartyInformation.builder()
					.setNatureOfParty(natureOfParty(fpmlReportingRegime, fpmlParty, supervisoryBody).get())
					.setCorporateSector(mapCorporateSector.evaluate(esmaCorporateSectorScheme(fpmlReportingRegime, fpmlParty, supervisoryBody).get(), fpmlParty))
					.setExceedsClearingThreshold(MapperS.of(fpmlReportingRegime).<Boolean>map("getExceedsClearingThreshold", reportingRegime -> reportingRegime.getExceedsClearingThreshold()).get())
					.setDirectlyLinkedActivity(MapperS.of(fpmlReportingRegime).<Boolean>map("getDirectlyLinkedActivity", reportingRegime -> reportingRegime.getDirectlyLinkedActivity()).get())
					.build());
			} else {
				esmaPartyInformation = null;
			}
			
			return Optional.ofNullable(esmaPartyInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<String> esmaCorporateSectorScheme(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			return MapperS.of("http://www.fpml.org/coding-scheme/esma-emir-refit-regulatory-corporate-sector");
		}
		
		@Override
		protected MapperS<String> partyEntityClassifications(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			final MapperC<PartyEntityClassification> thenArg0 = MapperS.of(fpmlReportingRegime).<PartyEntityClassification>mapC("getPartyEntityClassification", reportingRegime -> reportingRegime.getPartyEntityClassification())
				.filterItemNullSafe(item -> areEqual(item.<PartyReference>map("getPartyReference", partyEntityClassification -> partyEntityClassification.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()), MapperS.of(fpmlParty).<String>map("getId", party -> party.getId()), CardinalityOperator.All).get());
			final MapperC<String> thenArg1 = thenArg0
				.mapItem(item -> item.<EntityClassification>map("getEntityClassification", partyEntityClassification -> partyEntityClassification.getEntityClassification()).<String>map("getValue", entityClassification -> entityClassification.getValue()));
			return thenArg1
				.first();
		}
		
		@Override
		protected MapperS<NatureOfPartyEnum> natureOfParty(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			if (exists(MapperS.of(fpmlReportingRegime).<EntityClassification>map("getEntityClassification", reportingRegime -> reportingRegime.getEntityClassification()).<String>map("getValue", entityClassification -> entityClassification.getValue())).getOrDefault(false)) {
				return MapperS.of(fpmlReportingRegime).<EntityClassification>map("getEntityClassification", reportingRegime -> reportingRegime.getEntityClassification()).<String>map("getValue", entityClassification -> entityClassification.getValue()).checkedMap("to-enum", NatureOfPartyEnum::fromDisplayName, IllegalArgumentException.class);
			}
			if (exists(partyEntityClassifications(fpmlReportingRegime, fpmlParty, supervisoryBody)).getOrDefault(false)) {
				return partyEntityClassifications(fpmlReportingRegime, fpmlParty, supervisoryBody).checkedMap("to-enum", NatureOfPartyEnum::fromDisplayName, IllegalArgumentException.class);
			}
			return MapperS.<NatureOfPartyEnum>ofNull();
		}
	}
}
