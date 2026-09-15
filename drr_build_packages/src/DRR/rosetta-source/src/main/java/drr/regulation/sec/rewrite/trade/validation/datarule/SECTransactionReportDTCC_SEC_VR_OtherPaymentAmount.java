package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_OtherPaymentAmount")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_OtherPaymentAmount.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_OtherPaymentAmount extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_OtherPaymentAmount";
	String DEFINITION = "if otherPayment -> paymentType exists then otherPayment -> amount exists and (otherPayment -> amount count = otherPayment -> paymentType count) else otherPayment -> amount is absent";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_OtherPaymentAmount {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			ComparisonResult result = executeDataRule(sECTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReport sECTransactionReport) {
			try {
				if (exists(MapperS.of(sECTransactionReport).<OtherPayment>mapC("getOtherPayment", _sECTransactionReport -> _sECTransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType())).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<OtherPayment>mapC("getOtherPayment", _sECTransactionReport -> _sECTransactionReport.getOtherPayment()).<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount())).andNullSafe(areEqual(MapperS.of(MapperS.of(sECTransactionReport).<OtherPayment>mapC("getOtherPayment", _sECTransactionReport -> _sECTransactionReport.getOtherPayment()).<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).resultCount()), MapperS.of(MapperS.of(sECTransactionReport).<OtherPayment>mapC("getOtherPayment", _sECTransactionReport -> _sECTransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()).resultCount()), CardinalityOperator.All));
				}
				return notExists(MapperS.of(sECTransactionReport).<OtherPayment>mapC("getOtherPayment", _sECTransactionReport -> _sECTransactionReport.getOtherPayment()).<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_OtherPaymentAmount {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
