package drr.regulation.csa.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.CommodityPayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsCommoditySwapFloatFloat;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.regulation.common.functions.CalculationPeriodToDaysCommodities;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CommodityBasisLeg1.CommodityBasisLeg1Default.class)
public abstract class CommodityBasisLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculationPeriodToDaysCommodities calculationPeriodToDaysCommodities;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommoditySwapFloatFloat isCommoditySwapFloatFloat;

	/**
	* @param product 
	* @return commodityLeg1 
	*/
	public CommodityPayout evaluate(NonTransferableProduct product) {
		CommodityPayout.CommodityPayoutBuilder commodityLeg1Builder = doEvaluate(product);
		
		final CommodityPayout commodityLeg1;
		if (commodityLeg1Builder == null) {
			commodityLeg1 = null;
		} else {
			commodityLeg1 = commodityLeg1Builder.build();
			objectValidator.validate(CommodityPayout.class, commodityLeg1);
		}
		
		return commodityLeg1;
	}

	protected abstract CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product);

	protected abstract MapperC<? extends CommodityPayout> commodityPayouts(NonTransferableProduct product);

	public static class CommodityBasisLeg1Default extends CommodityBasisLeg1 {
		@Override
		protected CommodityPayout.CommodityPayoutBuilder doEvaluate(NonTransferableProduct product) {
			CommodityPayout.CommodityPayoutBuilder commodityLeg1 = CommodityPayout.builder();
			return assignOutput(commodityLeg1, product);
		}
		
		protected CommodityPayout.CommodityPayoutBuilder assignOutput(CommodityPayout.CommodityPayoutBuilder commodityLeg1, NonTransferableProduct product) {
			final Boolean _boolean = isCommoditySwapFloatFloat.evaluate(product);
			if ((_boolean == null ? false : _boolean)) {
				if (greaterThan(MapperS.of(distinctIgnoringPrecision(commodityPayouts(product).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
					commodityLeg1 = toBuilder(commodityPayouts(product)
						.min(item -> {
							final FieldWithMetaString fieldWithMetaString = item.<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).get();
							return fieldWithMetaString == null ? MapperS.<String>ofNull() : MapperS.of(fieldWithMetaString.getValue());
						}).get());
				} else if (areEqual(MapperS.of(distinctIgnoringPrecision(commodityPayouts(product).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
					commodityLeg1 = toBuilder(commodityPayouts(product)
						.min(item -> MapperS.of(calculationPeriodToDaysCommodities.evaluate(item.get()))).get());
				} else {
					commodityLeg1 = null;
				}
			} else {
				commodityLeg1 = null;
			}
			
			return Optional.ofNullable(commodityLeg1)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends CommodityPayout> commodityPayouts(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout());
		}
	}
}
