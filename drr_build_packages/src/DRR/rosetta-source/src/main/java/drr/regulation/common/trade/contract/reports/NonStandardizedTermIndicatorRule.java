package drr.regulation.common.trade.contract.reports;

import cdm.event.common.Trade;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NonStandardizedTermIndicatorRule.NonStandardizedTermIndicatorRuleDefault.class)
public abstract class NonStandardizedTermIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ProductForTrade productForTrade;
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

	public static class NonStandardizedTermIndicatorRuleDefault extends NonStandardizedTermIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<Trade> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(tradeForEvent.evaluate(item.get())));
			final MapperS<NonTransferableProduct> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(productForTrade.evaluate(item.get())));
			output = thenArg1
				.mapSingleToItem(item -> {
					if (exists(item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Boolean>map("getNonStandardisedTerms", economicTerms -> economicTerms.getNonStandardisedTerms())).getOrDefault(false)) {
						return item.<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Boolean>map("getNonStandardisedTerms", economicTerms -> economicTerms.getNonStandardisedTerms());
					}
					return MapperS.of(false);
				}).get();
			
			return output;
		}
	}
}
