package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.UnitType;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.com.CommoditySpread;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySpreadToPriceWithLocation.MapCommoditySpreadToPriceWithLocationDefault.class)
public abstract class MapCommoditySpreadToPriceWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;

	/**
	* @param fpmlCommoditySpread 
	* @param capacityUnit 
	* @param fpmlLeg 
	* @return priceSchedule 
	*/
	public FieldWithMetaPriceSchedule evaluate(CommoditySpread fpmlCommoditySpread, CapacityUnitEnum capacityUnit, Leg fpmlLeg) {
		FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlCommoditySpread, capacityUnit, fpmlLeg);
		
		final FieldWithMetaPriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaPriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(CommoditySpread fpmlCommoditySpread, CapacityUnitEnum capacityUnit, Leg fpmlLeg);

	public static class MapCommoditySpreadToPriceWithLocationDefault extends MapCommoditySpreadToPriceWithLocation {
		@Override
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(CommoditySpread fpmlCommoditySpread, CapacityUnitEnum capacityUnit, Leg fpmlLeg) {
			FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceSchedule = FieldWithMetaPriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlCommoditySpread, capacityUnit, fpmlLeg);
		}
		
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder assignOutput(FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceSchedule, CommoditySpread fpmlCommoditySpread, CapacityUnitEnum capacityUnit, Leg fpmlLeg) {
			final PriceSchedule.PriceScheduleBuilder withMetaArgument = PriceSchedule.builder()
				.setValue(MapperS.of(fpmlCommoditySpread).<BigDecimal>map("getAmount", commoditySpread -> commoditySpread.getAmount()).get())
				.setPriceType(PriceTypeEnum.ASSET_PRICE)
				.setArithmeticOperator(ArithmeticOperationEnum.ADD)
				.setUnit(UnitType.builder()
					.setCurrencyValue(MapperS.of(fpmlCommoditySpread).<Currency>map("getCurrency", commoditySpread -> commoditySpread.getCurrency()).<String>map("getValue", currency -> currency.getValue()).get())
					.build())
				.setPerUnitOf(UnitType.builder()
					.setCapacityUnit(capacityUnit)
					.build())
				.build() == null ? null : PriceSchedule.builder()
				.setValue(MapperS.of(fpmlCommoditySpread).<BigDecimal>map("getAmount", commoditySpread -> commoditySpread.getAmount()).get())
				.setPriceType(PriceTypeEnum.ASSET_PRICE)
				.setArithmeticOperator(ArithmeticOperationEnum.ADD)
				.setUnit(UnitType.builder()
					.setCurrencyValue(MapperS.of(fpmlCommoditySpread).<Currency>map("getCurrency", commoditySpread -> commoditySpread.getCurrency()).<String>map("getValue", currency -> currency.getValue()).get())
					.build())
				.setPerUnitOf(UnitType.builder()
					.setCapacityUnit(capacityUnit)
					.build())
				.build().toBuilder();
			priceSchedule = toBuilder(FieldWithMetaPriceSchedule.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScopedKey(createPriceKey.evaluate("spreadPrice", fpmlLeg))));
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
