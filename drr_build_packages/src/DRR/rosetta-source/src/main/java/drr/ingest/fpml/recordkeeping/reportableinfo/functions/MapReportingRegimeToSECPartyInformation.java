package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CFTCFinancialEntityClassificationEnum;
import drr.regulation.common.SECPartyInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.PartyEntityClassification;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReportingRegimeToSECPartyInformation.MapReportingRegimeToSECPartyInformationDefault.class)
public abstract class MapReportingRegimeToSECPartyInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlReportingRegime 
	* @param fpmlParty 
	* @param supervisoryBody 
	* @return secPartyInformation 
	*/
	public SECPartyInformation evaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
		SECPartyInformation.SECPartyInformationBuilder secPartyInformationBuilder = doEvaluate(fpmlReportingRegime, fpmlParty, supervisoryBody);
		
		final SECPartyInformation secPartyInformation;
		if (secPartyInformationBuilder == null) {
			secPartyInformation = null;
		} else {
			secPartyInformation = secPartyInformationBuilder.build();
			objectValidator.validate(SECPartyInformation.class, secPartyInformation);
		}
		
		return secPartyInformation;
	}

	protected abstract SECPartyInformation.SECPartyInformationBuilder doEvaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperS<? extends PartyEntityClassification> partyEntityClassification(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	public static class MapReportingRegimeToSECPartyInformationDefault extends MapReportingRegimeToSECPartyInformation {
		@Override
		protected SECPartyInformation.SECPartyInformationBuilder doEvaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			SECPartyInformation.SECPartyInformationBuilder secPartyInformation = SECPartyInformation.builder();
			return assignOutput(secPartyInformation, fpmlReportingRegime, fpmlParty, supervisoryBody);
		}
		
		protected SECPartyInformation.SECPartyInformationBuilder assignOutput(SECPartyInformation.SECPartyInformationBuilder secPartyInformation, ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			if (areEqual(MapperS.of(supervisoryBody), MapperS.of(SupervisoryBodyEnum.SEC), CardinalityOperator.All).getOrDefault(false)) {
				secPartyInformation = toBuilder(SECPartyInformation.builder()
					.setFinancialEntity(partyEntityClassification(fpmlReportingRegime, fpmlParty, supervisoryBody).<EntityClassification>map("getEntityClassification", _partyEntityClassification -> _partyEntityClassification.getEntityClassification()).<String>map("getValue", entityClassification -> entityClassification.getValue()).checkedMap("to-enum", CFTCFinancialEntityClassificationEnum::fromDisplayName, IllegalArgumentException.class).get())
					.build());
			} else {
				secPartyInformation = null;
			}
			
			return Optional.ofNullable(secPartyInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends PartyEntityClassification> partyEntityClassification(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			final MapperC<PartyEntityClassification> thenArg = MapperS.of(fpmlReportingRegime).<PartyEntityClassification>mapC("getPartyEntityClassification", reportingRegime -> reportingRegime.getPartyEntityClassification())
				.filterItemNullSafe(item -> areEqual(item.<PartyReference>map("getPartyReference", _partyEntityClassification -> _partyEntityClassification.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()), MapperS.of(fpmlParty).<String>map("getId", party -> party.getId()), CardinalityOperator.All).get());
			return thenArg
				.first();
		}
	}
}
