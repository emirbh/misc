package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaBasketConstituent;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.meta.Reference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CreateBasketConstituentWithAddress.CreateBasketConstituentWithAddressDefault.class)
public abstract class CreateBasketConstituentWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param keyValue 
	* @return basketConstituentWithAddress 
	*/
	public ReferenceWithMetaBasketConstituent evaluate(String keyValue) {
		ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder basketConstituentWithAddressBuilder = doEvaluate(keyValue);
		
		final ReferenceWithMetaBasketConstituent basketConstituentWithAddress;
		if (basketConstituentWithAddressBuilder == null) {
			basketConstituentWithAddress = null;
		} else {
			basketConstituentWithAddress = basketConstituentWithAddressBuilder.build();
			objectValidator.validate(ReferenceWithMetaBasketConstituent.class, basketConstituentWithAddress);
		}
		
		return basketConstituentWithAddress;
	}

	protected abstract ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder doEvaluate(String keyValue);

	public static class CreateBasketConstituentWithAddressDefault extends CreateBasketConstituentWithAddress {
		@Override
		protected ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder doEvaluate(String keyValue) {
			ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder basketConstituentWithAddress = ReferenceWithMetaBasketConstituent.builder();
			return assignOutput(basketConstituentWithAddress, keyValue);
		}
		
		protected ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder assignOutput(ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder basketConstituentWithAddress, String keyValue) {
			basketConstituentWithAddress = toBuilder(ReferenceWithMetaBasketConstituent.builder().setValue(null).setReference(Reference.builder().setReference(keyValue)).build());
			
			return Optional.ofNullable(basketConstituentWithAddress)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
