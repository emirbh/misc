package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.reports.ContractTypeRule;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import drr.standards.iso.OptionTypeCode;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OptionTypeRule.OptionTypeRuleDefault.class)
public abstract class OptionTypeRule implements ReportFunction<TransactionReportInstruction, OptionTypeCode> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ContractTypeRule contractTypeRule;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected drr.regulation.common.trade.contract.reports.OptionTypeRule optionTypeRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public OptionTypeCode evaluate(TransactionReportInstruction input) {
		OptionTypeCode output = doEvaluate(input);
		
		return output;
	}

	protected abstract OptionTypeCode doEvaluate(TransactionReportInstruction input);

	public static class OptionTypeRuleDefault extends OptionTypeRule {
		@Override
		protected OptionTypeCode doEvaluate(TransactionReportInstruction input) {
			OptionTypeCode output = null;
			return assignOutput(output, input);
		}
		
		protected OptionTypeCode assignOutput(OptionTypeCode output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(MapperS.of(contractTypeRule.evaluate(item.get())), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(contractTypeRule.evaluate(item.get())), MapperS.of(CommonContractType.SWPT), CardinalityOperator.All)).get());
			output = thenArg1
				.mapSingleToItem(item -> MapperS.of(optionTypeRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
