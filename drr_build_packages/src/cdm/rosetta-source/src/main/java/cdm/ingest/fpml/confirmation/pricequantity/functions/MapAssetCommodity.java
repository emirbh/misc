package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.DeliveryDateParameters;
import cdm.ingest.fpml.confirmation.datetime.functions.MapCommodityDeliveryDates;
import cdm.ingest.fpml.confirmation.other.functions.MapQuotationSideEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.fpmlenum.SpecifiedPriceEnum;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAssetCommodity.MapAssetCommodityDefault.class)
public abstract class MapAssetCommodity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapCommodityDeliveryDates mapCommodityDeliveryDates;
	@Inject protected MapQuotationSideEnum mapQuotationSideEnum;

	/**
	* @param fpmlCommodity 
	* @return asset 
	*/
	public Asset evaluate(Commodity fpmlCommodity) {
		Asset.AssetBuilder assetBuilder = doEvaluate(fpmlCommodity);
		
		final Asset asset;
		if (assetBuilder == null) {
			asset = null;
		} else {
			asset = assetBuilder.build();
			objectValidator.validate(Asset.class, asset);
		}
		
		return asset;
	}

	protected abstract Asset.AssetBuilder doEvaluate(Commodity fpmlCommodity);

	public static class MapAssetCommodityDefault extends MapAssetCommodity {
		@Override
		protected Asset.AssetBuilder doEvaluate(Commodity fpmlCommodity) {
			Asset.AssetBuilder asset = Asset.builder();
			return assignOutput(asset, fpmlCommodity);
		}
		
		protected Asset.AssetBuilder assignOutput(Asset.AssetBuilder asset, Commodity fpmlCommodity) {
			asset = toBuilder(Asset.builder()
				.setCommodity(cdm.base.staticdata.asset.common.Commodity.builder()
					.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlCommodity)))
					.setPriceQuoteType(mapQuotationSideEnum.evaluate(MapperS.of(fpmlCommodity).<SpecifiedPriceEnum>map("getSpecifiedPrice", commodity -> commodity.getSpecifiedPrice()).map("to-string", SpecifiedPriceEnum::toDisplayString).get()))
					.setDeliveryDateReference(DeliveryDateParameters.builder()
						.setDeliveryNearby(mapCommodityDeliveryDates.evaluate(fpmlCommodity))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(asset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
