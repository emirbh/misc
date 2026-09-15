package drr.regulation.sec.rewrite.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsCleared;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CFTCFinancialEntityClassificationEnum;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SECPartyInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.party.functions.ExtractRegimeInformation;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty1FinancialEntityIndicatorRule.Counterparty1FinancialEntityIndicatorRuleDefault.class)
public abstract class Counterparty1FinancialEntityIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractRegimeInformation extractRegimeInformation;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;
	@Inject protected IsCleared isCleared;

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

	public static class Counterparty1FinancialEntityIndicatorRuleDefault extends Counterparty1FinancialEntityIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			final MapperS<Boolean> ifThenElseResult1;
			if (areEqual(MapperS.of(isCleared.evaluate(thenArg0.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				final MapperS<JurisdictionPartyInformation> thenArg1 = thenArg0
					.mapSingleToItem(item -> {
						final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
						return MapperS.of(extractRegimeInformation.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), RegimeNameEnum.DODD_FRANK_ACT, SupervisoryBodyEnum.SEC));
					});
				final MapperS<Boolean> ifThenElseResult0;
				if (exists(thenArg1.<SECPartyInformation>map("getSecPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getSecPartyInformation()).<CFTCFinancialEntityClassificationEnum>map("getFinancialEntity", sECPartyInformation -> sECPartyInformation.getFinancialEntity())).getOrDefault(false)) {
					ifThenElseResult0 = MapperS.of(true);
				} else {
					ifThenElseResult0 = MapperS.of(false);
				}
				ifThenElseResult1 = ifThenElseResult0;
			} else {
				ifThenElseResult1 = MapperS.<Boolean>ofNull();
			}
			output = ifThenElseResult1.get();
			
			return output;
		}
	}
}
