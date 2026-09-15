package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.TaxonomyClassification;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.CommodityPayout;
import cdm.product.qualification.functions.Qualify_Commodity_Option;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommodityFloatingPriceForward;
import drr.base.qualification.product.functions.IsCommoditySwap;
import drr.base.qualification.product.functions.IsCommoditySwaption;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractCommodityClassificationLeg1.ExtractCommodityClassificationLeg1Default.class)
public abstract class ExtractCommodityClassificationLeg1 implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityLeg1 commodityLeg1;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommodityFloatingPriceForward isCommodityFloatingPriceForward;
	@Inject protected IsCommoditySwap isCommoditySwap;
	@Inject protected IsCommoditySwaption isCommoditySwaption;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param product 
	* @param taxonomySource 
	* @param ordinal 
	* @return commodityClassification 
	*/
	public String evaluate(NonTransferableProduct product, TaxonomySourceEnum taxonomySource, Integer ordinal) {
		String commodityClassification = doEvaluate(product, taxonomySource, ordinal);
		
		return commodityClassification;
	}

	protected abstract String doEvaluate(NonTransferableProduct product, TaxonomySourceEnum taxonomySource, Integer ordinal);

	protected abstract MapperS<? extends Commodity> commodityUnderlier(NonTransferableProduct product, TaxonomySourceEnum taxonomySource, Integer ordinal);

	protected abstract MapperC<? extends Taxonomy> taxonomy(NonTransferableProduct product, TaxonomySourceEnum taxonomySource, Integer ordinal);

	public static class ExtractCommodityClassificationLeg1Default extends ExtractCommodityClassificationLeg1 {
		@Override
		protected String doEvaluate(NonTransferableProduct product, TaxonomySourceEnum taxonomySource, Integer ordinal) {
			String commodityClassification = null;
			return assignOutput(commodityClassification, product, taxonomySource, ordinal);
		}
		
		protected String assignOutput(String commodityClassification, NonTransferableProduct product, TaxonomySourceEnum taxonomySource, Integer ordinal) {
			final MapperC<TaxonomyClassification> thenArg = MapperS.of(taxonomy(product, taxonomySource, ordinal).get()).<TaxonomyValue>map("getValue", _taxonomy -> _taxonomy.getValue()).<TaxonomyClassification>mapC("getClassification", taxonomyValue -> taxonomyValue.getClassification())
				.filterItemNullSafe(item -> areEqual(item.<Integer>map("getOrdinal", taxonomyClassification -> taxonomyClassification.getOrdinal()), MapperS.of(ordinal), CardinalityOperator.All).get());
			commodityClassification = MapperS.of(thenArg.get()).<String>map("getValue", taxonomyClassification -> taxonomyClassification.getValue()).get();
			
			return commodityClassification;
		}
		
		@Override
		protected MapperS<? extends Commodity> commodityUnderlier(NonTransferableProduct product, TaxonomySourceEnum taxonomySource, Integer ordinal) {
			final Boolean boolean0 = qualify_Commodity_Option.evaluate(economicTermsForProduct.evaluate(product));
			if ((boolean0 == null ? false : boolean0)) {
				return MapperS.of(underlierForProduct.evaluate(product)).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwaption.evaluate(product))).andNullSafe(exists(MapperS.of(commodityLeg1.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()))).getOrDefault(false)) {
				return MapperS.of(commodityLeg1.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable2 -> referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwap.evaluate(product))).andNullSafe(exists(MapperS.of(commodityLeg1.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable3 -> referenceWithMetaObservable3 == null ? null : referenceWithMetaObservable3.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()))).getOrDefault(false)) {
				return MapperS.of(commodityLeg1.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable4 -> referenceWithMetaObservable4 == null ? null : referenceWithMetaObservable4.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
			}
			final Boolean boolean1 = isCommodityFloatingPriceForward.evaluate(product);
			if ((boolean1 == null ? false : boolean1)) {
				return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).get()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable5 -> referenceWithMetaObservable5 == null ? null : referenceWithMetaObservable5.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
			}
			return MapperS.<Commodity>ofNull();
		}
		
		@Override
		protected MapperC<? extends Taxonomy> taxonomy(NonTransferableProduct product, TaxonomySourceEnum taxonomySource, Integer ordinal) {
			return commodityUnderlier(product, taxonomySource, ordinal).<Taxonomy>mapC("getTaxonomy", commodity -> commodity.getTaxonomy())
				.filterItemNullSafe(item -> areEqual(item.<TaxonomySourceEnum>map("getSource", _taxonomy -> _taxonomy.getSource()), MapperS.of(taxonomySource), CardinalityOperator.All).get());
		}
	}
}
