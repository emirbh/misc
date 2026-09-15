package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.FxLinkedNotionalSchedule;
import fpml.consolidated.shared.Leg;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxLinkedNotionalScheduleToQuantityWithAddress.MapFxLinkedNotionalScheduleToQuantityWithAddressDefault.class)
public abstract class MapFxLinkedNotionalScheduleToQuantityWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithAddress createQuantityWithAddress;

	/**
	* @param fpmlFxLinkedNotionalSchedule 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(FxLinkedNotionalSchedule fpmlFxLinkedNotionalSchedule, Leg fpmlLeg) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlFxLinkedNotionalSchedule, fpmlLeg);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(FxLinkedNotionalSchedule fpmlFxLinkedNotionalSchedule, Leg fpmlLeg);

	public static class MapFxLinkedNotionalScheduleToQuantityWithAddressDefault extends MapFxLinkedNotionalScheduleToQuantityWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(FxLinkedNotionalSchedule fpmlFxLinkedNotionalSchedule, Leg fpmlLeg) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlFxLinkedNotionalSchedule, fpmlLeg);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, FxLinkedNotionalSchedule fpmlFxLinkedNotionalSchedule, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFxLinkedNotionalSchedule)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(createQuantityWithAddress.evaluate(createQuantityKey.evaluate("fxLinkedNotionalSchedule", fpmlLeg)));
			} else {
				nonNegativeQuantitySchedule = toBuilder(ReferenceWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
