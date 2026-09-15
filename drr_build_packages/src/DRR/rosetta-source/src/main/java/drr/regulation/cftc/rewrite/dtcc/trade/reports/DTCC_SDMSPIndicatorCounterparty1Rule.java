package drr.regulation.cftc.rewrite.dtcc.trade.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.CFTCEntityClassificationEnum;
import drr.regulation.common.CFTCPartyInformation;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_SDMSPIndicatorCounterparty1Rule.DTCC_SDMSPIndicatorCounterparty1RuleDefault.class)
public abstract class DTCC_SDMSPIndicatorCounterparty1Rule implements ReportFunction<TransactionReportInstruction, List<Boolean>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<Boolean> evaluate(TransactionReportInstruction input) {
		List<Boolean> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<Boolean> doEvaluate(TransactionReportInstruction input);

	public static class DTCC_SDMSPIndicatorCounterparty1RuleDefault extends DTCC_SDMSPIndicatorCounterparty1Rule {
		@Override
		protected List<Boolean> doEvaluate(TransactionReportInstruction input) {
			List<Boolean> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<Boolean> assignOutput(List<Boolean> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToList(reportInstruction -> {
					final MapperC<ReportableJurisdictionInformation> thenArg0 = reportInstruction.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
					final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
						.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.CFTC), CardinalityOperator.All).get());
					final MapperS<ReportableJurisdictionInformation> thenArg2 = MapperS.of(thenArg1.get());
					final MapperC<JurisdictionPartyInformation> thenArg3 = thenArg2
						.mapSingleToList(item -> item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()));
					final MapperC<JurisdictionPartyInformation> thenArg4 = thenArg3
						.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), reportInstruction.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
					final MapperC<CFTCPartyInformation> thenArg5 = thenArg4
						.mapItem(item -> item.<CFTCPartyInformation>map("getCftcPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getCftcPartyInformation()));
					final MapperC<CFTCPartyInformation> thenArg6 = thenArg5
						.filterItemNullSafe(item -> exists(item.<CFTCEntityClassificationEnum>map("getOrganizationType", cFTCPartyInformation -> cFTCPartyInformation.getOrganizationType())).get());
					return thenArg6
						.mapItem(item -> {
							if (areEqual(item.<CFTCEntityClassificationEnum>map("getOrganizationType", cFTCPartyInformation -> cFTCPartyInformation.getOrganizationType()), MapperS.of(CFTCEntityClassificationEnum.SD), CardinalityOperator.All).orNullSafe(areEqual(item.<CFTCEntityClassificationEnum>map("getOrganizationType", cFTCPartyInformation -> cFTCPartyInformation.getOrganizationType()), MapperS.of(CFTCEntityClassificationEnum.MSP), CardinalityOperator.All)).getOrDefault(false)) {
								return MapperS.of(true);
							}
							return MapperS.of(false);
						});
				}).getMulti();
			
			return output;
		}
	}
}
