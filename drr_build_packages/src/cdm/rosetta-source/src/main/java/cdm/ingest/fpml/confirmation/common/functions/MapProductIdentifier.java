package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.ProductId;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapProductIdentifier.MapProductIdentifierDefault.class)
public abstract class MapProductIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapProductIdType mapProductIdType;
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlProductIdList 
	* @return productIdentifier 
	*/
	public ProductIdentifier evaluate(ProductId fpmlProductIdList) {
		ProductIdentifier.ProductIdentifierBuilder productIdentifierBuilder = doEvaluate(fpmlProductIdList);
		
		final ProductIdentifier productIdentifier;
		if (productIdentifierBuilder == null) {
			productIdentifier = null;
		} else {
			productIdentifier = productIdentifierBuilder.build();
			objectValidator.validate(ProductIdentifier.class, productIdentifier);
		}
		
		return productIdentifier;
	}

	protected abstract ProductIdentifier.ProductIdentifierBuilder doEvaluate(ProductId fpmlProductIdList);

	public static class MapProductIdentifierDefault extends MapProductIdentifier {
		@Override
		protected ProductIdentifier.ProductIdentifierBuilder doEvaluate(ProductId fpmlProductIdList) {
			ProductIdentifier.ProductIdentifierBuilder productIdentifier = ProductIdentifier.builder();
			return assignOutput(productIdentifier, fpmlProductIdList);
		}
		
		protected ProductIdentifier.ProductIdentifierBuilder assignOutput(ProductIdentifier.ProductIdentifierBuilder productIdentifier, ProductId fpmlProductIdList) {
			productIdentifier = toBuilder(ProductIdentifier.builder()
				.setIdentifier(mapStringWithScheme.evaluate(MapperS.of(fpmlProductIdList).<String>map("getValue", productId -> productId.getValue()).get(), MapperS.of(fpmlProductIdList).<String>map("getProductIdScheme", productId -> productId.getProductIdScheme()).get()))
				.setSource(mapProductIdType.evaluate(MapperS.of(fpmlProductIdList).<String>map("getProductIdScheme", productId -> productId.getProductIdScheme()).get()))
				.build());
			
			return Optional.ofNullable(productIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
