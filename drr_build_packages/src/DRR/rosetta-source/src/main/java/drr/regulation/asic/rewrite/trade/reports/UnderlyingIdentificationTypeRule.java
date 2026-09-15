package drr.regulation.asic.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.observable.asset.Basket;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsProductETD;
import drr.base.qualification.product.functions.IsSingleCommodityPayoutProduct;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.base.trade.underlier.functions.UnderlierProductIdentifier;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingIdentificationTypeRule.UnderlyingIdentificationTypeRuleDefault.class)
public abstract class UnderlyingIdentificationTypeRule implements ReportFunction<TransactionReportInstruction, UnderlyingIdentificationTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected IsProductETD isProductETD;
	@Inject protected IsSingleCommodityPayoutProduct isSingleCommodityPayoutProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;
	@Inject protected UnderlierProductIdentifier underlierProductIdentifier;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public UnderlyingIdentificationTypeEnum evaluate(TransactionReportInstruction input) {
		UnderlyingIdentificationTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract UnderlyingIdentificationTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class UnderlyingIdentificationTypeRuleDefault extends UnderlyingIdentificationTypeRule {
		@Override
		protected UnderlyingIdentificationTypeEnum doEvaluate(TransactionReportInstruction input) {
			UnderlyingIdentificationTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected UnderlyingIdentificationTypeEnum assignOutput(UnderlyingIdentificationTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final MapperS<NonTransferableProduct> thenArg1 = MapperS.of(productForEvent.evaluate(thenArg0.get()));
			output = thenArg1
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(underlierForProduct.evaluate(item.get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket())).orNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", _referenceWithMetaObservable -> _referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()))).orNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()))).orNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(item.get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isProductETD.evaluate(item.get()))).andNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", _referenceWithMetaObservable -> _referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()))).andNullSafe(areEqual(MapperS.of(isSingleCommodityPayoutProduct.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All))).getOrDefault(false)) {
						return MapperS.of(UnderlyingIdentificationTypeEnum.B);
					}
					if (exists(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), AssetIdTypeEnum.ISIN))).getOrDefault(false)) {
						return MapperS.of(UnderlyingIdentificationTypeEnum.I);
					}
					if (exists(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), null))).andNullSafe(notExists(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(item.get(), AssetIdTypeEnum.ISIN)))).getOrDefault(false)) {
						return MapperS.of(UnderlyingIdentificationTypeEnum.O);
					}
					return MapperS.<UnderlyingIdentificationTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
