package drr.standards.iosco.cde.version3.datetime.reports;

import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import javax.inject.Inject;


@ImplementedBy(ExpirationDateRule.ExpirationDateRuleDefault.class)
public abstract class ExpirationDateRule implements ReportFunction<NonTransferableProduct, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.datetime.reports.ExpirationDateRule expirationDateRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(NonTransferableProduct input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(NonTransferableProduct input);

	public static class ExpirationDateRuleDefault extends ExpirationDateRule {
		@Override
		protected Date doEvaluate(NonTransferableProduct input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, NonTransferableProduct input) {
			output = expirationDateRule.evaluate(input);
			
			return output;
		}
	}
}
