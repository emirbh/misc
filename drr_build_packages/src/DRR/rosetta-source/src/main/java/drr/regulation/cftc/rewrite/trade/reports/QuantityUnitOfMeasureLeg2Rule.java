package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.standards.iosco.cde.version2.quantity.reports.QuantityUnitOfMeasureRule;
import javax.inject.Inject;


@ImplementedBy(QuantityUnitOfMeasureLeg2Rule.QuantityUnitOfMeasureLeg2RuleDefault.class)
public abstract class QuantityUnitOfMeasureLeg2Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
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
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(quantityUnitOfMeasureRule.evaluate(payoutLeg2Rule.evaluate(item.get())))).get();
			
			return output;
		}
	}
}
