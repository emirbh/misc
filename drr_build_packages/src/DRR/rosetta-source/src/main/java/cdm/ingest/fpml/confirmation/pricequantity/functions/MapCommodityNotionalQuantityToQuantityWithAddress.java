package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityNotionalQuantityToQuantityWithAddress.MapCommodityNotionalQuantityToQuantityWithAddressDefault.class)
public abstract class MapCommodityNotionalQuantityToQuantityWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityTotalNotionalQuantityToQuantityWithAddress mapCommodityTotalNotionalQuantityToQuantityWithAddress;

	/**
	* @param totalNotionalQuantity 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(BigDecimal totalNotionalQuantity, Leg fpmlLeg) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(totalNotionalQuantity, fpmlLeg);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal totalNotionalQuantity, Leg fpmlLeg);

	public static class MapCommodityNotionalQuantityToQuantityWithAddressDefault extends MapCommodityNotionalQuantityToQuantityWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal totalNotionalQuantity, Leg fpmlLeg) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, totalNotionalQuantity, fpmlLeg);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, BigDecimal totalNotionalQuantity, Leg fpmlLeg) {
			nonNegativeQuantitySchedule = toBuilder(mapCommodityTotalNotionalQuantityToQuantityWithAddress.evaluate(totalNotionalQuantity, fpmlLeg));
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
