package cdm.ingest.fpml.confirmation.product.volatilityswap.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityKey;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.meta.Reference;
import fpml.consolidated.volatility.swaps.Volatility;
import fpml.consolidated.volatility.swaps.VolatilityAmount;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapVolatilityLegToNonNegativeQuantityScheduleWithAddress.MapVolatilityLegToNonNegativeQuantityScheduleWithAddressDefault.class)
public abstract class MapVolatilityLegToNonNegativeQuantityScheduleWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;

	/**
	* @param fpmlVolatilityLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(VolatilityLeg fpmlVolatilityLeg) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlVolatilityLeg);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(VolatilityLeg fpmlVolatilityLeg);

	public static class MapVolatilityLegToNonNegativeQuantityScheduleWithAddressDefault extends MapVolatilityLegToNonNegativeQuantityScheduleWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(VolatilityLeg fpmlVolatilityLeg) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlVolatilityLeg);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, VolatilityLeg fpmlVolatilityLeg) {
			if (exists(MapperS.of(fpmlVolatilityLeg).<VolatilityAmount>map("getAmount", volatilityLeg -> volatilityLeg.getAmount()).<Volatility>map("getVolatility", volatilityAmount -> volatilityAmount.getVolatility()).<BigDecimal>map("getVegaNotionalAmount", volatility -> volatility.getVegaNotionalAmount())).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(ReferenceWithMetaNonNegativeQuantitySchedule.builder().setValue(null).setReference(Reference.builder().setReference(createQuantityKey.evaluate("vegaNotional", fpmlVolatilityLeg))).build());
			} else {
				nonNegativeQuantitySchedule = toBuilder(ReferenceWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
