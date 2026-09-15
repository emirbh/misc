package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import drr.standards.iosco.cde.version3.quantity.reports.QuantityUnitOfMeasureRule;
import javax.inject.Inject;


@ImplementedBy(QuantityUnitOfMeasureLeg2Rule.QuantityUnitOfMeasureLeg2RuleDefault.class)
public abstract class QuantityUnitOfMeasureLeg2Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected QuantityUnitOfMeasureRule quantityUnitOfMeasureRule;

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

	public static class QuantityUnitOfMeasureLeg2RuleDefault extends QuantityUnitOfMeasureLeg2Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			output = MapperS.of(quantityUnitOfMeasureRule.evaluate(payoutLeg2Rule.evaluate(thenArg.get()))).get();
			
			return output;
		}
	}
}
