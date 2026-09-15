package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.IndexName;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapIndexNameToAssetIdentifier.MapIndexNameToAssetIdentifierDefault.class)
public abstract class MapIndexNameToAssetIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlIndexName 
	* @return assetIdentifier 
	*/
	public AssetIdentifier evaluate(IndexName fpmlIndexName) {
		AssetIdentifier.AssetIdentifierBuilder assetIdentifierBuilder = doEvaluate(fpmlIndexName);
		
		final AssetIdentifier assetIdentifier;
		if (assetIdentifierBuilder == null) {
			assetIdentifier = null;
		} else {
			assetIdentifier = assetIdentifierBuilder.build();
			objectValidator.validate(AssetIdentifier.class, assetIdentifier);
		}
		
		return assetIdentifier;
	}

	protected abstract AssetIdentifier.AssetIdentifierBuilder doEvaluate(IndexName fpmlIndexName);

	public static class MapIndexNameToAssetIdentifierDefault extends MapIndexNameToAssetIdentifier {
		@Override
		protected AssetIdentifier.AssetIdentifierBuilder doEvaluate(IndexName fpmlIndexName) {
			AssetIdentifier.AssetIdentifierBuilder assetIdentifier = AssetIdentifier.builder();
			return assignOutput(assetIdentifier, fpmlIndexName);
		}
		
		protected AssetIdentifier.AssetIdentifierBuilder assignOutput(AssetIdentifier.AssetIdentifierBuilder assetIdentifier, IndexName fpmlIndexName) {
			assetIdentifier = toBuilder(AssetIdentifier.builder()
				.setIdentifier(mapStringWithScheme.evaluate(MapperS.of(fpmlIndexName).<String>map("getValue", indexName -> indexName.getValue()).get(), MapperS.of(fpmlIndexName).<String>map("getIndexNameScheme", indexName -> indexName.getIndexNameScheme()).get()))
				.setIdentifierType(AssetIdTypeEnum.NAME)
				.build());
			
			return Optional.ofNullable(assetIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
