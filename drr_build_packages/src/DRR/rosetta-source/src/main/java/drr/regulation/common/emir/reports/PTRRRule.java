package drr.regulation.common.emir.reports;

import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.IsCompressed;
import drr.regulation.common.functions.IsPortfolioRebalancing;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PTRRRule.PTRRRuleDefault.class)
public abstract class PTRRRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected IsCompressed isCompressed;
	@Inject protected IsPortfolioRebalancing isPortfolioRebalancing;
	@Inject protected TradeForEvent tradeForEvent;

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

	public static class PTRRRuleDefault extends PTRRRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<Boolean> ifThenElseResult;
			if (exists(MapperS.of(tradeForEvent.evaluate(thenArg.get()))).getOrDefault(false)) {
				ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(isCompressed.evaluate(thenArg.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isPortfolioRebalancing.evaluate(thenArg.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get())))).asMapper();
			} else {
				ifThenElseResult = MapperS.<Boolean>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
