package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CreateBasketConstituentWithLocation.CreateBasketConstituentWithLocationDefault.class)
public abstract class CreateBasketConstituentWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param basketConstituent 
	* @param keyValue 
	* @return basketConstituentWithLocation 
	*/
	public FieldWithMetaBasketConstituent evaluate(BasketConstituent basketConstituent, String keyValue) {
		FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder basketConstituentWithLocationBuilder = doEvaluate(basketConstituent, keyValue);
		
		final FieldWithMetaBasketConstituent basketConstituentWithLocation;
		if (basketConstituentWithLocationBuilder == null) {
			basketConstituentWithLocation = null;
		} else {
			basketConstituentWithLocation = basketConstituentWithLocationBuilder.build();
			objectValidator.validate(FieldWithMetaBasketConstituent.class, basketConstituentWithLocation);
		}
		
		return basketConstituentWithLocation;
	}

	protected abstract FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder doEvaluate(BasketConstituent basketConstituent, String keyValue);

	public static class CreateBasketConstituentWithLocationDefault extends CreateBasketConstituentWithLocation {
		@Override
		protected FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder doEvaluate(BasketConstituent basketConstituent, String keyValue) {
			FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder basketConstituentWithLocation = FieldWithMetaBasketConstituent.builder();
			return assignOutput(basketConstituentWithLocation, basketConstituent, keyValue);
		}
		
		protected FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder assignOutput(FieldWithMetaBasketConstituent.FieldWithMetaBasketConstituentBuilder basketConstituentWithLocation, BasketConstituent basketConstituent, String keyValue) {
			final BasketConstituent.BasketConstituentBuilder withMetaArgument = basketConstituent == null ? null : basketConstituent.toBuilder();
			basketConstituentWithLocation = toBuilder(FieldWithMetaBasketConstituent.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScopedKey(keyValue)));
			
			return Optional.ofNullable(basketConstituentWithLocation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
