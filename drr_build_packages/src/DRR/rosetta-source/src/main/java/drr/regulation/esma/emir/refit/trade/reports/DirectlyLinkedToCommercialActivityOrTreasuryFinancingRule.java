package drr.regulation.esma.emir.refit.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ESMAPartyInformation;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.party.functions.ExtractRegimeInformation;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DirectlyLinkedToCommercialActivityOrTreasuryFinancingRule.DirectlyLinkedToCommercialActivityOrTreasuryFinancingRuleDefault.class)
public abstract class DirectlyLinkedToCommercialActivityOrTreasuryFinancingRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractRegimeInformation extractRegimeInformation;
	@Inject protected IsAllowableAction isAllowableAction;

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

	public static class DirectlyLinkedToCommercialActivityOrTreasuryFinancingRuleDefault extends DirectlyLinkedToCommercialActivityOrTreasuryFinancingRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<JurisdictionPartyInformation> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperS.of(extractRegimeInformation.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), RegimeNameEnum.EMIR, SupervisoryBodyEnum.ESMA));
				});
			final MapperS<JurisdictionPartyInformation> thenArg2 = thenArg1
				.filterSingleNullSafe(item -> areEqual(item.<ESMAPartyInformation>map("getEsmaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getEsmaPartyInformation()).<NatureOfPartyEnum>map("getNatureOfParty", eSMAPartyInformation -> eSMAPartyInformation.getNatureOfParty()), MapperS.of(NatureOfPartyEnum.NON_FINANCIAL), CardinalityOperator.All).get());
			output = thenArg2
				.mapSingleToItem(item -> item.<ESMAPartyInformation>map("getEsmaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getEsmaPartyInformation()).<Boolean>map("getDirectlyLinkedActivity", eSMAPartyInformation -> eSMAPartyInformation.getDirectlyLinkedActivity())).get();
			
			return output;
		}
	}
}
