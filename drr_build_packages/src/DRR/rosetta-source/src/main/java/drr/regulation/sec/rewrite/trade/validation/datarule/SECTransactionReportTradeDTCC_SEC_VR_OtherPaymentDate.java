package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportTradeDTCC_SEC_VR_OtherPaymentDate")
@ImplementedBy(SECTransactionReportTradeDTCC_SEC_VR_OtherPaymentDate.Default.class)
public interface SECTransactionReportTradeDTCC_SEC_VR_OtherPaymentDate extends Validator<SECTransactionReportTrade> {
	
	String NAME = "SECTransactionReportTradeDTCC_SEC_VR_OtherPaymentDate";
	String DEFINITION = "if otherPayment -> amount exists then otherPayment -> date exists and (otherPayment -> date count = otherPayment -> amount count) else otherPayment -> date is absent";
	
	class Default implements SECTransactionReportTradeDTCC_SEC_VR_OtherPaymentDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			ComparisonResult result = executeDataRule(sECTransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReportTrade sECTransactionReportTrade) {
			try {
				if (exists(MapperS.of(sECTransactionReportTrade).<OtherPayment>mapC("getOtherPayment", _sECTransactionReportTrade -> _sECTransactionReportTrade.getOtherPayment()).<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount())).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReportTrade).<OtherPayment>mapC("getOtherPayment", _sECTransactionReportTrade -> _sECTransactionReportTrade.getOtherPayment()).<Date>map("getDate", otherPayment -> otherPayment.getDate())).andNullSafe(areEqual(MapperS.of(MapperS.of(sECTransactionReportTrade).<OtherPayment>mapC("getOtherPayment", _sECTransactionReportTrade -> _sECTransactionReportTrade.getOtherPayment()).<Date>map("getDate", otherPayment -> otherPayment.getDate()).resultCount()), MapperS.of(MapperS.of(sECTransactionReportTrade).<OtherPayment>mapC("getOtherPayment", _sECTransactionReportTrade -> _sECTransactionReportTrade.getOtherPayment()).<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).resultCount()), CardinalityOperator.All));
				}
				return notExists(MapperS.of(sECTransactionReportTrade).<OtherPayment>mapC("getOtherPayment", _sECTransactionReportTrade -> _sECTransactionReportTrade.getOtherPayment()).<Date>map("getDate", otherPayment -> otherPayment.getDate()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportTradeDTCC_SEC_VR_OtherPaymentDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
