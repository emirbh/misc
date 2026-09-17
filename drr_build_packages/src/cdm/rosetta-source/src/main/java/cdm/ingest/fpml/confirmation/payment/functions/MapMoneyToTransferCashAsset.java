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
import fpml.consolidated.shared.Money;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapMoneyToTransferCashAsset.MapMoneyToTransferCashAssetDefault.class)
public abstract class MapMoneyToTransferCashAsset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmMoney 
	* @return asset 
	*/
	public Asset evaluate(Money fpmMoney) {
		Asset.AssetBuilder assetBuilder = doEvaluate(fpmMoney);
		
		final Asset asset;
		if (assetBuilder == null) {
			asset = null;
		} else {
			asset = assetBuilder.build();
			objectValidator.validate(Asset.class, asset);
		}
		
		return asset;
	}

	protected abstract Asset.AssetBuilder doEvaluate(Money fpmMoney);

	public static class MapMoneyToTransferCashAssetDefault extends MapMoneyToTransferCashAsset {
		@Override
		protected Asset.AssetBuilder doEvaluate(Money fpmMoney) {
			Asset.AssetBuilder asset = Asset.builder();
			return assignOutput(asset, fpmMoney);
		}
		
		protected Asset.AssetBuilder assignOutput(Asset.AssetBuilder asset, Money fpmMoney) {
			if (exists(MapperS.of(fpmMoney)).getOrDefault(false)) {
				final AssetIdentifier assetIdentifier = AssetIdentifier.builder()
					.setIdentifierValue(MapperS.of(fpmMoney).<Currency>map("getCurrency", money -> money.getCurrency()).<String>map("getValue", currency -> currency.getValue()).get())
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
