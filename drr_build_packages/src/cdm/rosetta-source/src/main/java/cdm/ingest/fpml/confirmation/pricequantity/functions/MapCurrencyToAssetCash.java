package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Cash;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.Currency;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCurrencyToAssetCash.MapCurrencyToAssetCashDefault.class)
public abstract class MapCurrencyToAssetCash implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;

	/**
	* @param fpmlCurrency 
	* @return asset 
	*/
	public Asset evaluate(Currency fpmlCurrency) {
		Asset.AssetBuilder assetBuilder = doEvaluate(fpmlCurrency);
		
		final Asset asset;
		if (assetBuilder == null) {
			asset = null;
		} else {
			asset = assetBuilder.build();
			objectValidator.validate(Asset.class, asset);
		}
		
		return asset;
	}

	protected abstract Asset.AssetBuilder doEvaluate(Currency fpmlCurrency);

	public static class MapCurrencyToAssetCashDefault extends MapCurrencyToAssetCash {
		@Override
		protected Asset.AssetBuilder doEvaluate(Currency fpmlCurrency) {
			Asset.AssetBuilder asset = Asset.builder();
			return assignOutput(asset, fpmlCurrency);
		}
		
		protected Asset.AssetBuilder assignOutput(Asset.AssetBuilder asset, Currency fpmlCurrency) {
			final AssetIdentifier assetIdentifier = AssetIdentifier.builder()
				.setIdentifier(mapCurrency.evaluate(fpmlCurrency))
				.setIdentifierType(AssetIdTypeEnum.CURRENCY_CODE)
				.build();
			asset = toBuilder(Asset.builder()
				.setCash(Cash.builder()
					.setIdentifier((assetIdentifier == null ? Collections.<AssetIdentifier>emptyList() : Collections.singletonList(assetIdentifier)))
					.build())
				.build());
			
			return Optional.ofNullable(asset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
