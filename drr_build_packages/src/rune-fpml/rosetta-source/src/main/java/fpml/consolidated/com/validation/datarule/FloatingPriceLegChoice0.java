package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.FloatingPriceLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FloatingPriceLegChoice0")
@ImplementedBy(FloatingPriceLegChoice0.Default.class)
public interface FloatingPriceLegChoice0 extends Validator<FloatingPriceLeg> {
	
	String NAME = "FloatingPriceLegChoice0";
	String DEFINITION = "required choice relativePaymentDates, paymentDates, masterAgreementPaymentDates";
	
	class Default implements FloatingPriceLegChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingPriceLeg floatingPriceLeg) {
			ComparisonResult result = executeDataRule(floatingPriceLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingPriceLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingPriceLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FloatingPriceLeg floatingPriceLeg) {
			try {
				return choice(MapperS.of(floatingPriceLeg), Arrays.asList("relativePaymentDates", "paymentDates", "masterAgreementPaymentDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FloatingPriceLegChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingPriceLeg floatingPriceLeg) {
			return Collections.emptyList();
		}
	}
}
