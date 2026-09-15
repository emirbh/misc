package drr.regulation.sec.rewrite.trade.reports;

import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import javax.inject.Inject;


@ImplementedBy(ExpirationDateRule.ExpirationDateRuleDefault.class)
public abstract class ExpirationDateRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.datetime.reports.ExpirationDateRule expirationDateRule;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;
	@Inject protected ProductForEvent productForEvent;

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

	public static class ExpirationDateRuleDefault extends ExpirationDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			final MapperS<NonTransferableProduct> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			output = thenArg1
				.mapSingleToItem(item -> MapperS.of(expirationDateRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
