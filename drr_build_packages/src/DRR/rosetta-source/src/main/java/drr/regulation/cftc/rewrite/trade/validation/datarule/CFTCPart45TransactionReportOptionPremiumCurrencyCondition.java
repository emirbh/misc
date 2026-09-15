package drr.regulation.cftc.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportOptionPremiumCurrencyCondition")
@ImplementedBy(CFTCPart45TransactionReportOptionPremiumCurrencyCondition.Default.class)
public interface CFTCPart45TransactionReportOptionPremiumCurrencyCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportOptionPremiumCurrencyCondition";
	String DEFINITION = "if optionPremiumAmount > 0 then optionPremiumCurrency exists else optionPremiumCurrency is absent";
	
	class Default implements CFTCPart45TransactionReportOptionPremiumCurrencyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart45TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			try {
				if (greaterThan(MapperS.of(cFTCPart45TransactionReport).<BigDecimal>map("getOptionPremiumAmount", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getOptionPremiumAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart45TransactionReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getOptionPremiumCurrency()));
				}
				return notExists(MapperS.of(cFTCPart45TransactionReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getOptionPremiumCurrency()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportOptionPremiumCurrencyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
