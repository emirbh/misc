package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.IdentifiedAsset;
import fpml.consolidated.shared.InstrumentId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapAssetIdentifierList.MapAssetIdentifierListDefault.class)
public abstract class MapAssetIdentifierList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdType mapAssetIdType;
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlIdentifiedAsset 
	* @return assetIdentifierList 
	*/
	public List<? extends AssetIdentifier> evaluate(IdentifiedAsset fpmlIdentifiedAsset) {
		List<AssetIdentifier.AssetIdentifierBuilder> assetIdentifierListBuilder = doEvaluate(fpmlIdentifiedAsset);
		
		final List<? extends AssetIdentifier> assetIdentifierList;
		if (assetIdentifierListBuilder == null) {
			assetIdentifierList = null;
		} else {
			assetIdentifierList = assetIdentifierListBuilder.stream().map(AssetIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(AssetIdentifier.class, assetIdentifierList);
		}
		
		return assetIdentifierList;
	}

	protected abstract List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(IdentifiedAsset fpmlIdentifiedAsset);

	public static class MapAssetIdentifierListDefault extends MapAssetIdentifierList {
		@Override
		protected List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(IdentifiedAsset fpmlIdentifiedAsset) {
			List<AssetIdentifier.AssetIdentifierBuilder> assetIdentifierList = new ArrayList<>();
			return assignOutput(assetIdentifierList, fpmlIdentifiedAsset);
		}
		
		protected List<AssetIdentifier.AssetIdentifierBuilder> assignOutput(List<AssetIdentifier.AssetIdentifierBuilder> assetIdentifierList, IdentifiedAsset fpmlIdentifiedAsset) {
			assetIdentifierList.addAll(toBuilder(MapperS.of(fpmlIdentifiedAsset).<InstrumentId>mapC("getInstrumentId", identifiedAsset -> identifiedAsset.getInstrumentId())
				.mapItem(item -> MapperS.of(AssetIdentifier.builder()
					.setIdentifier(mapStringWithScheme.evaluate(item.<String>map("getValue", instrumentId -> instrumentId.getValue()).get(), item.<String>map("getInstrumentIdScheme", instrumentId -> instrumentId.getInstrumentIdScheme()).get()))
					.setIdentifierType(mapAssetIdType.evaluate(item.<String>map("getInstrumentIdScheme", instrumentId -> instrumentId.getInstrumentIdScheme()).get()))
					.build())).getMulti()));
			
			if (exists(MapperS.of(fpmlIdentifiedAsset).<String>map("getDescription", identifiedAsset -> identifiedAsset.getDescription())).getOrDefault(false)) {
				final AssetIdentifier assetIdentifier = AssetIdentifier.builder()
					.setIdentifierValue(MapperS.of(fpmlIdentifiedAsset).<String>map("getDescription", identifiedAsset -> identifiedAsset.getDescription()).get())
					.setIdentifierType(AssetIdTypeEnum.NAME)
					.build();
				if (assetIdentifier == null) {
					assetIdentifierList.addAll(toBuilder(Collections.<AssetIdentifier>emptyList()));
				} else {
					assetIdentifierList.addAll(toBuilder(Collections.singletonList(assetIdentifier)));
				}
			} else {
				assetIdentifierList.addAll(toBuilder(Collections.<AssetIdentifier>emptyList()));
			}
			
			return Optional.ofNullable(assetIdentifierList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
