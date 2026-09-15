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
import drr.regulation.common.CFTCPartyInformation;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_PhysicalCommodityContractIndicatorRule.DTCC_PhysicalCommodityContractIndicatorRuleDefault.class)
public abstract class DTCC_PhysicalCommodityContractIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class DTCC_PhysicalCommodityContractIndicatorRuleDefault extends DTCC_PhysicalCommodityContractIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(reportInstruction -> {
					final MapperC<ReportableJurisdictionInformation> thenArg0 = reportInstruction.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
					final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
						.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.CFTC), CardinalityOperator.All).get());
					final MapperS<ReportableJurisdictionInformation> thenArg2 = MapperS.of(thenArg1.get());
					final MapperC<JurisdictionPartyInformation> thenArg3 = thenArg2
						.mapSingleToList(item -> item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()));
					final MapperC<JurisdictionPartyInformation> thenArg4 = thenArg3
						.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), reportInstruction.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
					final MapperS<JurisdictionPartyInformation> thenArg5 = MapperS.of(thenArg4.get());
					return thenArg5
						.mapSingleToItem(item -> {
							if (exists(item.<CFTCPartyInformation>map("getCftcPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getCftcPartyInformation()).<Boolean>map("getPhysicalCommodityContractIndicator", cFTCPartyInformation -> cFTCPartyInformation.getPhysicalCommodityContractIndicator())).getOrDefault(false)) {
								return item.<CFTCPartyInformation>map("getCftcPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getCftcPartyInformation()).<Boolean>map("getPhysicalCommodityContractIndicator", cFTCPartyInformation -> cFTCPartyInformation.getPhysicalCommodityContractIndicator());
							}
							return MapperS.of(false);
						});
				}).get();
			
			return output;
		}
	}
}
