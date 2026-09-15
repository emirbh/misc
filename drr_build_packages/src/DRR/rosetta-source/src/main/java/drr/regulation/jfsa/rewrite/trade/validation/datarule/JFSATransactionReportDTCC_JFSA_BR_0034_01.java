package drr.regulation.jfsa.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0034_01")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0034_01.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0034_01 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0034_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI, ActionTypeEnum -> PRTO, ActionTypeEnum -> EROR, ActionTypeEnum -> TERM] any = actionType then (if otherPayment -> amount exists or otherPayment -> currency exists or otherPayment -> date exists or otherPayment -> payer exists or otherPayment -> receiver exists then otherPayment -> paymentType exists else if otherPayment -> paymentType count <> otherPayment -> amount count or otherPayment -> paymentType count <> otherPayment -> currency count or otherPayment -> paymentType count <> otherPayment -> date count or otherPayment -> paymentType count <> otherPayment -> payer count or otherPayment -> paymentType count <> otherPayment -> receiver count then False)";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0034_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			ComparisonResult result = executeDataRule(jFSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(JFSATransactionReport jFSATransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.PRTO), MapperS.of(ActionTypeEnum.EROR), MapperS.of(ActionTypeEnum.TERM)), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (exists(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount())).orNullSafe(exists(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency()))).orNullSafe(exists(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<Date>map("getDate", otherPayment -> otherPayment.getDate()))).orNullSafe(exists(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<String>map("getPayer", otherPayment -> otherPayment.getPayer()))).orNullSafe(exists(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()))).getOrDefault(false)) {
						return exists(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()));
					}
					if (notEqual(MapperS.of(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).resultCount()), CardinalityOperator.Any).orNullSafe(notEqual(MapperS.of(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency()).resultCount()), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<Date>map("getDate", otherPayment -> otherPayment.getDate()).resultCount()), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<String>map("getPayer", otherPayment -> otherPayment.getPayer()).resultCount()), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).resultCount()), MapperS.of(MapperS.of(jFSATransactionReport).<OtherPayment>mapC("getOtherPayment", _jFSATransactionReport -> _jFSATransactionReport.getOtherPayment()).<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).resultCount()), CardinalityOperator.Any)).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(false));
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0034_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
