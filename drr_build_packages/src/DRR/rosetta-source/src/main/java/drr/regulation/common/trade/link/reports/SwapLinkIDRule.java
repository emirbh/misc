package drr.regulation.common.trade.link.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsFXSwap;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.link.reports.PackageIdentifierRule;
import javax.inject.Inject;


@ImplementedBy(SwapLinkIDRule.SwapLinkIDRuleDefault.class)
public abstract class SwapLinkIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsFXSwap isFXSwap;
	@Inject protected PackageIdentifierRule packageIdentifierRule;
	@Inject protected ProductForEvent productForEvent;

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

	public static class SwapLinkIDRuleDefault extends SwapLinkIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final Boolean _boolean = isFXSwap.evaluate(productForEvent.evaluate(input));
			if ((_boolean == null ? false : _boolean)) {
				output = packageIdentifierRule.evaluate(input);
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
