package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFixedRateToPriceScheduleWithAddress.MapFixedRateToPriceScheduleWithAddressDefault.class)
public abstract class MapFixedRateToPriceScheduleWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithAddress createPriceWithAddress;

	/**
	* @param fpmlFixedRate 
	* @param fpmlLeg 
	* @return priceSchedule 
	*/
	public ReferenceWithMetaPriceSchedule evaluate(BigDecimal fpmlFixedRate, Leg fpmlLeg) {
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlFixedRate, fpmlLeg);
		
		final ReferenceWithMetaPriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(ReferenceWithMetaPriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(BigDecimal fpmlFixedRate, Leg fpmlLeg);

	public static class MapFixedRateToPriceScheduleWithAddressDefault extends MapFixedRateToPriceScheduleWithAddress {
		@Override
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(BigDecimal fpmlFixedRate, Leg fpmlLeg) {
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceSchedule = ReferenceWithMetaPriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlFixedRate, fpmlLeg);
		}
		
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder assignOutput(ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceSchedule, BigDecimal fpmlFixedRate, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFixedRate)).getOrDefault(false)) {
				priceSchedule = toBuilder(createPriceWithAddress.evaluate(createPriceKey.evaluate("fixedRate", fpmlLeg)));
			} else {
				priceSchedule = toBuilder(ReferenceWithMetaPriceSchedule.builder().build());
			}
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
