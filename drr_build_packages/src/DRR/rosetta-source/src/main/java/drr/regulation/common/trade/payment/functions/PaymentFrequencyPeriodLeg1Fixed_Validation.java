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

@ImplementedBy(PaymentFrequencyPeriodLeg1Fixed_Validation.PaymentFrequencyPeriodLeg1Fixed_ValidationDefault.class)
public abstract class PaymentFrequencyPeriodLeg1Fixed_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param fixedRateLeg1 
	* @param assetClass 
	* @param contractType 
	* @param periodicPaymentLeg1 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, BigDecimal fixedRateLeg1, CommonAssetClass assetClass, CommonContractType contractType, PeriodicPayment periodicPaymentLeg1) {
		Boolean result = doEvaluate(actionType, fixedRateLeg1, assetClass, contractType, periodicPaymentLeg1);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, BigDecimal fixedRateLeg1, CommonAssetClass assetClass, CommonContractType contractType, PeriodicPayment periodicPaymentLeg1);

	public static class PaymentFrequencyPeriodLeg1Fixed_ValidationDefault extends PaymentFrequencyPeriodLeg1Fixed_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, BigDecimal fixedRateLeg1, CommonAssetClass assetClass, CommonContractType contractType, PeriodicPayment periodicPaymentLeg1) {
			Boolean result = null;
			return assignOutput(result, actionType, fixedRateLeg1, assetClass, contractType, periodicPaymentLeg1);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, BigDecimal fixedRateLeg1, CommonAssetClass assetClass, CommonContractType contractType, PeriodicPayment periodicPaymentLeg1) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.INTR), MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM)), MapperS.of(assetClass), CardinalityOperator.Any)).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.FRAS), MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OTHR)), MapperS.of(contractType), CardinalityOperator.Any)).getOrDefault(false)) {
				if (exists(MapperS.of(fixedRateLeg1)).getOrDefault(false)) {
					result = exists(MapperS.of(periodicPaymentLeg1).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", periodicPayment -> periodicPayment.getFixedRatePaymentFrequencyPeriod())).get();
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
