package drr.base.trade.underlier.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FilterAssetIdentifier.FilterAssetIdentifierDefault.class)
public abstract class FilterAssetIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param productIdentifiers List of product identifiers
	* @param productIdentificationType 
	* @return productIdentifier Single product identifier
	*/
	public AssetIdentifier evaluate(List<? extends AssetIdentifier> productIdentifiers, AssetIdTypeEnum productIdentificationType) {
		AssetIdentifier.AssetIdentifierBuilder productIdentifierBuilder = doEvaluate(productIdentifiers, productIdentificationType);
		
		final AssetIdentifier productIdentifier;
		if (productIdentifierBuilder == null) {
			productIdentifier = null;
		} else {
			productIdentifier = productIdentifierBuilder.build();
			objectValidator.validate(AssetIdentifier.class, productIdentifier);
		}
		
		return productIdentifier;
	}

	protected abstract AssetIdentifier.AssetIdentifierBuilder doEvaluate(List<? extends AssetIdentifier> productIdentifiers, AssetIdTypeEnum productIdentificationType);

	public static class FilterAssetIdentifierDefault extends FilterAssetIdentifier {
		@Override
		protected AssetIdentifier.AssetIdentifierBuilder doEvaluate(List<? extends AssetIdentifier> productIdentifiers, AssetIdTypeEnum productIdentificationType) {
			if (productIdentifiers == null) {
				productIdentifiers = Collections.emptyList();
			}
			AssetIdentifier.AssetIdentifierBuilder productIdentifier = AssetIdentifier.builder();
			return assignOutput(productIdentifier, productIdentifiers, productIdentificationType);
		}
		
		protected AssetIdentifier.AssetIdentifierBuilder assignOutput(AssetIdentifier.AssetIdentifierBuilder productIdentifier, List<? extends AssetIdentifier> productIdentifiers, AssetIdTypeEnum productIdentificationType) {
			if (areEqual(MapperC.<AssetIdentifier>of(productIdentifiers).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(productIdentificationType), CardinalityOperator.Any).getOrDefault(false)) {
				final MapperC<AssetIdentifier> thenArg = MapperC.<AssetIdentifier>of(productIdentifiers)
					.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(productIdentificationType), CardinalityOperator.All).get());
				productIdentifier = toBuilder(thenArg
					.first().get());
			} else {
				productIdentifier = null;
			}
			
			return Optional.ofNullable(productIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
