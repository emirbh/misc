package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.InterestLegResetDates;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("InterestLegResetDatesChoice")
@ImplementedBy(InterestLegResetDatesChoice.Default.class)
public interface InterestLegResetDatesChoice extends Validator<InterestLegResetDates> {
	
	String NAME = "InterestLegResetDatesChoice";
	String DEFINITION = "optional choice resetRelativeTo, resetFrequency";
	
	class Default implements InterestLegResetDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestLegResetDates interestLegResetDates) {
			ComparisonResult result = executeDataRule(interestLegResetDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestLegResetDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestLegResetDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InterestLegResetDates interestLegResetDates) {
			try {
				return choice(MapperS.of(interestLegResetDates), Arrays.asList("resetRelativeTo", "resetFrequency"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InterestLegResetDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestLegResetDates interestLegResetDates) {
			return Collections.emptyList();
		}
	}
}
