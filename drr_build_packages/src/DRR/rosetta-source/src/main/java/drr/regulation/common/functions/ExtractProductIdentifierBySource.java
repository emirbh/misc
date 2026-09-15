package drr.regulation.common.functions;

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

@ImplementedBy(ExtractProductIdentifierBySource.ExtractProductIdentifierBySourceDefault.class)
public abstract class ExtractProductIdentifierBySource implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param productIdentifiers 
	* @return productIdentifier 
	*/
	public AssetIdentifier evaluate(List<? extends AssetIdentifier> productIdentifiers) {
		AssetIdentifier.AssetIdentifierBuilder productIdentifierBuilder = doEvaluate(productIdentifiers);
		
		final AssetIdentifier productIdentifier;
		if (productIdentifierBuilder == null) {
			productIdentifier = null;
		} else {
			productIdentifier = productIdentifierBuilder.build();
			objectValidator.validate(AssetIdentifier.class, productIdentifier);
		}
		
		return productIdentifier;
	}

	protected abstract AssetIdentifier.AssetIdentifierBuilder doEvaluate(List<? extends AssetIdentifier> productIdentifiers);

	protected abstract MapperC<AssetIdTypeEnum> orderedSources(List<? extends AssetIdentifier> productIdentifiers);

	public static class ExtractProductIdentifierBySourceDefault extends ExtractProductIdentifierBySource {
		@Override
		protected AssetIdentifier.AssetIdentifierBuilder doEvaluate(List<? extends AssetIdentifier> productIdentifiers) {
			if (productIdentifiers == null) {
				productIdentifiers = Collections.emptyList();
			}
			AssetIdentifier.AssetIdentifierBuilder productIdentifier = AssetIdentifier.builder();
			return assignOutput(productIdentifier, productIdentifiers);
		}
		
		protected AssetIdentifier.AssetIdentifierBuilder assignOutput(AssetIdentifier.AssetIdentifierBuilder productIdentifier, List<? extends AssetIdentifier> productIdentifiers) {
			final MapperC<AssetIdentifier> thenArg = orderedSources(productIdentifiers)
				.mapItem(src -> {
					final MapperC<AssetIdentifier> _thenArg = MapperC.<AssetIdentifier>of(productIdentifiers)
						.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), src, CardinalityOperator.All).get());
					return _thenArg
						.first();
				});
			productIdentifier = toBuilder(MapperS.of(thenArg
				.first().getOrDefault(MapperC.<AssetIdentifier>of(productIdentifiers)
				.first().get())).get());
			
			return Optional.ofNullable(productIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<AssetIdTypeEnum> orderedSources(List<? extends AssetIdentifier> productIdentifiers) {
			return MapperC.<AssetIdTypeEnum>of(MapperS.of(AssetIdTypeEnum.REDID), MapperS.of(AssetIdTypeEnum.CUSIP), MapperS.of(AssetIdTypeEnum.SEDOL), MapperS.of(AssetIdTypeEnum.RIC), MapperS.of(AssetIdTypeEnum.SICOVAM), MapperS.of(AssetIdTypeEnum.FIGI), MapperS.of(AssetIdTypeEnum.BBGTICKER), MapperS.of(AssetIdTypeEnum.NAME));
		}
	}
}
