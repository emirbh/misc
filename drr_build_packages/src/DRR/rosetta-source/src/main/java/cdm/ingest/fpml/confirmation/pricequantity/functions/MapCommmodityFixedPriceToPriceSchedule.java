package cdm.ingest.fpml.confirmation.pricequantity.functions;

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
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommmodityFixedPriceToPriceSchedule.MapCommmodityFixedPriceToPriceScheduleDefault.class)
public abstract class MapCommmodityFixedPriceToPriceSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;
	@Inject protected MapUnitTypeWithScheme mapUnitTypeWithScheme;

	/**
	* @param fpmlCommodityFixedPrice 
	* @return priceSchedule 
	*/
	public PriceSchedule evaluate(CommodityFixedPrice fpmlCommodityFixedPrice) {
		PriceSchedule.PriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlCommodityFixedPrice);
		
		final PriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(PriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(CommodityFixedPrice fpmlCommodityFixedPrice);

	protected abstract MapperS<? extends UnitType> unit(CommodityFixedPrice fpmlCommodityFixedPrice);

	protected abstract MapperS<? extends UnitType> perUnitOf(CommodityFixedPrice fpmlCommodityFixedPrice);

	public static class MapCommmodityFixedPriceToPriceScheduleDefault extends MapCommmodityFixedPriceToPriceSchedule {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(CommodityFixedPrice fpmlCommodityFixedPrice) {
			PriceSchedule.PriceScheduleBuilder priceSchedule = PriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlCommodityFixedPrice);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder priceSchedule, CommodityFixedPrice fpmlCommodityFixedPrice) {
			priceSchedule = toBuilder(PriceSchedule.builder()
				.setValue(MapperS.of(fpmlCommodityFixedPrice).<BigDecimal>map("getPrice", commodityFixedPrice -> commodityFixedPrice.getPrice()).get())
				.setUnit(unit(fpmlCommodityFixedPrice).get())
				.setPerUnitOf(perUnitOf(fpmlCommodityFixedPrice).get())
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
		protected MapperS<? extends UnitType> unit(CommodityFixedPrice fpmlCommodityFixedPrice) {
			return MapperS.of(UnitType.builder()
				.setCurrency(mapStringWithScheme.evaluate(MapperS.of(fpmlCommodityFixedPrice).<Currency>map("getPriceCurrency", commodityFixedPrice -> commodityFixedPrice.getPriceCurrency()).<String>map("getValue", currency -> currency.getValue()).get(), MapperS.of(fpmlCommodityFixedPrice).<Currency>map("getPriceCurrency", commodityFixedPrice -> commodityFixedPrice.getPriceCurrency()).<String>map("getCurrencyScheme", currency -> currency.getCurrencyScheme()).get()))
				.build());
		}
		
		@Override
		protected MapperS<? extends UnitType> perUnitOf(CommodityFixedPrice fpmlCommodityFixedPrice) {
			return MapperS.of(mapUnitTypeWithScheme.evaluate(MapperS.of(fpmlCommodityFixedPrice).<QuantityUnit>map("getPriceUnit", commodityFixedPrice -> commodityFixedPrice.getPriceUnit()).<String>map("getValue", quantityUnit -> quantityUnit.getValue()).get(), MapperS.of(fpmlCommodityFixedPrice).<QuantityUnit>map("getPriceUnit", commodityFixedPrice -> commodityFixedPrice.getPriceUnit()).<String>map("getQuantityUnitScheme", quantityUnit -> quantityUnit.getQuantityUnitScheme()).get()));
		}
	}
}
