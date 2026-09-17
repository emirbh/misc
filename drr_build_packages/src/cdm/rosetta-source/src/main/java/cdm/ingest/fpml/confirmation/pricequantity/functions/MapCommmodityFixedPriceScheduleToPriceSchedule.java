package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.DatedValue;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import cdm.ingest.fpml.confirmation.common.functions.MapUnitTypeWithScheme;
import cdm.observable.asset.CashPrice;
import cdm.observable.asset.CashPriceTypeEnum;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommmodityFixedPriceScheduleToPriceSchedule.MapCommmodityFixedPriceScheduleToPriceScheduleDefault.class)
public abstract class MapCommmodityFixedPriceScheduleToPriceSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;
	@Inject protected MapUnitTypeWithScheme mapUnitTypeWithScheme;

	/**
	* @param fpmlCommodityFixedPriceSchedule 
	* @return priceSchedule 
	*/
	public PriceSchedule evaluate(CommodityFixedPriceSchedule fpmlCommodityFixedPriceSchedule) {
		PriceSchedule.PriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlCommodityFixedPriceSchedule);
		
		final PriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(PriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(CommodityFixedPriceSchedule fpmlCommodityFixedPriceSchedule);

	protected abstract MapperS<? extends CommodityFixedPrice> fixedPriceStep(CommodityFixedPriceSchedule fpmlCommodityFixedPriceSchedule);

	protected abstract MapperS<? extends UnitType> unit(CommodityFixedPriceSchedule fpmlCommodityFixedPriceSchedule);

	protected abstract MapperS<? extends UnitType> perUnitOf(CommodityFixedPriceSchedule fpmlCommodityFixedPriceSchedule);

	public static class MapCommmodityFixedPriceScheduleToPriceScheduleDefault extends MapCommmodityFixedPriceScheduleToPriceSchedule {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(CommodityFixedPriceSchedule fpmlCommodityFixedPriceSchedule) {
			PriceSchedule.PriceScheduleBuilder priceSchedule = PriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlCommodityFixedPriceSchedule);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder priceSchedule, CommodityFixedPriceSchedule fpmlCommodityFixedPriceSchedule) {
			priceSchedule = toBuilder(PriceSchedule.builder()
				.setDatedValue(MapperS.of(fpmlCommodityFixedPriceSchedule).<CommodityFixedPrice>mapC("getFixedPriceStep", commodityFixedPriceSchedule -> commodityFixedPriceSchedule.getFixedPriceStep())
					.mapItem(item -> MapperS.of(DatedValue.builder()
						.setDate(null)
						.setValue(item.<BigDecimal>map("getPrice", commodityFixedPrice -> commodityFixedPrice.getPrice()).get())
						.build())).getMulti())
				.setUnit(unit(fpmlCommodityFixedPriceSchedule).get())
				.setPerUnitOf(perUnitOf(fpmlCommodityFixedPriceSchedule).get())
				.setPriceType(PriceTypeEnum.CASH_PRICE)
				.setCashPrice(CashPrice.builder()
					.setCashPriceType(CashPriceTypeEnum.FEE)
					.build())
				.build());
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CommodityFixedPrice> fixedPriceStep(CommodityFixedPriceSchedule fpmlCommodityFixedPriceSchedule) {
			return MapperS.of(fpmlCommodityFixedPriceSchedule).<CommodityFixedPrice>mapC("getFixedPriceStep", commodityFixedPriceSchedule -> commodityFixedPriceSchedule.getFixedPriceStep())
				.first();
		}
		
		@Override
		protected MapperS<? extends UnitType> unit(CommodityFixedPriceSchedule fpmlCommodityFixedPriceSchedule) {
			return MapperS.of(UnitType.builder()
				.setCurrency(mapStringWithScheme.evaluate(fixedPriceStep(fpmlCommodityFixedPriceSchedule).<Currency>map("getPriceCurrency", commodityFixedPrice -> commodityFixedPrice.getPriceCurrency()).<String>map("getValue", currency -> currency.getValue()).get(), fixedPriceStep(fpmlCommodityFixedPriceSchedule).<Currency>map("getPriceCurrency", commodityFixedPrice -> commodityFixedPrice.getPriceCurrency()).<String>map("getCurrencyScheme", currency -> currency.getCurrencyScheme()).get()))
				.build());
		}
		
		@Override
		protected MapperS<? extends UnitType> perUnitOf(CommodityFixedPriceSchedule fpmlCommodityFixedPriceSchedule) {
			return MapperS.of(mapUnitTypeWithScheme.evaluate(fixedPriceStep(fpmlCommodityFixedPriceSchedule).<QuantityUnit>map("getPriceUnit", commodityFixedPrice -> commodityFixedPrice.getPriceUnit()).<String>map("getValue", quantityUnit -> quantityUnit.getValue()).get(), fixedPriceStep(fpmlCommodityFixedPriceSchedule).<QuantityUnit>map("getPriceUnit", commodityFixedPrice -> commodityFixedPrice.getPriceUnit()).<String>map("getQuantityUnitScheme", quantityUnit -> quantityUnit.getQuantityUnitScheme()).get()));
		}
	}
}
