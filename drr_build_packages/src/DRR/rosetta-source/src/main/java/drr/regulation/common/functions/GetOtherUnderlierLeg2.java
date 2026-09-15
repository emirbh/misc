package drr.regulation.common.functions;

import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.UnitType;
import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.RateSpecification;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsFRA;
import drr.base.qualification.product.functions.IsFXForward;
import drr.base.qualification.product.functions.IsFXOption;
import drr.base.qualification.product.functions.IsFXSwap;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.enrichment.upi.functions.ConvertCurrency;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetOtherUnderlierLeg2.GetOtherUnderlierLeg2Default.class)
public abstract class GetOtherUnderlierLeg2 implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertCurrency convertCurrency;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected FXLeg2 fXLeg2;
	@Inject protected FXSwapLeg2 fXSwapLeg2;
	@Inject protected InterestRateLeg2 interestRateLeg2;
	@Inject protected IsFRA isFRA;
	@Inject protected IsFXForward isFXForward;
	@Inject protected IsFXOption isFXOption;
	@Inject protected IsFXSwap isFXSwap;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param product 
	* @return otherId 
	*/
	public String evaluate(NonTransferableProduct product) {
		String otherId = doEvaluate(product);
		
		return otherId;
	}

	protected abstract String doEvaluate(NonTransferableProduct product);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product);

	public static class GetOtherUnderlierLeg2Default extends GetOtherUnderlierLeg2 {
		@Override
		protected String doEvaluate(NonTransferableProduct product) {
			String otherId = null;
			return assignOutput(otherId, product);
		}
		
		protected String assignOutput(String otherId, NonTransferableProduct product) {
			if (exists(MapperS.of(economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation())).andNullSafe(notExists(economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName()))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString0 = MapperS.of(economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName()).get();
				if (fieldWithMetaString0 == null) {
					otherId = null;
				} else {
					otherId = fieldWithMetaString0.getValue();
				}
			} else if (exists(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation())).andNullSafe(notExists(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName()))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString1 = MapperS.of(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).<FieldWithMetaString>map("getName", creditIndex -> creditIndex.getName()).get();
				if (fieldWithMetaString1 == null) {
					otherId = null;
				} else {
					otherId = fieldWithMetaString1.getValue();
				}
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isFRA.evaluate(product))).andNullSafe(notExists(MapperS.of(interestRateLeg2.evaluate(product)).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex0 -> referenceWithMetaInterestRateIndex0 == null ? null : referenceWithMetaInterestRateIndex0.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaString>map("getName", floatingRateIndex -> floatingRateIndex.getName()))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString2 = MapperS.of(interestRateLeg2.evaluate(product)).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex1 -> referenceWithMetaInterestRateIndex1 == null ? null : referenceWithMetaInterestRateIndex1.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaString>map("getName", floatingRateIndex -> floatingRateIndex.getName()).get();
				if (fieldWithMetaString2 == null) {
					otherId = null;
				} else {
					otherId = fieldWithMetaString2.getValue();
				}
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXOption.evaluate(product)))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString3 = MapperS.of(fXLeg2.evaluate(product, null)).<NonNegativeQuantity>map("getQuantity", cashflow -> cashflow.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				otherId = convertCurrency.evaluate((fieldWithMetaString3 == null ? null : fieldWithMetaString3.getValue()));
			} else {
				final Boolean _boolean = isFXSwap.evaluate(product);
				if ((_boolean == null ? false : _boolean)) {
					final FieldWithMetaString fieldWithMetaString4 = MapperS.of(fXSwapLeg2.evaluate(product, null)).<NonNegativeQuantity>map("getQuantity", cashflow -> cashflow.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					otherId = convertCurrency.evaluate((fieldWithMetaString4 == null ? null : fieldWithMetaString4.getValue()));
				} else {
					otherId = null;
				}
			}
			
			return otherId;
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product));
		}
	}
}
