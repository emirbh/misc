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
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportTradeDTCC_SEC_VR_OptionPremiumPaymentDate")
@ImplementedBy(SECTransactionReportTradeDTCC_SEC_VR_OptionPremiumPaymentDate.Default.class)
public interface SECTransactionReportTradeDTCC_SEC_VR_OptionPremiumPaymentDate extends Validator<SECTransactionReportTrade> {
	
	String NAME = "SECTransactionReportTradeDTCC_SEC_VR_OptionPremiumPaymentDate";
	String DEFINITION = "if optionPremiumAmount > 0 then optionPremiumPaymentDate exists else optionPremiumPaymentDate is absent";
	
	class Default implements SECTransactionReportTradeDTCC_SEC_VR_OptionPremiumPaymentDate {
	
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
				if (greaterThan(MapperS.of(sECTransactionReportTrade).<BigDecimal>map("getOptionPremiumAmount", _sECTransactionReportTrade -> _sECTransactionReportTrade.getOptionPremiumAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReportTrade).<Date>map("getOptionPremiumPaymentDate", _sECTransactionReportTrade -> _sECTransactionReportTrade.getOptionPremiumPaymentDate()));
				}
				return notExists(MapperS.of(sECTransactionReportTrade).<Date>map("getOptionPremiumPaymentDate", _sECTransactionReportTrade -> _sECTransactionReportTrade.getOptionPremiumPaymentDate()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportTradeDTCC_SEC_VR_OptionPremiumPaymentDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
