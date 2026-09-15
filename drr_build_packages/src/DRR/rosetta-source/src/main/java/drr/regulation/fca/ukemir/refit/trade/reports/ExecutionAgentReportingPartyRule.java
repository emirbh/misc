package drr.regulation.fca.ukemir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.qualification.event.functions.IsActionTypeVALU;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.party.reports.ExecutionAgentCounterparty1Rule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExecutionAgentReportingPartyRule.ExecutionAgentReportingPartyRuleDefault.class)
public abstract class ExecutionAgentReportingPartyRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExecutionAgentCounterparty1Rule executionAgentCounterparty1Rule;
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsActionTypeVALU isActionTypeVALU;
	@Inject protected IsAllowableAction isAllowableAction;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class ExecutionAgentReportingPartyRuleDefault extends ExecutionAgentReportingPartyRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableAction.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeEROR.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeVALU.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).get());
			output = thenArg
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(executionAgentCounterparty1Rule.evaluate(item.get())), MapperS.of("NOAP"), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.<String>ofNull();
					}
					return MapperS.of(executionAgentCounterparty1Rule.evaluate(item.get()));
				}).get();
			
			return output;
		}
	}
}
