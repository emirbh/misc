package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.observable.asset.Basket;
import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import cdm.product.qualification.functions.Qualify_InterestRate_Fra;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsIRSwaption;
import drr.base.qualification.product.functions.IsProductETD;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.base.trade.underlier.functions.UnderlierProductIdentifier;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetUnderlyingIdentificationType.GetUnderlyingIdentificationTypeDefault.class)
public abstract class GetUnderlyingIdentificationType implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsIRSwaption isIRSwaption;
	@Inject protected IsProductETD isProductETD;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;
	@Inject protected Qualify_InterestRate_Fra qualify_InterestRate_Fra;
	@Inject protected UnderlierForProduct underlierForProduct;
	@Inject protected UnderlierProductIdentifier underlierProductIdentifier;

	/**
	* @param reportableEvent 
	* @return result 
	*/
	public UnderlyingIdentificationTypeEnum evaluate(ReportableEventBase reportableEvent) {
		UnderlyingIdentificationTypeEnum result = doEvaluate(reportableEvent);
		
		return result;
	}

	protected abstract UnderlyingIdentificationTypeEnum doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	public static class GetUnderlyingIdentificationTypeDefault extends GetUnderlyingIdentificationType {
		@Override
		protected UnderlyingIdentificationTypeEnum doEvaluate(ReportableEventBase reportableEvent) {
			UnderlyingIdentificationTypeEnum result = null;
			return assignOutput(result, reportableEvent);
		}
		
		protected UnderlyingIdentificationTypeEnum assignOutput(UnderlyingIdentificationTypeEnum result, ReportableEventBase reportableEvent) {
			if (exists(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable0 -> referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()).<Basket>map("getBasket", observable -> observable.getBasket())).orNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()))).orNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()))).getOrDefault(false)) {
				result = UnderlyingIdentificationTypeEnum.B;
			} else if (exists(MapperC.<AssetIdentifier>of(underlierProductIdentifier.evaluate(product(reportableEvent).get(), AssetIdTypeEnum.ISIN))).getOrDefault(false)) {
				result = UnderlyingIdentificationTypeEnum.I;
			} else if (exists(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable1 -> referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()).<Index>map("getIndex", observable -> observable.getIndex())).orNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()))).orNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_InterestRate.evaluate(economicTermsForProduct.evaluate(product(reportableEvent).get())))).andNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).orNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_Fra.evaluate(economicTermsForProduct.evaluate(product(reportableEvent).get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isProductETD.evaluate(product(reportableEvent).get()))).andNullSafe(exists(MapperS.of(underlierForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable2 -> referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()).<Index>map("getIndex", observable -> observable.getIndex())))).getOrDefault(false)) {
				result = UnderlyingIdentificationTypeEnum.X;
			} else {
				result = null;
			}
			
			return result;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			if (ComparisonResult.ofNullSafe(MapperS.of(isCreditSwaption.evaluate(productForEvent.evaluate(reportableEvent)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isIRSwaption.evaluate(productForEvent.evaluate(reportableEvent))))).getOrDefault(false)) {
				return MapperS.of(underlierForProduct.evaluate(productForEvent.evaluate(reportableEvent))).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct());
			}
			return MapperS.of(productForEvent.evaluate(reportableEvent));
		}
	}
}
