package drr.regulation.common.trade.payment.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.payment.OtherPayment;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OtherPaymentReceiver_Validation.OtherPaymentReceiver_ValidationDefault.class)
public abstract class OtherPaymentReceiver_Validation implements RosettaFunction {

	/**
	* @param otherPayment 
	* @return result 
	*/
	public Boolean evaluate(List<? extends OtherPayment> otherPayment) {
		Boolean result = doEvaluate(otherPayment);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<? extends OtherPayment> otherPayment);

	public static class OtherPaymentReceiver_ValidationDefault extends OtherPaymentReceiver_Validation {
		@Override
		protected Boolean doEvaluate(List<? extends OtherPayment> otherPayment) {
			if (otherPayment == null) {
				otherPayment = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, otherPayment);
		}
		
		protected Boolean assignOutput(Boolean result, List<? extends OtherPayment> otherPayment) {
			if (exists(MapperC.<OtherPayment>of(otherPayment).<BigDecimal>map("getAmount", _otherPayment -> _otherPayment.getAmount())).getOrDefault(false)) {
				result = exists(MapperC.<OtherPayment>of(otherPayment).<String>map("getReceiver", _otherPayment -> _otherPayment.getReceiver())).get();
			} else if (notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<BigDecimal>map("getAmount", _otherPayment -> _otherPayment.getAmount()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType()).resultCount()), CardinalityOperator.Any).andNullSafe(notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<PaymentType4Code>map("getPaymentType", _otherPayment -> _otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<ISOCurrencyCodeEnum>map("getCurrency", _otherPayment -> _otherPayment.getCurrency()).resultCount()), CardinalityOperator.Any)).andNullSafe(notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<ISOCurrencyCodeEnum>map("getCurrency", _otherPayment -> _otherPayment.getCurrency()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<Date>map("getDate", _otherPayment -> _otherPayment.getDate()).resultCount()), CardinalityOperator.Any)).andNullSafe(notEqual(MapperS.of(MapperC.<OtherPayment>of(otherPayment).<String>map("getPayer", _otherPayment -> _otherPayment.getPayer()).resultCount()), MapperS.of(MapperC.<OtherPayment>of(otherPayment).<String>map("getReceiver", _otherPayment -> _otherPayment.getReceiver()).resultCount()), CardinalityOperator.Any)).getOrDefault(false)) {
				result = false;
			} else {
				result = true;
			}
			
			return result;
		}
	}
}
