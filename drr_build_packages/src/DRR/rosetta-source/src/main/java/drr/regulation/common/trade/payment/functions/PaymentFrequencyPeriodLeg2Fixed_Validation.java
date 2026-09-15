package drr.regulation.common.trade.payment.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.payment.PeriodicPayment;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.FrequencyPeriodEnum;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PaymentFrequencyPeriodLeg2Fixed_Validation.PaymentFrequencyPeriodLeg2Fixed_ValidationDefault.class)
public abstract class PaymentFrequencyPeriodLeg2Fixed_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param fixedRateLeg2 
	* @param assetClass 
	* @param contractType 
	* @param periodicPaymentLeg2 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, BigDecimal fixedRateLeg2, CommonAssetClass assetClass, CommonContractType contractType, PeriodicPayment periodicPaymentLeg2) {
		Boolean result = doEvaluate(actionType, fixedRateLeg2, assetClass, contractType, periodicPaymentLeg2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, BigDecimal fixedRateLeg2, CommonAssetClass assetClass, CommonContractType contractType, PeriodicPayment periodicPaymentLeg2);

	public static class PaymentFrequencyPeriodLeg2Fixed_ValidationDefault extends PaymentFrequencyPeriodLeg2Fixed_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, BigDecimal fixedRateLeg2, CommonAssetClass assetClass, CommonContractType contractType, PeriodicPayment periodicPaymentLeg2) {
			Boolean result = null;
			return assignOutput(result, actionType, fixedRateLeg2, assetClass, contractType, periodicPaymentLeg2);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, BigDecimal fixedRateLeg2, CommonAssetClass assetClass, CommonContractType contractType, PeriodicPayment periodicPaymentLeg2) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.INTR), MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM)), MapperS.of(assetClass), CardinalityOperator.Any)).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.FRAS), MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OTHR)), MapperS.of(contractType), CardinalityOperator.Any)).getOrDefault(false)) {
				if (exists(MapperS.of(fixedRateLeg2)).getOrDefault(false)) {
					result = exists(MapperS.of(periodicPaymentLeg2).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", periodicPayment -> periodicPayment.getFixedRatePaymentFrequencyPeriod())).get();
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
