package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.reports.ContractTypeRule;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FirstExerciseDateRule.FirstExerciseDateRuleDefault.class)
public abstract class FirstExerciseDateRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ContractTypeRule contractTypeRule;
	@Inject protected drr.standards.iosco.cde.version3.price.reports.FirstExerciseDateRule firstExerciseDateRule;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstruction input);

	public static class FirstExerciseDateRuleDefault extends FirstExerciseDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(MapperS.of(contractTypeRule.evaluate(item.get())), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(contractTypeRule.evaluate(item.get())), MapperS.of(CommonContractType.SWPT), CardinalityOperator.All)).get());
			output = MapperS.of(firstExerciseDateRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
