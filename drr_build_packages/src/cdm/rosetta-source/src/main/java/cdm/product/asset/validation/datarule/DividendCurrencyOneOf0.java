package cdm.product.asset.validation.datarule;

import cdm.product.asset.DividendCurrency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("DividendCurrencyOneOf0")
@ImplementedBy(DividendCurrencyOneOf0.Default.class)
public interface DividendCurrencyOneOf0 extends Validator<DividendCurrency> {
	
	String NAME = "DividendCurrencyOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements DividendCurrencyOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendCurrency dividendCurrency) {
			ComparisonResult result = executeDataRule(dividendCurrency);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendCurrency", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendCurrency", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DividendCurrency dividendCurrency) {
			try {
				return choice(MapperS.of(dividendCurrency), Arrays.asList("currency", "determinationMethod", "currencyReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendCurrencyOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendCurrency dividendCurrency) {
			return Collections.emptyList();
		}
	}
}
