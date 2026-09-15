package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.Basket;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.util.IndexDeepPathUtil;
import cdm.product.asset.BondReference;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsCommoditySwap;
import drr.base.qualification.product.functions.IsCommoditySwaption;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetUnderlierProductIdentifierLeg1.GetUnderlierProductIdentifierLeg1Default.class)
public abstract class GetUnderlierProductIdentifierLeg1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityLeg1 commodityLeg1;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected InterestRateLeg1 interestRateLeg1;
	@Inject protected IsCommoditySwap isCommoditySwap;
	@Inject protected IsCommoditySwaption isCommoditySwaption;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param product 
	* @return productId 
	*/
	public List<? extends AssetIdentifier> evaluate(NonTransferableProduct product) {
		List<AssetIdentifier.AssetIdentifierBuilder> productIdBuilder = doEvaluate(product);
		
		final List<? extends AssetIdentifier> productId;
		if (productIdBuilder == null) {
			productId = null;
		} else {
			productId = productIdBuilder.stream().map(AssetIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(AssetIdentifier.class, productId);
		}
		
		return productId;
	}

	protected abstract List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(NonTransferableProduct product);

	protected abstract MapperC<? extends ProductIdentifier> swaptionsProductId(NonTransferableProduct product);

	public static class GetUnderlierProductIdentifierLeg1Default extends GetUnderlierProductIdentifierLeg1 {
		@Override
		protected List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(NonTransferableProduct product) {
			List<AssetIdentifier.AssetIdentifierBuilder> productId = new ArrayList<>();
			return assignOutput(productId, product);
		}
		
		protected List<AssetIdentifier.AssetIdentifierBuilder> assignOutput(List<AssetIdentifier.AssetIdentifierBuilder> productId, NonTransferableProduct product) {
			final MapperC<Underlier> thenArg0;
			if (exists(MapperS.of(underlierForProduct.evaluate(product))).getOrDefault(false)) {
				thenArg0 = MapperC.of(Collections.singletonList(underlierForProduct.evaluate(product)));
			} else if (exists(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier())).getOrDefault(false)) {
				thenArg0 = MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier());
			} else {
				thenArg0 = MapperC.<Underlier>ofNull();
			}
			final MapperC<ReferenceWithMetaObservable> thenArg1 = thenArg0.<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable());
			final MapperListOfLists<AssetIdentifier> thenArg2 = thenArg1
				.mapItemToList(item -> {
					if (exists(item.<Observable>map("Type coercion", _referenceWithMetaObservable0 -> _referenceWithMetaObservable0 == null ? null : _referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity())).getOrDefault(false)) {
						return item.<Observable>map("Type coercion", _referenceWithMetaObservable1 -> _referenceWithMetaObservable1 == null ? null : _referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier());
					}
					if (exists(item.<Observable>map("Type coercion", _referenceWithMetaObservable2 -> _referenceWithMetaObservable2 == null ? null : _referenceWithMetaObservable2.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Loan>map("getLoan", instrument -> instrument.getLoan())).getOrDefault(false)) {
						return item.<Observable>map("Type coercion", _referenceWithMetaObservable3 -> _referenceWithMetaObservable3 == null ? null : _referenceWithMetaObservable3.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Loan>map("getLoan", instrument -> instrument.getLoan()).<AssetIdentifier>mapC("getIdentifier", loan -> loan.getIdentifier());
					}
					if (exists(item.<Observable>map("Type coercion", _referenceWithMetaObservable4 -> _referenceWithMetaObservable4 == null ? null : _referenceWithMetaObservable4.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
						return item.<Observable>map("Type coercion", _referenceWithMetaObservable5 -> _referenceWithMetaObservable5 == null ? null : _referenceWithMetaObservable5.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index));
					}
					if (exists(item.<Observable>map("Type coercion", _referenceWithMetaObservable6 -> _referenceWithMetaObservable6 == null ? null : _referenceWithMetaObservable6.getValue()).<Basket>map("getBasket", observable -> observable.getBasket())).getOrDefault(false)) {
						return item.<Observable>map("Type coercion", _referenceWithMetaObservable7 -> _referenceWithMetaObservable7 == null ? null : _referenceWithMetaObservable7.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<AssetIdentifier>mapC("getIdentifier", basket -> basket.getIdentifier());
					}
					return MapperC.<AssetIdentifier>ofNull();
				});
			productId.addAll(toBuilder(thenArg2
				.flattenList().getMulti()));
			
			if (exists(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier())).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()).getMulti()));
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwaption.evaluate(product))).andNullSafe(exists(MapperS.of(commodityLeg1.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()))).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(commodityLeg1.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()).getMulti()));
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwap.evaluate(product))).andNullSafe(exists(MapperS.of(commodityLeg1.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable2 -> referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()))).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(commodityLeg1.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable3 -> referenceWithMetaObservable3 == null ? null : referenceWithMetaObservable3.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()).getMulti()));
			} else if (exists(MapperS.of(commodityLeg1.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable4 -> referenceWithMetaObservable4 == null ? null : referenceWithMetaObservable4.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<AssetIdentifier>mapC("getIdentifier", basket -> basket.getIdentifier())).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(commodityLeg1.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable5 -> referenceWithMetaObservable5 == null ? null : referenceWithMetaObservable5.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<AssetIdentifier>mapC("getIdentifier", basket -> basket.getIdentifier()).getMulti()));
			} else if (exists(MapperS.of(commodityLeg1.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable6 -> referenceWithMetaObservable6 == null ? null : referenceWithMetaObservable6.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(commodityLeg1.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable7 -> referenceWithMetaObservable7 == null ? null : referenceWithMetaObservable7.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index)).getMulti()));
			} else if (exists(MapperS.of(interestRateLeg1.evaluate(product)).<BondReference>map("getBondReference", interestRatePayout -> interestRatePayout.getBondReference()).<Security>map("getBond", bondReference -> bondReference.getBond()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier())).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(interestRateLeg1.evaluate(product)).<BondReference>map("getBondReference", interestRatePayout -> interestRatePayout.getBondReference()).<Security>map("getBond", bondReference -> bondReference.getBond()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier()).getMulti()));
			} else if (exists(MapperS.of(underlierForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable8 -> referenceWithMetaObservable8 == null ? null : referenceWithMetaObservable8.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(underlierForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable9 -> referenceWithMetaObservable9 == null ? null : referenceWithMetaObservable9.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index)).getMulti()));
			} else {
				productId.addAll(toBuilder(Collections.<AssetIdentifier>emptyList()));
			}
			
			final MapperC<? extends ProductIdentifier> thenArg3 = swaptionsProductId(product)
				.filterItemNullSafe(item -> exists(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()).checkedMap("to-enum", e -> AssetIdTypeEnum.valueOf(e.name()), IllegalArgumentException.class)).get());
			productId.addAll(toBuilder(thenArg3
				.mapItem(item -> MapperS.of(AssetIdentifier.builder()
					.setIdentifier(item.<FieldWithMetaString>map("getIdentifier", productIdentifier -> productIdentifier.getIdentifier()).get())
					.setIdentifierType(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()).checkedMap("to-enum", e -> AssetIdTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.build())).getMulti()));
			
			return Optional.ofNullable(productId)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends ProductIdentifier> swaptionsProductId(NonTransferableProduct product) {
			if (exists(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier())).getOrDefault(false)) {
				return MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier());
			}
			return MapperC.<ProductIdentifier>ofNull();
		}
	}
}
