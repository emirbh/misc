package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Cash;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapTransferCashAsset.MapTransferCashAssetDefault.class)
public abstract class MapTransferCashAsset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlNonNegativeMoney 
	* @return asset 
	*/
	public Asset evaluate(NonNegativeMoney fpmlNonNegativeMoney) {
		Asset.AssetBuilder assetBuilder = doEvaluate(fpmlNonNegativeMoney);
		
		final Asset asset;
		if (assetBuilder == null) {
			asset = null;
		} else {
			asset = assetBuilder.build();
			objectValidator.validate(Asset.class, asset);
		}
		
		return asset;
	}

	protected abstract Asset.AssetBuilder doEvaluate(NonNegativeMoney fpmlNonNegativeMoney);

	public static class MapTransferCashAssetDefault extends MapTransferCashAsset {
		@Override
		protected Asset.AssetBuilder doEvaluate(NonNegativeMoney fpmlNonNegativeMoney) {
			Asset.AssetBuilder asset = Asset.builder();
			return assignOutput(asset, fpmlNonNegativeMoney);
		}
		
		protected Asset.AssetBuilder assignOutput(Asset.AssetBuilder asset, NonNegativeMoney fpmlNonNegativeMoney) {
			if (exists(MapperS.of(fpmlNonNegativeMoney)).getOrDefault(false)) {
				final AssetIdentifier assetIdentifier = AssetIdentifier.builder()
					.setIdentifierValue(MapperS.of(fpmlNonNegativeMoney).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).<String>map("getValue", currency -> currency.getValue()).get())
					.setIdentifierType(AssetIdTypeEnum.CURRENCY_CODE)
					.build();
				asset = toBuilder(Asset.builder()
					.setCash(Cash.builder()
						.setIdentifier((assetIdentifier == null ? Collections.<AssetIdentifier>emptyList() : Collections.singletonList(assetIdentifier)))
						.build())
					.build());
			} else {
				asset = null;
			}
			
			return Optional.ofNullable(asset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
