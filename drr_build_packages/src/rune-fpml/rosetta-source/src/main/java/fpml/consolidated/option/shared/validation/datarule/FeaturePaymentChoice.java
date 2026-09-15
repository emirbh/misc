package fpml.consolidated.option.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.FeaturePayment;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FeaturePaymentChoice")
@ImplementedBy(FeaturePaymentChoice.Default.class)
public interface FeaturePaymentChoice extends Validator<FeaturePayment> {
	
	String NAME = "FeaturePaymentChoice";
	String DEFINITION = "optional choice levelPercentage, amount";
	
	class Default implements FeaturePaymentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeaturePayment featurePayment) {
			ComparisonResult result = executeDataRule(featurePayment);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FeaturePayment", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FeaturePayment", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FeaturePayment featurePayment) {
			try {
				return choice(MapperS.of(featurePayment), Arrays.asList("levelPercentage", "amount"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FeaturePaymentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeaturePayment featurePayment) {
			return Collections.emptyList();
		}
	}
}
