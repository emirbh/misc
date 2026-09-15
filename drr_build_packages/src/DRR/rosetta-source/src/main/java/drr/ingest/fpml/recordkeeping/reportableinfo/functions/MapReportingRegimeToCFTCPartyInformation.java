package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CFTCFinancialEntityClassificationEnum;
import drr.regulation.common.CFTCPartyInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.PartyEntityClassification;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReportingRegimeToCFTCPartyInformation.MapReportingRegimeToCFTCPartyInformationDefault.class)
public abstract class MapReportingRegimeToCFTCPartyInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlReportingRegime 
	* @param fpmlParty 
	* @param supervisoryBody 
	* @return cftcPartyInformation 
	*/
	public CFTCPartyInformation evaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
		CFTCPartyInformation.CFTCPartyInformationBuilder cftcPartyInformationBuilder = doEvaluate(fpmlReportingRegime, fpmlParty, supervisoryBody);
		
		final CFTCPartyInformation cftcPartyInformation;
		if (cftcPartyInformationBuilder == null) {
			cftcPartyInformation = null;
		} else {
			cftcPartyInformation = cftcPartyInformationBuilder.build();
			objectValidator.validate(CFTCPartyInformation.class, cftcPartyInformation);
		}
		
		return cftcPartyInformation;
	}

	protected abstract CFTCPartyInformation.CFTCPartyInformationBuilder doEvaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	protected abstract MapperS<? extends PartyEntityClassification> partyEntityClassification(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody);

	public static class MapReportingRegimeToCFTCPartyInformationDefault extends MapReportingRegimeToCFTCPartyInformation {
		@Override
		protected CFTCPartyInformation.CFTCPartyInformationBuilder doEvaluate(ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			CFTCPartyInformation.CFTCPartyInformationBuilder cftcPartyInformation = CFTCPartyInformation.builder();
			return assignOutput(cftcPartyInformation, fpmlReportingRegime, fpmlParty, supervisoryBody);
		}
		
		protected CFTCPartyInformation.CFTCPartyInformationBuilder assignOutput(CFTCPartyInformation.CFTCPartyInformationBuilder cftcPartyInformation, ReportingRegime fpmlReportingRegime, Party fpmlParty, SupervisoryBodyEnum supervisoryBody) {
			if (areEqual(MapperS.of(supervisoryBody), MapperS.of(SupervisoryBodyEnum.CFTC), CardinalityOperator.All).getOrDefault(false)) {
				cftcPartyInformation = toBuilder(CFTCPartyInformation.builder()
					.setFinancialEntity(partyEntityClassification(fpmlReportingRegime, fpmlParty, supervisoryBody).<EntityClassification>map("getEntityClassification", _partyEntityClassification -> _partyEntityClassification.getEntityClassification()).<String>map("getValue", entityClassification -> entityClassification.getValue()).checkedMap("to-enum", CFTCFinancialEntityClassificationEnum::fromDisplayName, IllegalArgumentException.class).get())
					.build());
			} else {
				cftcPartyInformation = null;
			}
			
			return Optional.ofNullable(cftcPartyInformation)
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
