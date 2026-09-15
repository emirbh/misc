package drr.standards.iosco.cde.version1.price.functions;

import cdm.observable.asset.PriceSchedule;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommodityOption;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.base.trade.price.DefaultingType;
import drr.base.trade.price.PricePeriod;
import drr.base.trade.price.functions.ReportablePricePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(ReportableStrikePricePeriod.ReportableStrikePricePeriodDefault.class)
public abstract class ReportableStrikePricePeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommodityOption isCommodityOption;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected ReportablePricePeriod reportablePricePeriod;
	@Inject protected StrikePrice strikePrice;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @param defaultingType 
	* @return reportablePeriod 
	*/
	public List<? extends PricePeriod> evaluate(ReportableEventBase reportableEvent, DefaultingType defaultingType) {
		List<PricePeriod.PricePeriodBuilder> reportablePeriodBuilder = doEvaluate(reportableEvent, defaultingType);
		
		final List<? extends PricePeriod> reportablePeriod;
		if (reportablePeriodBuilder == null) {
			reportablePeriod = null;
		} else {
			reportablePeriod = reportablePeriodBuilder.stream().map(PricePeriod::build).collect(Collectors.toList());
			objectValidator.validate(PricePeriod.class, reportablePeriod);
		}
		
		return reportablePeriod;
	}

	protected abstract List<PricePeriod.PricePeriodBuilder> doEvaluate(ReportableEventBase reportableEvent, DefaultingType defaultingType);

	protected abstract MapperS<? extends CalculationSchedule> customizedSchedule(ReportableEventBase reportableEvent, DefaultingType defaultingType);

	protected abstract MapperS<? extends PriceSchedule> strikePriceSchedule(ReportableEventBase reportableEvent, DefaultingType defaultingType);

	public static class ReportableStrikePricePeriodDefault extends ReportableStrikePricePeriod {
		@Override
		protected List<PricePeriod.PricePeriodBuilder> doEvaluate(ReportableEventBase reportableEvent, DefaultingType defaultingType) {
			List<PricePeriod.PricePeriodBuilder> reportablePeriod = new ArrayList<>();
			return assignOutput(reportablePeriod, reportableEvent, defaultingType);
		}
		
		protected List<PricePeriod.PricePeriodBuilder> assignOutput(List<PricePeriod.PricePeriodBuilder> reportablePeriod, ReportableEventBase reportableEvent, DefaultingType defaultingType) {
			reportablePeriod.addAll(toBuilder(reportablePricePeriod.evaluate(strikePriceSchedule(reportableEvent, defaultingType).get(), customizedSchedule(reportableEvent, defaultingType).get(), null)));
			
			return Optional.ofNullable(reportablePeriod)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CalculationSchedule> customizedSchedule(ReportableEventBase reportableEvent, DefaultingType defaultingType) {
			if (ComparisonResult.ofNullSafe(MapperS.of(isCommodityOption.evaluate(productForTrade.evaluate(tradeForEvent.evaluate(reportableEvent))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swaption.evaluate(economicTermsForProduct.evaluate(productForTrade.evaluate(tradeForEvent.evaluate(reportableEvent))))))).getOrDefault(false)) {
				return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForTrade.evaluate(tradeForEvent.evaluate(reportableEvent)))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<CalculationSchedule>map("getSchedule", optionPayout -> optionPayout.getSchedule()).get());
			}
			return MapperS.<CalculationSchedule>ofNull();
		}
		
		@Override
		protected MapperS<? extends PriceSchedule> strikePriceSchedule(ReportableEventBase reportableEvent, DefaultingType defaultingType) {
			return MapperS.of(strikePrice.evaluate(reportableEvent));
		}
	}
}
