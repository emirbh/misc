package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNotionalAmountToQuantityWithAddress.MapNotionalAmountToQuantityWithAddressDefault.class)
public abstract class MapNotionalAmountToQuantityWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNotionalAmountWithIdToQuantityWithAddress mapNotionalAmountWithIdToQuantityWithAddress;

	/**
	* @param fpmlNotionalAmount 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(BigDecimal fpmlNotionalAmount, Leg fpmlLeg) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNotionalAmount, fpmlLeg);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNotionalAmount, Leg fpmlLeg);

	public static class MapNotionalAmountToQuantityWithAddressDefault extends MapNotionalAmountToQuantityWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNotionalAmount, Leg fpmlLeg) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNotionalAmount, fpmlLeg);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, BigDecimal fpmlNotionalAmount, Leg fpmlLeg) {
			nonNegativeQuantitySchedule = toBuilder(mapNotionalAmountWithIdToQuantityWithAddress.evaluate(fpmlNotionalAmount, "notionalAmount", fpmlLeg));
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
