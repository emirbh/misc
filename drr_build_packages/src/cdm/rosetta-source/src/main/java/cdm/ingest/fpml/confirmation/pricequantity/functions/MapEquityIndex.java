package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapExchangeIdToLegalEntity;
import cdm.observable.asset.EquityIndex;
import cdm.observable.asset.Index;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.ExchangeId;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapEquityIndex.MapEquityIndexDefault.class)
public abstract class MapEquityIndex implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapExchangeIdToLegalEntity mapExchangeIdToLegalEntity;

	/**
	* @param fpmlIndex 
	* @return index 
	*/
	public Index evaluate(fpml.consolidated.asset.Index fpmlIndex) {
		Index.IndexBuilder indexBuilder = doEvaluate(fpmlIndex);
		
		final Index index;
		if (indexBuilder == null) {
			index = null;
		} else {
			index = indexBuilder.build();
			objectValidator.validate(Index.class, index);
		}
		
		return index;
	}

	protected abstract Index.IndexBuilder doEvaluate(fpml.consolidated.asset.Index fpmlIndex);

	public static class MapEquityIndexDefault extends MapEquityIndex {
		@Override
		protected Index.IndexBuilder doEvaluate(fpml.consolidated.asset.Index fpmlIndex) {
			Index.IndexBuilder index = Index.builder();
			return assignOutput(index, fpmlIndex);
		}
		
		protected Index.IndexBuilder assignOutput(Index.IndexBuilder index, fpml.consolidated.asset.Index fpmlIndex) {
			Boolean ifThenElseResult = null;
			if (exists(MapperS.of(fpmlIndex).<ExchangeId>map("getExchangeId", _index -> _index.getExchangeId())).getOrDefault(false)) {
				ifThenElseResult = true;
			}
			index = toBuilder(Index.builder()
				.setEquityIndex(EquityIndex.builder()
					.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlIndex)))
					.setIsExchangeListed(ifThenElseResult)
					.setExchange(MapperS.of(fpmlIndex).<ExchangeId>map("getExchangeId", _index -> _index.getExchangeId())
						.mapSingleToItem(item -> MapperS.of(mapExchangeIdToLegalEntity.evaluate(item.get()))).get())
					.setRelatedExchange(MapperS.of(fpmlIndex).<ExchangeId>mapC("getRelatedExchangeId", _index -> _index.getRelatedExchangeId())
						.mapItem(item -> MapperS.of(mapExchangeIdToLegalEntity.evaluate(item.get()))).getMulti())
					.setNameValue(MapperS.of(fpmlIndex).<String>map("getDescription", _index -> _index.getDescription()).get())
					.setAssetClass(AssetClassEnum.EQUITY)
					.build())
				.build());
			
			return Optional.ofNullable(index)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
