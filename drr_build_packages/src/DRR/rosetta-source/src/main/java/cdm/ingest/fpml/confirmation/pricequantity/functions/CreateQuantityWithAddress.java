package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.meta.Reference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CreateQuantityWithAddress.CreateQuantityWithAddressDefault.class)
public abstract class CreateQuantityWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param keyValue 
	* @return quantityWithAddress 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(String keyValue) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityWithAddressBuilder = doEvaluate(keyValue);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule quantityWithAddress;
		if (quantityWithAddressBuilder == null) {
			quantityWithAddress = null;
		} else {
			quantityWithAddress = quantityWithAddressBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, quantityWithAddress);
		}
		
		return quantityWithAddress;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(String keyValue);

	public static class CreateQuantityWithAddressDefault extends CreateQuantityWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(String keyValue) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityWithAddress = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(quantityWithAddress, keyValue);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityWithAddress, String keyValue) {
			quantityWithAddress = toBuilder(ReferenceWithMetaNonNegativeQuantitySchedule.builder().setValue(NonNegativeQuantitySchedule.builder()
				.setValue(null)
				.build() == null ? null : NonNegativeQuantitySchedule.builder()
				.setValue(null)
				.build().toBuilder()).setReference(Reference.builder().setReference(keyValue)).build());
			
			return Optional.ofNullable(quantityWithAddress)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
