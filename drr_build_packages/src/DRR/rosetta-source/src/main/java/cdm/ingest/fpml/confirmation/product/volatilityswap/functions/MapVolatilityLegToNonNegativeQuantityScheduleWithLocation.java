package cdm.ingest.fpml.confirmation.product.volatilityswap.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityKey;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.volatility.swaps.Volatility;
import fpml.consolidated.volatility.swaps.VolatilityAmount;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilityLegToNonNegativeQuantityScheduleWithLocation.MapVolatilityLegToNonNegativeQuantityScheduleWithLocationDefault.class)
public abstract class MapVolatilityLegToNonNegativeQuantityScheduleWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlVolatilityLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public FieldWithMetaNonNegativeQuantitySchedule evaluate(VolatilityLeg fpmlVolatilityLeg) {
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlVolatilityLeg);
		
		final FieldWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(VolatilityLeg fpmlVolatilityLeg);

	public static class MapVolatilityLegToNonNegativeQuantityScheduleWithLocationDefault extends MapVolatilityLegToNonNegativeQuantityScheduleWithLocation {
		@Override
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(VolatilityLeg fpmlVolatilityLeg) {
			FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = FieldWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlVolatilityLeg);
		}
		
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder assignOutput(FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, VolatilityLeg fpmlVolatilityLeg) {
			final NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder withMetaArgument = NonNegativeQuantitySchedule.builder()
				.setValue(MapperS.of(fpmlVolatilityLeg).<VolatilityAmount>map("getAmount", volatilityLeg -> volatilityLeg.getAmount()).<Volatility>map("getVolatility", volatilityAmount -> volatilityAmount.getVolatility()).<BigDecimal>map("getVegaNotionalAmount", volatility -> volatility.getVegaNotionalAmount()).get())
				.setUnit(UnitType.builder()
					.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlVolatilityLeg).<Currency>map("getSettlementCurrency", volatilityLeg -> volatilityLeg.getSettlementCurrency()).get()))
					.build())
				.build() == null ? null : NonNegativeQuantitySchedule.builder()
				.setValue(MapperS.of(fpmlVolatilityLeg).<VolatilityAmount>map("getAmount", volatilityLeg -> volatilityLeg.getAmount()).<Volatility>map("getVolatility", volatilityAmount -> volatilityAmount.getVolatility()).<BigDecimal>map("getVegaNotionalAmount", volatility -> volatility.getVegaNotionalAmount()).get())
				.setUnit(UnitType.builder()
					.setCurrency(mapCurrency.evaluate(MapperS.of(fpmlVolatilityLeg).<Currency>map("getSettlementCurrency", volatilityLeg -> volatilityLeg.getSettlementCurrency()).get()))
					.build())
				.build().toBuilder();
			nonNegativeQuantitySchedule = toBuilder(FieldWithMetaNonNegativeQuantitySchedule.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScopedKey(createQuantityKey.evaluate("vegaNotional", fpmlVolatilityLeg))));
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
