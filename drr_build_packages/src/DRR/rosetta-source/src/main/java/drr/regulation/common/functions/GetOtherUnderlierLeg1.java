package drr.regulation.common.functions;

import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.UnitType;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.RateSpecification;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsFRA;
import drr.base.qualification.product.functions.IsFXForward;
import drr.base.qualification.product.functions.IsFXOption;
import drr.base.qualification.product.functions.IsFXSwap;
import drr.enrichment.upi.functions.ConvertCurrency;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetOtherUnderlierLeg1.GetOtherUnderlierLeg1Default.class)
public abstract class GetOtherUnderlierLeg1 implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertCurrency convertCurrency;
	@Inject protected FXLeg1 fXLeg1;
	@Inject protected FXSwapLeg1 fXSwapLeg1;
	@Inject protected InterestRateLeg1 interestRateLeg1;
	@Inject protected IsFRA isFRA;
	@Inject protected IsFXForward isFXForward;
	@Inject protected IsFXOption isFXOption;
	@Inject protected IsFXSwap isFXSwap;

	/**
	* @param product 
	* @return otherId 
	*/
	public String evaluate(NonTransferableProduct product) {
		String otherId = doEvaluate(product);
		
		return otherId;
	}

	protected abstract String doEvaluate(NonTransferableProduct product);

	public static class GetOtherUnderlierLeg1Default extends GetOtherUnderlierLeg1 {
		@Override
		protected String doEvaluate(NonTransferableProduct product) {
			String otherId = null;
			return assignOutput(otherId, product);
		}
		
		protected String assignOutput(String otherId, NonTransferableProduct product) {
			if (ComparisonResult.ofNullSafe(MapperS.of(isFRA.evaluate(product))).andNullSafe(notExists(MapperS.of(interestRateLeg1.evaluate(product)).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex0 -> referenceWithMetaInterestRateIndex0 == null ? null : referenceWithMetaInterestRateIndex0.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaString>map("getName", floatingRateIndex -> floatingRateIndex.getName()))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString0 = MapperS.of(interestRateLeg1.evaluate(product)).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex1 -> referenceWithMetaInterestRateIndex1 == null ? null : referenceWithMetaInterestRateIndex1.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaString>map("getName", floatingRateIndex -> floatingRateIndex.getName()).get();
				if (fieldWithMetaString0 == null) {
					otherId = null;
				} else {
					otherId = fieldWithMetaString0.getValue();
				}
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXOption.evaluate(product)))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString1 = MapperS.of(fXLeg1.evaluate(product, null)).<NonNegativeQuantity>map("getQuantity", cashflow -> cashflow.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				otherId = convertCurrency.evaluate((fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()));
			} else {
				final Boolean _boolean = isFXSwap.evaluate(product);
				if ((_boolean == null ? false : _boolean)) {
					final FieldWithMetaString fieldWithMetaString2 = MapperS.of(fXSwapLeg1.evaluate(product, null)).<NonNegativeQuantity>map("getQuantity", cashflow -> cashflow.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					otherId = convertCurrency.evaluate((fieldWithMetaString2 == null ? null : fieldWithMetaString2.getValue()));
				} else {
					otherId = null;
				}
			}
			
			return otherId;
		}
	}
}
