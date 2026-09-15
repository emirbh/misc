package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.TaxonomyClassification;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommoditySwap;
import drr.base.qualification.product.functions.IsCommoditySwaption;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractCommodityClassificationLeg2.ExtractCommodityClassificationLeg2Default.class)
public abstract class ExtractCommodityClassificationLeg2 implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityLeg2 commodityLeg2;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommoditySwap isCommoditySwap;
	@Inject protected IsCommoditySwaption isCommoditySwaption;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
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

	public static class ExtractCommodityClassificationLeg2Default extends ExtractCommodityClassificationLeg2 {
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
			if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwaption.evaluate(product))).andNullSafe(exists(MapperS.of(commodityLeg2.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()))).getOrDefault(false)) {
				return MapperS.of(commodityLeg2.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwap.evaluate(product))).andNullSafe(exists(MapperS.of(commodityLeg2.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable2 -> referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()))).getOrDefault(false)) {
				return MapperS.of(commodityLeg2.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable3 -> referenceWithMetaObservable3 == null ? null : referenceWithMetaObservable3.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
			}
			final Boolean _boolean = qualify_Commodity_Forward.evaluate(economicTermsForProduct.evaluate(product));
			if ((_boolean == null ? false : _boolean)) {
				return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable4 -> referenceWithMetaObservable4 == null ? null : referenceWithMetaObservable4.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
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
