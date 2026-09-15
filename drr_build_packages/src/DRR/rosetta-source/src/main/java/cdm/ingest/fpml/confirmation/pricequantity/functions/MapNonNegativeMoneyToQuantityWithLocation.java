package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.MetaFields;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNonNegativeMoneyToQuantityWithLocation.MapNonNegativeMoneyToQuantityWithLocationDefault.class)
public abstract class MapNonNegativeMoneyToQuantityWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected MapNonNegativeMoneyToQuantity mapNonNegativeMoneyToQuantity;

	/**
	* @param fpmlNonNegativeMoney 
	* @param id 
	* @param fpmlLeg 
	* @return nonNegativeQuantitySchedule 
	*/
	public FieldWithMetaNonNegativeQuantitySchedule evaluate(NonNegativeMoney fpmlNonNegativeMoney, String id, Leg fpmlLeg) {
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNonNegativeMoney, id, fpmlLeg);
		
		final FieldWithMetaNonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeMoney fpmlNonNegativeMoney, String id, Leg fpmlLeg);

	public static class MapNonNegativeMoneyToQuantityWithLocationDefault extends MapNonNegativeMoneyToQuantityWithLocation {
		@Override
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeMoney fpmlNonNegativeMoney, String id, Leg fpmlLeg) {
			FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = FieldWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNonNegativeMoney, id, fpmlLeg);
		}
		
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder assignOutput(FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, NonNegativeMoney fpmlNonNegativeMoney, String id, Leg fpmlLeg) {
			final NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder withMetaArgument = mapNonNegativeMoneyToQuantity.evaluate(fpmlNonNegativeMoney) == null ? null : mapNonNegativeMoneyToQuantity.evaluate(fpmlNonNegativeMoney).toBuilder();
			nonNegativeQuantitySchedule = toBuilder(FieldWithMetaNonNegativeQuantitySchedule.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScopedKey(createQuantityKey.evaluate(id, fpmlLeg))));
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
