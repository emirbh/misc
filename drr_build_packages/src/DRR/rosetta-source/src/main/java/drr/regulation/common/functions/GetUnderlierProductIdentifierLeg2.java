package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.Basket;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.util.IndexDeepPathUtil;
import cdm.product.asset.BondReference;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferenceObligation;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
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

@ImplementedBy(GetUnderlierProductIdentifierLeg2.GetUnderlierProductIdentifierLeg2Default.class)
public abstract class GetUnderlierProductIdentifierLeg2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityLeg2 commodityLeg2;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected InterestRateLeg2 interestRateLeg2;
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

	public static class GetUnderlierProductIdentifierLeg2Default extends GetUnderlierProductIdentifierLeg2 {
		@Override
		protected List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(NonTransferableProduct product) {
			List<AssetIdentifier.AssetIdentifierBuilder> productId = new ArrayList<>();
			return assignOutput(productId, product);
		}
		
		protected List<AssetIdentifier.AssetIdentifierBuilder> assignOutput(List<AssetIdentifier.AssetIdentifierBuilder> productId, NonTransferableProduct product) {
			final MapperC<ReferenceObligation> thenArg0;
			if (exists(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", referenceInformation -> referenceInformation.getReferenceObligation())).getOrDefault(false)) {
				thenArg0 = MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", referenceInformation -> referenceInformation.getReferenceObligation());
			} else if (exists(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", referenceInformation -> referenceInformation.getReferenceObligation())).getOrDefault(false)) {
				thenArg0 = MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", referenceInformation -> referenceInformation.getReferenceObligation());
			} else {
				thenArg0 = MapperC.<ReferenceObligation>ofNull();
			}
			final MapperListOfLists<AssetIdentifier> thenArg1 = thenArg0
				.mapItemToList(item -> {
					if (exists(item.<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity())).getOrDefault(false)) {
						return item.<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier());
					}
					if (exists(item.<Loan>map("getLoan", referenceObligation -> referenceObligation.getLoan())).getOrDefault(false)) {
						return item.<Loan>map("getLoan", referenceObligation -> referenceObligation.getLoan()).<AssetIdentifier>mapC("getIdentifier", loan -> loan.getIdentifier());
					}
					return MapperC.<AssetIdentifier>ofNull();
				});
			productId.addAll(toBuilder(thenArg1
				.flattenList().getMulti()));
			
			if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwaption.evaluate(product))).andNullSafe(exists(MapperS.of(commodityLeg2.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()))).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(commodityLeg2.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()).getMulti()));
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwap.evaluate(product))).andNullSafe(exists(MapperS.of(commodityLeg2.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable2 -> referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()))).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(commodityLeg2.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable3 -> referenceWithMetaObservable3 == null ? null : referenceWithMetaObservable3.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()).getMulti()));
			} else if (exists(MapperS.of(commodityLeg2.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable4 -> referenceWithMetaObservable4 == null ? null : referenceWithMetaObservable4.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<AssetIdentifier>mapC("getIdentifier", basket -> basket.getIdentifier())).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(commodityLeg2.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable5 -> referenceWithMetaObservable5 == null ? null : referenceWithMetaObservable5.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<AssetIdentifier>mapC("getIdentifier", basket -> basket.getIdentifier()).getMulti()));
			} else if (exists(MapperS.of(commodityLeg2.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable6 -> referenceWithMetaObservable6 == null ? null : referenceWithMetaObservable6.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(commodityLeg2.evaluate(product)).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable7 -> referenceWithMetaObservable7 == null ? null : referenceWithMetaObservable7.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetIdentifier>mapC("chooseIdentifier", index -> indexDeepPathUtil.chooseIdentifier(index)).getMulti()));
			} else if (exists(MapperS.of(interestRateLeg2.evaluate(product)).<BondReference>map("getBondReference", interestRatePayout -> interestRatePayout.getBondReference()).<Security>map("getBond", bondReference -> bondReference.getBond())).getOrDefault(false)) {
				productId.addAll(toBuilder(MapperS.of(interestRateLeg2.evaluate(product)).<BondReference>map("getBondReference", interestRatePayout -> interestRatePayout.getBondReference()).<Security>map("getBond", bondReference -> bondReference.getBond()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier()).getMulti()));
			} else {
				productId.addAll(toBuilder(Collections.<AssetIdentifier>emptyList()));
			}
			
			return Optional.ofNullable(productId)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
