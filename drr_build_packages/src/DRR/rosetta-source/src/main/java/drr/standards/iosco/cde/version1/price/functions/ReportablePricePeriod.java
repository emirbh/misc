package drr.standards.iosco.cde.version1.price.functions;

import cdm.base.math.DatedValue;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.asset.CommodityPayout;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Option;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradableProduct;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.PositionForEvent;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.base.trade.price.DefaultingType;
import drr.base.trade.price.PricePeriod;
import drr.base.trade.price.functions.SingleTradeLot;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReportablePricePeriod.ReportablePricePeriodDefault.class)
public abstract class ReportablePricePeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected drr.base.trade.price.functions.ReportablePricePeriod reportablePricePeriod;
	@Inject protected SingleTradeLot singleTradeLot;
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

	protected abstract MapperC<? extends FieldWithMetaPriceSchedule> priceSchedule(ReportableEventBase reportableEvent, DefaultingType defaultingType);

	public static class ReportablePricePeriodDefault extends ReportablePricePeriod {
		@Override
		protected List<PricePeriod.PricePeriodBuilder> doEvaluate(ReportableEventBase reportableEvent, DefaultingType defaultingType) {
			List<PricePeriod.PricePeriodBuilder> reportablePeriod = new ArrayList<>();
			return assignOutput(reportablePeriod, reportableEvent, defaultingType);
		}
		
		protected List<PricePeriod.PricePeriodBuilder> assignOutput(List<PricePeriod.PricePeriodBuilder> reportablePeriod, ReportableEventBase reportableEvent, DefaultingType defaultingType) {
			final MapperC<? extends FieldWithMetaPriceSchedule> thenArg0 = priceSchedule(reportableEvent, defaultingType);
			final MapperListOfLists<PricePeriod> thenArg1 = thenArg0
				.mapItemToList(item -> {
					final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule = item.get();
					return MapperC.<PricePeriod>of(reportablePricePeriod.evaluate((fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()), customizedSchedule(reportableEvent, defaultingType).get(), defaultingType));
				});
			reportablePeriod.addAll(toBuilder(thenArg1
				.flattenList().getMulti()));
			
			return Optional.ofNullable(reportablePeriod)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CalculationSchedule> customizedSchedule(ReportableEventBase reportableEvent, DefaultingType defaultingType) {
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent)))))).getOrDefault(false)) {
				return MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule())
					.first();
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Option.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swaption.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent)))))).getOrDefault(false)) {
				return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<CalculationSchedule>map("getSchedule", optionPayout -> optionPayout.getSchedule());
			}
			final Boolean _boolean = qualify_Commodity_Forward.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent)));
			if ((_boolean == null ? false : _boolean)) {
				return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<CalculationSchedule>map("getSchedule", settlementPayout -> settlementPayout.getSchedule());
			}
			return MapperS.<CalculationSchedule>ofNull();
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaPriceSchedule> priceSchedule(ReportableEventBase reportableEvent, DefaultingType defaultingType) {
			if (exists(MapperS.of(tradeForEvent.evaluate(reportableEvent))).getOrDefault(false)) {
				return MapperS.of(singleTradeLot.evaluate(tradeForEvent.evaluate(reportableEvent))).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())
					.filterItemNullSafe(item -> exists(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<DatedValue>mapC("getDatedValue", _priceSchedule -> _priceSchedule.getDatedValue())).get());
			}
			if (exists(MapperS.of(positionForEvent.evaluate(reportableEvent))).getOrDefault(false)) {
				return MapperS.of(MapperS.of(positionForEvent.evaluate(reportableEvent)).<TradableProduct>map("getPositionBase", counterpartyPosition -> counterpartyPosition.getPositionBase()).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())
					.filterItemNullSafe(item -> exists(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<DatedValue>mapC("getDatedValue", _priceSchedule -> _priceSchedule.getDatedValue())).get());
			}
			return MapperC.<FieldWithMetaPriceSchedule>ofNull();
		}
	}
}
