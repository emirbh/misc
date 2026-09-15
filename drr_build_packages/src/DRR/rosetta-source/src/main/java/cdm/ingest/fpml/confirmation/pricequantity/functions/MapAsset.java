package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.asset.Equity;
import fpml.consolidated.asset.ExchangeTradedContract;
import fpml.consolidated.asset.ExchangeTradedFund;
import fpml.consolidated.asset.Loan;
import fpml.consolidated.shared.ExchangeId;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAsset.MapAssetDefault.class)
public abstract class MapAsset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetCommodity mapAssetCommodity;
	@Inject protected MapIdentifiedAssetToAssetListedDerivative mapIdentifiedAssetToAssetListedDerivative;
	@Inject protected MapIdentifiedAssetToAssetSecurity mapIdentifiedAssetToAssetSecurity;

	/**
	* @param fpmlAsset 
	* @return asset 
	*/
	public Asset evaluate(fpml.consolidated.asset.Asset fpmlAsset) {
		Asset.AssetBuilder assetBuilder = doEvaluate(fpmlAsset);
		
		final Asset asset;
		if (assetBuilder == null) {
			asset = null;
		} else {
			asset = assetBuilder.build();
			objectValidator.validate(Asset.class, asset);
		}
		
		return asset;
	}

	protected abstract Asset.AssetBuilder doEvaluate(fpml.consolidated.asset.Asset fpmlAsset);

	public static class MapAssetDefault extends MapAsset {
		@Override
		protected Asset.AssetBuilder doEvaluate(fpml.consolidated.asset.Asset fpmlAsset) {
			Asset.AssetBuilder asset = Asset.builder();
			return assignOutput(asset, fpmlAsset);
		}
		
		protected Asset.AssetBuilder assignOutput(Asset.AssetBuilder asset, fpml.consolidated.asset.Asset fpmlAsset) {
			if (fpmlAsset == null) {
				asset = null;
			} else if (fpmlAsset instanceof ExchangeTradedFund) {
				final ExchangeTradedFund exchangeTradedFund = (ExchangeTradedFund) fpmlAsset;
				asset = toBuilder(mapIdentifiedAssetToAssetListedDerivative.evaluate(exchangeTradedFund, MapperS.of(exchangeTradedFund).<ExchangeId>map("getExchangeId", _exchangeTradedFund -> _exchangeTradedFund.getExchangeId()).get(), MapperS.of(exchangeTradedFund).<ExchangeId>mapC("getRelatedExchangeId", _exchangeTradedFund -> _exchangeTradedFund.getRelatedExchangeId()).getMulti(), InstrumentTypeEnum.FUND));
			} else if (fpmlAsset instanceof ExchangeTradedContract) {
				final ExchangeTradedContract exchangeTradedContract = (ExchangeTradedContract) fpmlAsset;
				asset = toBuilder(mapIdentifiedAssetToAssetListedDerivative.evaluate(exchangeTradedContract, MapperS.of(exchangeTradedContract).<ExchangeId>map("getExchangeId", _exchangeTradedContract -> _exchangeTradedContract.getExchangeId()).get(), MapperS.of(exchangeTradedContract).<ExchangeId>mapC("getRelatedExchangeId", _exchangeTradedContract -> _exchangeTradedContract.getRelatedExchangeId()).getMulti(), InstrumentTypeEnum.LISTED_DERIVATIVE));
			} else if (fpmlAsset instanceof Loan) {
				final Loan loan = (Loan) fpmlAsset;
				asset = toBuilder(mapIdentifiedAssetToAssetSecurity.evaluate(loan, MapperS.of(loan).<ExchangeId>map("getExchangeId", _loan -> _loan.getExchangeId()).get(), Collections.<ExchangeId>emptyList(), InstrumentTypeEnum.DEBT));
			} else if (fpmlAsset instanceof ConvertibleBond) {
				final ConvertibleBond convertibleBond = (ConvertibleBond) fpmlAsset;
				asset = toBuilder(mapIdentifiedAssetToAssetSecurity.evaluate(convertibleBond, null, Collections.<ExchangeId>emptyList(), InstrumentTypeEnum.DEBT));
			} else if (fpmlAsset instanceof Bond) {
				final Bond bond = (Bond) fpmlAsset;
				asset = toBuilder(mapIdentifiedAssetToAssetSecurity.evaluate(bond, null, Collections.<ExchangeId>emptyList(), InstrumentTypeEnum.DEBT));
			} else if (fpmlAsset instanceof Equity) {
				final Equity equity = (Equity) fpmlAsset;
				asset = toBuilder(mapIdentifiedAssetToAssetSecurity.evaluate(equity, MapperS.of(equity).<ExchangeId>map("getExchangeId", _equity -> _equity.getExchangeId()).get(), MapperS.of(equity).<ExchangeId>mapC("getRelatedExchangeId", _equity -> _equity.getRelatedExchangeId()).getMulti(), InstrumentTypeEnum.EQUITY));
			} else if (fpmlAsset instanceof Commodity) {
				final Commodity commodity = (Commodity) fpmlAsset;
				asset = toBuilder(mapAssetCommodity.evaluate(commodity));
			} else {
				asset = null;
			}
			
			return Optional.ofNullable(asset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
