package drr.standards.iosco.cde.version1.quantity.reports;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.event.common.Trade;
import cdm.observable.asset.PriceQuantity;
import cdm.product.qualification.functions.Qualify_AssetClass_ForeignExchange;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Payout;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.quantity.functions.GetTradeForQuantity;
import drr.standards.iosco.cde.version1.quantity.functions.OptionAmountAndCurrency;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CallAmountRule.CallAmountRuleDefault.class)
public abstract class CallAmountRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;
	@Inject protected GetTradeForQuantity getTradeForQuantity;
	@Inject protected OptionAmountAndCurrency optionAmountAndCurrency;
	@Inject protected Qualify_AssetClass_ForeignExchange qualify_AssetClass_ForeignExchange;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstructionBase input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstructionBase input);

	public static class CallAmountRuleDefault extends CallAmountRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstructionBase input) {
			final MapperS<Trade> thenArg0 = MapperS.of(getTradeForQuantity.evaluate(input))
				.filterSingleNullSafe(item -> qualify_AssetClass_ForeignExchange.evaluate(item.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()));
			final MapperS<BigDecimal> thenArg1 = MapperS.of(optionAmountAndCurrency.evaluate(MapperS.of(economicTermsForProduct.evaluate(thenArg0.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get(), thenArg0.<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti(), OptionTypeEnum.CALL)).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue());
			final MapperS<BigDecimal> thenArg2 = MapperS.of(formatToShortFraction5DecimalNumber.evaluate(thenArg1.get()));
			final MapperS<BigDecimal> ifThenElseResult;
			if (greaterThan(thenArg2, MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = thenArg2;
			} else {
				ifThenElseResult = MapperS.<BigDecimal>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
