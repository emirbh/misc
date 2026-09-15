package drr.regulation.sec.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_OptionPremiumCurrency")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_OptionPremiumCurrency.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_OptionPremiumCurrency extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_OptionPremiumCurrency";
	String DEFINITION = "if optionPremiumAmount > 0 then optionPremiumCurrency exists else optionPremiumCurrency is absent";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_OptionPremiumCurrency {
	
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
				if (greaterThan(MapperS.of(sECTransactionReport).<BigDecimal>map("getOptionPremiumAmount", _sECTransactionReport -> _sECTransactionReport.getOptionPremiumAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", _sECTransactionReport -> _sECTransactionReport.getOptionPremiumCurrency()));
				}
				return notExists(MapperS.of(sECTransactionReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", _sECTransactionReport -> _sECTransactionReport.getOptionPremiumCurrency()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_OptionPremiumCurrency {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
