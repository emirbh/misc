package drr.standards.iosco.cde.version1.datetime.reports;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaDate;
import drr.base.qualification.product.functions.IsProductOTC;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.PositionForEvent;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.base.util.datetime.functions.AdjustableDateResolution;
import java.time.LocalDateTime;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EffectiveDateRule.EffectiveDateRuleDefault.class)
public abstract class EffectiveDateRule implements ReportFunction<TransactionReportInstructionBase, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDateResolution adjustableDateResolution;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsProductOTC isProductOTC;
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstructionBase input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstructionBase input);

	public static class EffectiveDateRuleDefault extends EffectiveDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstructionBase input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get()))).<AdjustableOrRelativeDate>map("getEffectiveDate", economicTerms -> economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isProductOTC.evaluate(productForEvent.evaluate(item.get()))))).getOrDefault(false)) {
						return MapperS.of(adjustableDateResolution.evaluate(MapperS.of(productForEvent.evaluate(item.get())).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<AdjustableOrRelativeDate>map("getEffectiveDate", economicTerms -> economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get()));
					}
					if (exists(MapperS.of(productForEvent.evaluate(item.get())).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", calculationPeriodDates -> calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())).getOrDefault(false)) {
						final MapperC<Date> thenArg = MapperS.of(productForEvent.evaluate(item.get())).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", calculationPeriodDates -> calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())
							.mapItem(_item -> MapperS.of(adjustableDateResolution.evaluate(_item.get())));
						return thenArg
							.min();
					}
					if (exists(MapperS.of(tradeForEvent.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(tradeForEvent.evaluate(item.get())).<FieldWithMetaDate>map("getTradeDate", trade -> trade.getTradeDate()).<Date>map("Type coercion", fieldWithMetaDate -> fieldWithMetaDate == null ? null : fieldWithMetaDate.getValue());
					}
					if (exists(MapperS.of(positionForEvent.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(positionForEvent.evaluate(item.get())).<LocalDateTime>map("getOpenDateTime", counterpartyPosition -> counterpartyPosition.getOpenDateTime()).<Date>map("Date", dt -> Date.of(dt.toLocalDate()));
					}
					return MapperS.<Date>ofNull();
				}).get();
			
			return output;
		}
	}
}
