package drr.regulation.esma.emir.refit.trade.reports;

import cdm.event.common.Trade;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(HasContractRule.HasContractRuleDefault.class)
public abstract class HasContractRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
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

	public static class HasContractRuleDefault extends HasContractRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<Trade> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(tradeForEvent.evaluate(item.get())));
			output = thenArg
				.mapSingleToItem(item -> exists(item.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct())).asMapper()).get();
			
			return output;
		}
	}
}
