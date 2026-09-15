package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.meta.Reference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CreatePriceWithAddress.CreatePriceWithAddressDefault.class)
public abstract class CreatePriceWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param keyValue 
	* @return priceWithAddress 
	*/
	public ReferenceWithMetaPriceSchedule evaluate(String keyValue) {
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceWithAddressBuilder = doEvaluate(keyValue);
		
		final ReferenceWithMetaPriceSchedule priceWithAddress;
		if (priceWithAddressBuilder == null) {
			priceWithAddress = null;
		} else {
			priceWithAddress = priceWithAddressBuilder.build();
			objectValidator.validate(ReferenceWithMetaPriceSchedule.class, priceWithAddress);
		}
		
		return priceWithAddress;
	}

	protected abstract ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(String keyValue);

	public static class CreatePriceWithAddressDefault extends CreatePriceWithAddress {
		@Override
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(String keyValue) {
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceWithAddress = ReferenceWithMetaPriceSchedule.builder();
			return assignOutput(priceWithAddress, keyValue);
		}
		
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder assignOutput(ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceWithAddress, String keyValue) {
			priceWithAddress = toBuilder(ReferenceWithMetaPriceSchedule.builder().setValue(null).setReference(Reference.builder().setReference(keyValue)).build());
			
			return Optional.ofNullable(priceWithAddress)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
