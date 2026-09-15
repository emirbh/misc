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
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Option;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
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
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractCommodityClassification.ExtractCommodityClassificationDefault.class)
public abstract class ExtractCommodityClassification implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;

	/**
	* @param economicTerms 
	* @param taxonomySource 
	* @param ordinal 
	* @return commodityClassification 
	*/
	public String evaluate(EconomicTerms economicTerms, TaxonomySourceEnum taxonomySource, Integer ordinal) {
		String commodityClassification = doEvaluate(economicTerms, taxonomySource, ordinal);
		
		return commodityClassification;
	}

	protected abstract String doEvaluate(EconomicTerms economicTerms, TaxonomySourceEnum taxonomySource, Integer ordinal);

	protected abstract MapperS<? extends Commodity> commodityUnderlier(EconomicTerms economicTerms, TaxonomySourceEnum taxonomySource, Integer ordinal);

	protected abstract MapperC<? extends Taxonomy> taxonomy(EconomicTerms economicTerms, TaxonomySourceEnum taxonomySource, Integer ordinal);

	public static class ExtractCommodityClassificationDefault extends ExtractCommodityClassification {
		@Override
		protected String doEvaluate(EconomicTerms economicTerms, TaxonomySourceEnum taxonomySource, Integer ordinal) {
			String commodityClassification = null;
			return assignOutput(commodityClassification, economicTerms, taxonomySource, ordinal);
		}
		
		protected String assignOutput(String commodityClassification, EconomicTerms economicTerms, TaxonomySourceEnum taxonomySource, Integer ordinal) {
			final MapperC<TaxonomyClassification> thenArg = MapperS.of(taxonomy(economicTerms, taxonomySource, ordinal).get()).<TaxonomyValue>map("getValue", _taxonomy -> _taxonomy.getValue()).<TaxonomyClassification>mapC("getClassification", taxonomyValue -> taxonomyValue.getClassification())
				.filterItemNullSafe(item -> areEqual(item.<Integer>map("getOrdinal", taxonomyClassification -> taxonomyClassification.getOrdinal()), MapperS.of(ordinal), CardinalityOperator.All).get());
			commodityClassification = MapperS.of(thenArg.get()).<String>map("getValue", taxonomyClassification -> taxonomyClassification.getValue()).get();
			
			return commodityClassification;
		}
		
		@Override
		protected MapperS<? extends Commodity> commodityUnderlier(EconomicTerms economicTerms, TaxonomySourceEnum taxonomySource, Integer ordinal) {
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms)))).getOrDefault(false)) {
				return MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout())
					.first().<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
			}
			final Boolean boolean0 = qualify_Commodity_Option.evaluate(economicTerms);
			if ((boolean0 == null ? false : boolean0)) {
				return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
			}
			final Boolean boolean1 = qualify_Commodity_Swaption.evaluate(economicTerms);
			if ((boolean1 == null ? false : boolean1)) {
				return MapperS.of(economicTermsForProduct.evaluate(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout())
					.first().<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable2 -> referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
			}
			final Boolean boolean2 = qualify_Commodity_Forward.evaluate(economicTerms);
			if ((boolean2 == null ? false : boolean2)) {
				return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable3 -> referenceWithMetaObservable3 == null ? null : referenceWithMetaObservable3.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
			}
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).get()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable4 -> referenceWithMetaObservable4 == null ? null : referenceWithMetaObservable4.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity());
		}
		
		@Override
		protected MapperC<? extends Taxonomy> taxonomy(EconomicTerms economicTerms, TaxonomySourceEnum taxonomySource, Integer ordinal) {
			return commodityUnderlier(economicTerms, taxonomySource, ordinal).<Taxonomy>mapC("getTaxonomy", commodity -> commodity.getTaxonomy())
				.filterItemNullSafe(item -> areEqual(item.<TaxonomySourceEnum>map("getSource", _taxonomy -> _taxonomy.getSource()), MapperS.of(taxonomySource), CardinalityOperator.All).get());
		}
	}
}
