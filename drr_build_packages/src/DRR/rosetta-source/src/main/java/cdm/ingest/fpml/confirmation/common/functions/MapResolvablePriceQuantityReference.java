package cdm.ingest.fpml.confirmation.common.functions;

import cdm.product.common.settlement.metafields.ReferenceWithMetaResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapResolvablePriceQuantityReference.MapResolvablePriceQuantityReferenceDefault.class)
public abstract class MapResolvablePriceQuantityReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlHref 
	* @return quantityReference 
	*/
	public ReferenceWithMetaResolvablePriceQuantity evaluate(String fpmlHref) {
		ReferenceWithMetaResolvablePriceQuantity.ReferenceWithMetaResolvablePriceQuantityBuilder quantityReferenceBuilder = doEvaluate(fpmlHref);
		
		final ReferenceWithMetaResolvablePriceQuantity quantityReference;
		if (quantityReferenceBuilder == null) {
			quantityReference = null;
		} else {
			quantityReference = quantityReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaResolvablePriceQuantity.class, quantityReference);
		}
		
		return quantityReference;
	}

	protected abstract ReferenceWithMetaResolvablePriceQuantity.ReferenceWithMetaResolvablePriceQuantityBuilder doEvaluate(String fpmlHref);

	public static class MapResolvablePriceQuantityReferenceDefault extends MapResolvablePriceQuantityReference {
		@Override
		protected ReferenceWithMetaResolvablePriceQuantity.ReferenceWithMetaResolvablePriceQuantityBuilder doEvaluate(String fpmlHref) {
			ReferenceWithMetaResolvablePriceQuantity.ReferenceWithMetaResolvablePriceQuantityBuilder quantityReference = ReferenceWithMetaResolvablePriceQuantity.builder();
			return assignOutput(quantityReference, fpmlHref);
		}
		
		protected ReferenceWithMetaResolvablePriceQuantity.ReferenceWithMetaResolvablePriceQuantityBuilder assignOutput(ReferenceWithMetaResolvablePriceQuantity.ReferenceWithMetaResolvablePriceQuantityBuilder quantityReference, String fpmlHref) {
			quantityReference = toBuilder(ReferenceWithMetaResolvablePriceQuantity.builder().setValue(null).setExternalReference(fpmlHref).build());
			
			return Optional.ofNullable(quantityReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
