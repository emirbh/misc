package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.ingest.fpml.confirmation.party.functions.MapExchangeIdToLegalEntity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.IdentifiedAsset;
import fpml.consolidated.shared.ExchangeId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapIdentifiedAssetToAssetListedDerivative.MapIdentifiedAssetToAssetListedDerivativeDefault.class)
public abstract class MapIdentifiedAssetToAssetListedDerivative implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapExchangeIdToLegalEntity mapExchangeIdToLegalEntity;

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

	public static class MapIdentifiedAssetToAssetListedDerivativeDefault extends MapIdentifiedAssetToAssetListedDerivative {
		@Override
		protected Asset.AssetBuilder doEvaluate(IdentifiedAsset fpmlIdentifiedAsset, ExchangeId fpmlExchangeId, List<? extends ExchangeId> fpmlRelatedExchangeId, InstrumentTypeEnum instrumentType) {
			if (fpmlRelatedExchangeId == null) {
				fpmlRelatedExchangeId = Collections.emptyList();
			}
			Asset.AssetBuilder asset = Asset.builder();
			return assignOutput(asset, fpmlIdentifiedAsset, fpmlExchangeId, fpmlRelatedExchangeId, instrumentType);
		}
		
		protected Asset.AssetBuilder assignOutput(Asset.AssetBuilder asset, IdentifiedAsset fpmlIdentifiedAsset, ExchangeId fpmlExchangeId, List<? extends ExchangeId> fpmlRelatedExchangeId, InstrumentTypeEnum instrumentType) {
			Boolean ifThenElseResult = null;
			if (exists(MapperS.of(fpmlExchangeId)).getOrDefault(false)) {
				ifThenElseResult = true;
			}
			asset = toBuilder(Asset.builder()
				.setInstrument(Instrument.builder()
					.setListedDerivative(ListedDerivative.builder()
						.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlIdentifiedAsset)))
						.setIsExchangeListed(ifThenElseResult)
						.setExchange(MapperS.of(fpmlExchangeId)
							.mapSingleToItem(item -> MapperS.of(mapExchangeIdToLegalEntity.evaluate(item.get()))).get())
						.setRelatedExchange(MapperC.<ExchangeId>of(fpmlRelatedExchangeId)
							.mapItem(item -> MapperS.of(mapExchangeIdToLegalEntity.evaluate(item.get()))).getMulti())
						.setInstrumentType(instrumentType)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(asset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
