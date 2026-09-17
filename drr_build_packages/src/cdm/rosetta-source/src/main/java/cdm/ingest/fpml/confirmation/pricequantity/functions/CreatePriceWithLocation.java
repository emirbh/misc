package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CreatePriceWithLocation.CreatePriceWithLocationDefault.class)
public abstract class CreatePriceWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param price 
	* @param keyValue 
	* @return priceWithLocation 
	*/
	public FieldWithMetaPriceSchedule evaluate(PriceSchedule price, String keyValue) {
		FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceWithLocationBuilder = doEvaluate(price, keyValue);
		
		final FieldWithMetaPriceSchedule priceWithLocation;
		if (priceWithLocationBuilder == null) {
			priceWithLocation = null;
		} else {
			priceWithLocation = priceWithLocationBuilder.build();
			objectValidator.validate(FieldWithMetaPriceSchedule.class, priceWithLocation);
		}
		
		return priceWithLocation;
	}

	protected abstract FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(PriceSchedule price, String keyValue);

	public static class CreatePriceWithLocationDefault extends CreatePriceWithLocation {
		@Override
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(PriceSchedule price, String keyValue) {
			FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceWithLocation = FieldWithMetaPriceSchedule.builder();
			return assignOutput(priceWithLocation, price, keyValue);
		}
		
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder assignOutput(FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceWithLocation, PriceSchedule price, String keyValue) {
			final PriceSchedule.PriceScheduleBuilder withMetaArgument = price == null ? null : price.toBuilder();
			priceWithLocation = toBuilder(FieldWithMetaPriceSchedule.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScopedKey(keyValue)));
			
			return Optional.ofNullable(priceWithLocation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
