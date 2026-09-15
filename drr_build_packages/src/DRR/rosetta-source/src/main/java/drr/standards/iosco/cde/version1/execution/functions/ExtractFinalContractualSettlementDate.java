package drr.standards.iosco.cde.version1.execution.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.observable.asset.PerformanceValuationDates;
import cdm.observable.asset.ValuationDates;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.util.datetime.functions.AdjustableDateResolution;
import drr.base.util.datetime.functions.MaxAdjustableDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(ExtractFinalContractualSettlementDate.ExtractFinalContractualSettlementDateDefault.class)
public abstract class ExtractFinalContractualSettlementDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDateResolution adjustableDateResolution;
	@Inject protected CommoditySettlementDate commoditySettlementDate;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected FixedPriceSettlementDate fixedPriceSettlementDate;
	@Inject protected ForwardSettlementDate forwardSettlementDate;
	@Inject protected InterestRateSettlementDate interestRateSettlementDate;
	@Inject protected MaxAdjustableDate maxAdjustableDate;
	@Inject protected OptionSettlementDate optionSettlementDate;
	@Inject protected PerformanceSettlementDate performanceSettlementDate;

	/**
	* @param product 
	* @return date 
	*/
	public List<Date> evaluate(NonTransferableProduct product) {
		List<Date> date = doEvaluate(product);
		
		return date;
	}

	protected abstract List<Date> doEvaluate(NonTransferableProduct product);

	protected abstract MapperC<? extends FixedPricePayout> fixedPricePayout(NonTransferableProduct product);

	protected abstract MapperC<? extends CommodityPayout> commodityPayout(NonTransferableProduct product);

	protected abstract MapperC<? extends OptionPayout> optionPayout(NonTransferableProduct product);

	protected abstract MapperC<? extends InterestRatePayout> interestRatePayout(NonTransferableProduct product);

	protected abstract MapperC<? extends PerformancePayout> performancePayout(NonTransferableProduct product);

	protected abstract MapperC<? extends SettlementPayout> forwardPayout(NonTransferableProduct product);

	public static class ExtractFinalContractualSettlementDateDefault extends ExtractFinalContractualSettlementDate {
		@Override
		protected List<Date> doEvaluate(NonTransferableProduct product) {
			List<Date> date = new ArrayList<>();
			return assignOutput(date, product);
		}
		
		protected List<Date> assignOutput(List<Date> date, NonTransferableProduct product) {
			final MapperListOfLists<Date> thenArg0 = fixedPricePayout(product)
				.mapItemToList(item -> MapperC.<Date>of(fixedPriceSettlementDate.evaluate(item.get())));
			date.addAll(thenArg0
				.flattenList().getMulti());
			
			final MapperListOfLists<Date> thenArg1 = optionPayout(product)
				.mapItemToList(item -> MapperC.<Date>of(optionSettlementDate.evaluate(item.get())));
			date.addAll(thenArg1
				.flattenList().getMulti());
			
			final MapperListOfLists<Date> thenArg2 = commodityPayout(product)
				.mapItemToList(item -> MapperC.<Date>of(commoditySettlementDate.evaluate(item.get())));
			date.addAll(thenArg2
				.flattenList().getMulti());
			
			final MapperListOfLists<Date> thenArg3 = interestRatePayout(product)
				.mapItemToList(item -> MapperC.<Date>of(interestRateSettlementDate.evaluate(item.get())));
			date.addAll(thenArg3
				.flattenList().getMulti());
			
			final MapperListOfLists<Date> thenArg4 = performancePayout(product)
				.mapItemToList(item -> MapperC.<Date>of(performanceSettlementDate.evaluate(item.get())));
			date.addAll(thenArg4
				.flattenList().getMulti());
			
			final MapperListOfLists<Date> thenArg5 = forwardPayout(product)
				.mapItemToList(item -> MapperC.<Date>of(forwardSettlementDate.evaluate(item.get())));
			date.addAll(thenArg5
				.flattenList().getMulti());
			
			final Date date0 = adjustableDateResolution.evaluate(MapperS.of(economicTermsForProduct.evaluate(product)).<AdjustableOrRelativeDate>map("getTerminationDate", economicTerms -> economicTerms.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get());
			if (date0 == null) {
				date.addAll(Collections.<Date>emptyList());
			} else {
				date.addAll(Collections.singletonList(date0));
			}
			
			final Date date1 = maxAdjustableDate.evaluate(performancePayout(product).<ValuationDates>map("getValuationDates", _performancePayout -> _performancePayout.getValuationDates()).<PerformanceValuationDates>map("getFinalValuationDate", valuationDates -> valuationDates.getFinalValuationDate()).<AdjustableOrRelativeDate>map("getValuationDate", performanceValuationDates -> performanceValuationDates.getValuationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get(), interestRatePayout(product).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getTerminationDate", calculationPeriodDates -> calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get());
			if (date1 == null) {
				date.addAll(Collections.<Date>emptyList());
			} else {
				date.addAll(Collections.singletonList(date1));
			}
			
			return date;
		}
		
		@Override
		protected MapperC<? extends FixedPricePayout> fixedPricePayout(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout());
		}
		
		@Override
		protected MapperC<? extends CommodityPayout> commodityPayout(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout());
		}
		
		@Override
		protected MapperC<? extends OptionPayout> optionPayout(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout());
		}
		
		@Override
		protected MapperC<? extends InterestRatePayout> interestRatePayout(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout());
		}
		
		@Override
		protected MapperC<? extends PerformancePayout> performancePayout(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout());
		}
		
		@Override
		protected MapperC<? extends SettlementPayout> forwardPayout(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout());
		}
	}
}
