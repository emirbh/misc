package cdm.product.asset.validation.datarule;

import cdm.product.asset.DividendPaymentDate;
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
@RosettaDataRule("DividendPaymentDateOneOf0")
@ImplementedBy(DividendPaymentDateOneOf0.Default.class)
public interface DividendPaymentDateOneOf0 extends Validator<DividendPaymentDate> {
	
	String NAME = "DividendPaymentDateOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements DividendPaymentDateOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPaymentDate dividendPaymentDate) {
			ComparisonResult result = executeDataRule(dividendPaymentDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPaymentDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPaymentDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DividendPaymentDate dividendPaymentDate) {
			try {
				return choice(MapperS.of(dividendPaymentDate), Arrays.asList("dividendDateReference", "dividendDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendPaymentDateOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPaymentDate dividendPaymentDate) {
			return Collections.emptyList();
		}
	}
}
