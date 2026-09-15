package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.datetime.AdjustableDate;
import cdm.product.qualification.functions.Qualify_InterestRate_Fra;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.InterestRateLeg2;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import javax.inject.Inject;


@ImplementedBy(FinalContractualSettlementDateRule.FinalContractualSettlementDateRuleDefault.class)
public abstract class FinalContractualSettlementDateRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.execution.reports.FinalContractualSettlementDateRule finalContractualSettlementDateRule;
	@Inject protected InterestRateLeg2 interestRateLeg2;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_InterestRate_Fra qualify_InterestRate_Fra;
	@Inject protected TradeForEvent tradeForEvent;

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

	public static class FinalContractualSettlementDateRuleDefault extends FinalContractualSettlementDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					final Boolean _boolean = qualify_InterestRate_Fra.evaluate(MapperS.of(tradeForEvent.evaluate(item.get())).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
					if ((_boolean == null ? false : _boolean)) {
						return MapperS.of(interestRateLeg2.evaluate(productForTrade.evaluate(tradeForEvent.evaluate(item.get())))).<AdjustableDate>map("getPaymentDate", interestRatePayout -> interestRatePayout.getPaymentDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate());
					}
					return MapperS.of(finalContractualSettlementDateRule.evaluate(item.get()));
				}).get();
			
			return output;
		}
	}
}
