package cdm.product.common.schedule.validation.datarule;

import cdm.product.common.schedule.ParametricDates;
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
@RosettaDataRule("ParametricDatesParametricDatesChoice")
@ImplementedBy(ParametricDatesParametricDatesChoice.Default.class)
public interface ParametricDatesParametricDatesChoice extends Validator<ParametricDates> {
	
	String NAME = "ParametricDatesParametricDatesChoice";
	String DEFINITION = "required choice dayDistribution, dayOfWeek";
	
	class Default implements ParametricDatesParametricDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricDates parametricDates) {
			ComparisonResult result = executeDataRule(parametricDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ParametricDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ParametricDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ParametricDates parametricDates) {
			try {
				return choice(MapperS.of(parametricDates), Arrays.asList("dayDistribution", "dayOfWeek"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ParametricDatesParametricDatesChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricDates parametricDates) {
			return Collections.emptyList();
		}
	}
}
