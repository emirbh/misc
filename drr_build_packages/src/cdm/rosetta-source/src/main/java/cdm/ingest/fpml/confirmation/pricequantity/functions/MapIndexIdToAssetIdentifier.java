package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.IndexId;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapIndexIdToAssetIdentifier.MapIndexIdToAssetIdentifierDefault.class)
public abstract class MapIndexIdToAssetIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdType mapAssetIdType;
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlIndexId 
	* @return assetIdentifier 
	*/
	public AssetIdentifier evaluate(IndexId fpmlIndexId) {
		AssetIdentifier.AssetIdentifierBuilder assetIdentifierBuilder = doEvaluate(fpmlIndexId);
		
		final AssetIdentifier assetIdentifier;
		if (assetIdentifierBuilder == null) {
			assetIdentifier = null;
		} else {
			assetIdentifier = assetIdentifierBuilder.build();
			objectValidator.validate(AssetIdentifier.class, assetIdentifier);
		}
		
		return assetIdentifier;
	}

	protected abstract AssetIdentifier.AssetIdentifierBuilder doEvaluate(IndexId fpmlIndexId);

	public static class MapIndexIdToAssetIdentifierDefault extends MapIndexIdToAssetIdentifier {
		@Override
		protected AssetIdentifier.AssetIdentifierBuilder doEvaluate(IndexId fpmlIndexId) {
			AssetIdentifier.AssetIdentifierBuilder assetIdentifier = AssetIdentifier.builder();
			return assignOutput(assetIdentifier, fpmlIndexId);
		}
		
		protected AssetIdentifier.AssetIdentifierBuilder assignOutput(AssetIdentifier.AssetIdentifierBuilder assetIdentifier, IndexId fpmlIndexId) {
			assetIdentifier = toBuilder(AssetIdentifier.builder()
				.setIdentifier(mapStringWithScheme.evaluate(MapperS.of(fpmlIndexId).<String>map("getValue", indexId -> indexId.getValue()).get(), MapperS.of(fpmlIndexId).<String>map("getIndexIdScheme", indexId -> indexId.getIndexIdScheme()).get()))
				.setIdentifierType(MapperS.of(mapAssetIdType.evaluate(MapperS.of(fpmlIndexId).<String>map("getIndexIdScheme", indexId -> indexId.getIndexIdScheme()).get())).getOrDefault(AssetIdTypeEnum.NAME))
				.build());
			
			return Optional.ofNullable(assetIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
