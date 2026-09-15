package drr.regulation.common.trade.payment.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.payment.PeriodicPayment;
import drr.regulation.common.CommonAssetClass;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DayCountConvLeg1Fixed_Validation.DayCountConvLeg1Fixed_ValidationDefault.class)
public abstract class DayCountConvLeg1Fixed_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param fixedRateLeg1 
	* @param periodicPaymentLeg1 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal fixedRateLeg1, PeriodicPayment periodicPaymentLeg1) {
		Boolean result = doEvaluate(actionType, assetClass, fixedRateLeg1, periodicPaymentLeg1);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal fixedRateLeg1, PeriodicPayment periodicPaymentLeg1);

	public static class DayCountConvLeg1Fixed_ValidationDefault extends DayCountConvLeg1Fixed_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal fixedRateLeg1, PeriodicPayment periodicPaymentLeg1) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, fixedRateLeg1, periodicPaymentLeg1);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal fixedRateLeg1, PeriodicPayment periodicPaymentLeg1) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.INTR), MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM)), MapperS.of(assetClass), CardinalityOperator.Any)).getOrDefault(false)) {
				if (exists(MapperS.of(fixedRateLeg1)).getOrDefault(false)) {
					result = exists(MapperS.of(periodicPaymentLeg1).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", periodicPayment -> periodicPayment.getFixedRateDayCountConvention())).get();
				} else {
					result = null;
				}
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
