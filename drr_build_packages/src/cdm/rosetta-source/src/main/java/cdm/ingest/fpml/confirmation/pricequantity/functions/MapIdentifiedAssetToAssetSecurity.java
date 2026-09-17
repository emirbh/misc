package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.asset.IdentifiedAsset;
import fpml.consolidated.shared.ExchangeId;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapIdentifiedAssetToAssetSecurity.MapIdentifiedAssetToAssetSecurityDefault.class)
public abstract class MapIdentifiedAssetToAssetSecurity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapIdentifiedAssetToSecurity mapIdentifiedAssetToSecurity;

	/**
	* @param fpmlIdentifiedAsset 
	* @param fpmlExchangeId 
	* @param fpmlRelatedExchangeId 
	* @param instrumentType 
	* @return asset 
	*/
	public Asset evaluate(IdentifiedAsset fpmlIdentifiedAsset, ExchangeId fpmlExchangeId, List<? extends ExchangeId> fpmlRelatedExchangeId, InstrumentTypeEnum instrumentType) {
		Asset.AssetBuilder assetBuilder = doEvaluate(fpmlIdentifiedAsset, fpmlExchangeId, fpmlRelatedExchangeId, instrumentType);
		
		final Asset asset;
		if (assetBuilder == null) {
			asset = null;
		} else {
			asset = assetBuilder.build();
			objectValidator.validate(Asset.class, asset);
		}
		
		return asset;
	}

	protected abstract Asset.AssetBuilder doEvaluate(IdentifiedAsset fpmlIdentifiedAsset, ExchangeId fpmlExchangeId, List<? extends ExchangeId> fpmlRelatedExchangeId, InstrumentTypeEnum instrumentType);

	public static class MapIdentifiedAssetToAssetSecurityDefault extends MapIdentifiedAssetToAssetSecurity {
		@Override
		protected Asset.AssetBuilder doEvaluate(IdentifiedAsset fpmlIdentifiedAsset, ExchangeId fpmlExchangeId, List<? extends ExchangeId> fpmlRelatedExchangeId, InstrumentTypeEnum instrumentType) {
			if (fpmlRelatedExchangeId == null) {
				fpmlRelatedExchangeId = Collections.emptyList();
			}
			Asset.AssetBuilder asset = Asset.builder();
			return assignOutput(asset, fpmlIdentifiedAsset, fpmlExchangeId, fpmlRelatedExchangeId, instrumentType);
		}
		
		protected Asset.AssetBuilder assignOutput(Asset.AssetBuilder asset, IdentifiedAsset fpmlIdentifiedAsset, ExchangeId fpmlExchangeId, List<? extends ExchangeId> fpmlRelatedExchangeId, InstrumentTypeEnum instrumentType) {
			asset = toBuilder(Asset.builder()
				.setInstrument(Instrument.builder()
					.setSecurity(mapIdentifiedAssetToSecurity.evaluate(fpmlIdentifiedAsset, fpmlExchangeId, fpmlRelatedExchangeId, instrumentType, null))
					.build())
				.build());
			
			return Optional.ofNullable(asset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
