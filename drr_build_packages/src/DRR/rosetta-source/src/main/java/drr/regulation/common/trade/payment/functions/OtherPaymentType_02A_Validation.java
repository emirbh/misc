package drr.regulation.common.trade.payment.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.payment.OtherPayment;
import drr.base.trade.price.PriceFormat;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OtherPaymentType_02A_Validation.OtherPaymentType_02A_ValidationDefault.class)
public abstract class OtherPaymentType_02A_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param contractType 
	* @param otherPayment 
	* @param fixedRateLeg1 
	* @param fixedRateLeg2 
	* @param spreadLeg1 
	* @param spreadLeg2 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, List<? extends OtherPayment> otherPayment, BigDecimal fixedRateLeg1, BigDecimal fixedRateLeg2, PriceFormat spreadLeg1, PriceFormat spreadLeg2) {
		Boolean result = doEvaluate(actionType, assetClass, contractType, otherPayment, fixedRateLeg1, fixedRateLeg2, spreadLeg1, spreadLeg2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, List<? extends OtherPayment> otherPayment, BigDecimal fixedRateLeg1, BigDecimal fixedRateLeg2, PriceFormat spreadLeg1, PriceFormat spreadLeg2);

	public static class OtherPaymentType_02A_ValidationDefault extends OtherPaymentType_02A_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, List<? extends OtherPayment> otherPayment, BigDecimal fixedRateLeg1, BigDecimal fixedRateLeg2, PriceFormat spreadLeg1, PriceFormat spreadLeg2) {
			if (otherPayment == null) {
				otherPayment = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, contractType, otherPayment, fixedRateLeg1, fixedRateLeg2, spreadLeg1, spreadLeg2);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, List<? extends OtherPayment> otherPayment, BigDecimal fixedRateLeg1, BigDecimal fixedRateLeg2, PriceFormat spreadLeg1, PriceFormat spreadLeg2) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(assetClass), MapperS.of(CommonAssetClass.CRDT), CardinalityOperator.All)).getOrDefault(false)) {
				if (areEqual(MapperS.of(actionType), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).andNullSafe(notEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT)), MapperS.of(contractType), CardinalityOperator.Any)).andNullSafe(notExists(MapperS.of(fixedRateLeg1))).andNullSafe(notExists(MapperS.of(fixedRateLeg2))).andNullSafe(notExists(MapperS.of(spreadLeg1))).andNullSafe(notExists(MapperS.of(spreadLeg2))).getOrDefault(false)) {
					result = areEqual(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType()), MapperS.of(PaymentType4Code.UFRO), CardinalityOperator.Any).get();
				} else if (notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<BigDecimal>map("getAmount", _otherPayment -> _otherPayment.getAmount()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType()).resultCount()), CardinalityOperator.Any).andNullSafe(notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<ISOCurrencyCodeEnum>map("getCurrency", _otherPayment -> _otherPayment.getCurrency()).resultCount()), CardinalityOperator.Any)).andNullSafe(notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<ISOCurrencyCodeEnum>map("getCurrency", _otherPayment -> _otherPayment.getCurrency()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<Date>map("getDate", _otherPayment -> _otherPayment.getDate()).resultCount()), CardinalityOperator.Any)).andNullSafe(notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<String>map("getPayer", _otherPayment -> _otherPayment.getPayer()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<String>map("getReceiver", _otherPayment -> _otherPayment.getReceiver()).resultCount()), CardinalityOperator.Any)).getOrDefault(false)) {
					result = false;
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
