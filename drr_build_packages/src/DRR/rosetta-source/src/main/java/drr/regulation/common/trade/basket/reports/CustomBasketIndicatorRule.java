package drr.regulation.common.trade.basket.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.basket.reports.CustomBasketCodeRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CustomBasketIndicatorRule.CustomBasketIndicatorRuleDefault.class)
public abstract class CustomBasketIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CustomBasketCodeRule customBasketCodeRule;

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

	public static class CustomBasketIndicatorRuleDefault extends CustomBasketIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> exists(MapperS.of(customBasketCodeRule.evaluate(item.get()))).asMapper()).get();
			
			return output;
		}
	}
}
