package drr.regulation.common.trade.payment.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.common.CommonAssetClass;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OtherPaymentType_02B_Validation.OtherPaymentType_02B_ValidationDefault.class)
public abstract class OtherPaymentType_02B_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param otherPayment 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends OtherPayment> otherPayment) {
		Boolean result = doEvaluate(actionType, assetClass, otherPayment);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends OtherPayment> otherPayment);

	public static class OtherPaymentType_02B_ValidationDefault extends OtherPaymentType_02B_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends OtherPayment> otherPayment) {
			if (otherPayment == null) {
				otherPayment = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, otherPayment);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, List<? extends OtherPayment> otherPayment) {
			if (areEqual(MapperS.of(ActionTypeEnum.TERM), MapperS.of(actionType), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(assetClass), MapperS.of(CommonAssetClass.CRDT), CardinalityOperator.All)).andNullSafe(exists(MapperC.<OtherPayment>of(otherPayment).<BigDecimal>map("getAmount", _otherPayment -> _otherPayment.getAmount())).orNullSafe(exists(MapperC.<OtherPayment>of(otherPayment).<ISOCurrencyCodeEnum>map("getCurrency", _otherPayment -> _otherPayment.getCurrency()))).orNullSafe(exists(MapperC.<OtherPayment>of(otherPayment).<String>map("getPayer", _otherPayment -> _otherPayment.getPayer()))).orNullSafe(exists(MapperC.<OtherPayment>of(otherPayment).<String>map("getReceiver", _otherPayment -> _otherPayment.getReceiver())))).getOrDefault(false)) {
				final ComparisonResult ifThenElseResult;
				if (notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<BigDecimal>map("getAmount", _otherPayment -> _otherPayment.getAmount()).resultCount()), CardinalityOperator.Any).orNullSafe(notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<ISOCurrencyCodeEnum>map("getCurrency", _otherPayment -> _otherPayment.getCurrency()).resultCount()), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<Date>map("getDate", _otherPayment -> _otherPayment.getDate()).resultCount()), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<String>map("getPayer", _otherPayment -> _otherPayment.getPayer()).resultCount()), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<String>map("getReceiver", _otherPayment -> _otherPayment.getReceiver()).resultCount()), CardinalityOperator.Any)).getOrDefault(false)) {
					ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(false));
				} else {
					ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				result = exists(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType())).andNullSafe(areEqual(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType()), MapperS.of(PaymentType4Code.UWIN), CardinalityOperator.All)).andNullSafe(ifThenElseResult).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
