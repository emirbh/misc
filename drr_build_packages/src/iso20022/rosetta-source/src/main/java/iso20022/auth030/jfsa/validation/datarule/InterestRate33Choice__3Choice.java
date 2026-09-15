package iso20022.auth030.jfsa.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.InterestRate33Choice__3;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("InterestRate33Choice__3Choice")
@ImplementedBy(InterestRate33Choice__3Choice.Default.class)
public interface InterestRate33Choice__3Choice extends Validator<InterestRate33Choice__3> {
	
	String NAME = "InterestRate33Choice__3Choice";
	String DEFINITION = "one-of";
	
	class Default implements InterestRate33Choice__3Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRate33Choice__3 interestRate33Choice__3) {
			ComparisonResult result = executeDataRule(interestRate33Choice__3);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRate33Choice__3", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRate33Choice__3", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InterestRate33Choice__3 interestRate33Choice__3) {
			try {
				return choice(MapperS.of(interestRate33Choice__3), Arrays.asList("fxd", "fltg"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InterestRate33Choice__3Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRate33Choice__3 interestRate33Choice__3) {
			return Collections.emptyList();
		}
	}
}
