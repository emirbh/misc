package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CreateQuantityWithLocation.CreateQuantityWithLocationDefault.class)
public abstract class CreateQuantityWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param quantity 
	* @param keyValue 
	* @return quantityWithLocation 
	*/
	public FieldWithMetaNonNegativeQuantitySchedule evaluate(NonNegativeQuantitySchedule quantity, String keyValue) {
		FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder quantityWithLocationBuilder = doEvaluate(quantity, keyValue);
		
		final FieldWithMetaNonNegativeQuantitySchedule quantityWithLocation;
		if (quantityWithLocationBuilder == null) {
			quantityWithLocation = null;
		} else {
			quantityWithLocation = quantityWithLocationBuilder.build();
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, quantityWithLocation);
		}
		
		return quantityWithLocation;
	}

	protected abstract FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeQuantitySchedule quantity, String keyValue);

	public static class CreateQuantityWithLocationDefault extends CreateQuantityWithLocation {
		@Override
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(NonNegativeQuantitySchedule quantity, String keyValue) {
			FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder quantityWithLocation = FieldWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(quantityWithLocation, quantity, keyValue);
		}
		
		protected FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder assignOutput(FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder quantityWithLocation, NonNegativeQuantitySchedule quantity, String keyValue) {
			final NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder withMetaArgument = quantity == null ? null : quantity.toBuilder();
			quantityWithLocation = toBuilder(FieldWithMetaNonNegativeQuantitySchedule.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScopedKey(keyValue)));
			
			return Optional.ofNullable(quantityWithLocation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
