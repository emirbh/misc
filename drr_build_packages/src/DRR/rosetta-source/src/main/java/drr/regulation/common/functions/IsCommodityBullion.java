package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.CommodityPayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.base.util.string.functions.StringContains;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsCommodityBullion.IsCommodityBullionDefault.class)
public abstract class IsCommodityBullion implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCRPBullion isCRPBullion;
	@Inject protected StringContains stringContains;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	protected abstract MapperS<? extends FieldWithMetaString> productIdentifier(NonTransferableProduct product);

	protected abstract MapperS<? extends FieldWithMetaString> productTaxonomy(NonTransferableProduct product);

	protected abstract MapperS<? extends FieldWithMetaString> productClass(NonTransferableProduct product);

	protected abstract MapperS<? extends FieldWithMetaString> commodityReferencePrice(NonTransferableProduct product);

	public static class IsCommodityBullionDefault extends IsCommodityBullion {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			if (exists(productClass(product)).andNullSafe(exists(commodityReferencePrice(product))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString0 = productClass(product).get();
				final FieldWithMetaString fieldWithMetaString1 = commodityReferencePrice(product).get();
				result = ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate((fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), "Metals:Precious"))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCRPBullion.evaluate((fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()))))).get();
			} else {
				final FieldWithMetaString fieldWithMetaString2 = productClass(product).get();
				if (exists(productClass(product)).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(stringContains.evaluate((fieldWithMetaString2 == null ? null : fieldWithMetaString2.getValue()), "Metals:Precious")))).getOrDefault(false)) {
					result = true;
				} else {
					final FieldWithMetaString fieldWithMetaString3 = commodityReferencePrice(product).get();
					if (exists(commodityReferencePrice(product)).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCRPBullion.evaluate((fieldWithMetaString3 == null ? null : fieldWithMetaString3.getValue()))))).getOrDefault(false)) {
						result = true;
					} else {
						result = false;
					}
				}
			}
			
			return result;
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> productIdentifier(NonTransferableProduct product) {
			final MapperC<ProductIdentifier> thenArg0 = MapperS.of(product).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier());
			final MapperC<ProductIdentifier> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaString>map("getIdentifier", _productIdentifier -> _productIdentifier.getIdentifier()).map("getMeta", a->a.getMeta()).map("getScheme", a->a.getScheme()), MapperS.of("http://www.fpml.org/coding-scheme/product-taxonomy"), CardinalityOperator.All).get());
			final MapperS<ProductIdentifier> thenArg2 = MapperS.of(thenArg1.get());
			return thenArg2
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", _productIdentifier -> _productIdentifier.getIdentifier()));
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> productTaxonomy(NonTransferableProduct product) {
			final MapperC<ProductTaxonomy> thenArg0 = MapperS.of(product).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy());
			final MapperC<ProductTaxonomy> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<TaxonomySourceEnum>map("getSource", _productTaxonomy -> _productTaxonomy.getSource()), MapperS.of(TaxonomySourceEnum.ISDA), CardinalityOperator.All).get());
			final MapperS<ProductTaxonomy> thenArg2 = MapperS.of(thenArg1.get());
			return thenArg2
				.mapSingleToItem(item -> item.<TaxonomyValue>map("getValue", _productTaxonomy -> _productTaxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName()));
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> productClass(NonTransferableProduct product) {
			if (exists(productTaxonomy(product)).andNullSafe(exists(productIdentifier(product))).getOrDefault(false)) {
				return MapperS.of(distinctIgnoringPrecision(MapperC.<FieldWithMetaString>of(productTaxonomy(product), productIdentifier(product))).get());
			}
			if (exists(productTaxonomy(product)).getOrDefault(false)) {
				return productTaxonomy(product);
			}
			if (exists(productIdentifier(product)).getOrDefault(false)) {
				return productIdentifier(product);
			}
			return MapperS.<FieldWithMetaString>ofNull();
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> commodityReferencePrice(NonTransferableProduct product) {
			final MapperC<AssetIdentifier> thenArg0 = MapperS.of(underlierForProduct.evaluate(product)).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier());
			final MapperC<AssetIdentifier> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISDACRP), CardinalityOperator.All).get());
			final MapperS<AssetIdentifier> thenArg2 = MapperS.of(thenArg1.get());
			final MapperC<AssetIdentifier> thenArg3 = MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", _referenceWithMetaObservable -> _referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier());
			final MapperC<AssetIdentifier> thenArg4 = thenArg3
				.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISDACRP), CardinalityOperator.All).get());
			final MapperS<AssetIdentifier> thenArg5 = MapperS.of(thenArg4.get());
			return MapperS.of(MapperC.<FieldWithMetaString>of(thenArg2
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())), thenArg5
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()))).get());
		}
	}
}
