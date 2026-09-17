package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapNonNegativeMoneyToQuantityWithAddress.MapNonNegativeMoneyToQuantityWithAddressDefault.class)
public abstract class MapNonNegativeMoneyToQuantityWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithAddress createQuantityWithAddress;

	/**
	* @param fpmlNonNegativeMoney 
	* @param id 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(NonNegativeMoney fpmlNonNegativeMoney, String id, Leg fpmlLeg) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNonNegativeMoney, id, fpmlLeg);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeMoney fpmlNonNegativeMoney, String id, Leg fpmlLeg);

	public static class MapNonNegativeMoneyToQuantityWithAddressDefault extends MapNonNegativeMoneyToQuantityWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeMoney fpmlNonNegativeMoney, String id, Leg fpmlLeg) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNonNegativeMoney, id, fpmlLeg);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, NonNegativeMoney fpmlNonNegativeMoney, String id, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlNonNegativeMoney)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(createQuantityWithAddress.evaluate(createQuantityKey.evaluate(id, fpmlLeg)));
			} else {
				nonNegativeQuantitySchedule = toBuilder(ReferenceWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
