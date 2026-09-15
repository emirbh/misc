package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaBasketConstituent;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.asset.BasketConstituent;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBasketConstituentWithAddress.MapBasketConstituentWithAddressDefault.class)
public abstract class MapBasketConstituentWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected BasketConstituentKeyValue basketConstituentKeyValue;
	@Inject protected CreateBasketConstituentWithAddress createBasketConstituentWithAddress;

	/**
	* @param fpmlBasketConstituent 
	* @return basketConstituent 
	*/
	public ReferenceWithMetaBasketConstituent evaluate(BasketConstituent fpmlBasketConstituent) {
		ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder basketConstituentBuilder = doEvaluate(fpmlBasketConstituent);
		
		final ReferenceWithMetaBasketConstituent basketConstituent;
		if (basketConstituentBuilder == null) {
			basketConstituent = null;
		} else {
			basketConstituent = basketConstituentBuilder.build();
			objectValidator.validate(ReferenceWithMetaBasketConstituent.class, basketConstituent);
		}
		
		return basketConstituent;
	}

	protected abstract ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder doEvaluate(BasketConstituent fpmlBasketConstituent);

	public static class MapBasketConstituentWithAddressDefault extends MapBasketConstituentWithAddress {
		@Override
		protected ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder doEvaluate(BasketConstituent fpmlBasketConstituent) {
			ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder basketConstituent = ReferenceWithMetaBasketConstituent.builder();
			return assignOutput(basketConstituent, fpmlBasketConstituent);
		}
		
		protected ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder assignOutput(ReferenceWithMetaBasketConstituent.ReferenceWithMetaBasketConstituentBuilder basketConstituent, BasketConstituent fpmlBasketConstituent) {
			basketConstituent = toBuilder(createBasketConstituentWithAddress.evaluate(basketConstituentKeyValue.evaluate(fpmlBasketConstituent)));
			
			return Optional.ofNullable(basketConstituent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
