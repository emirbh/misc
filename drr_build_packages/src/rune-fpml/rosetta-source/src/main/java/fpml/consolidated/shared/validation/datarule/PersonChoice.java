package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Person;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PersonChoice")
@ImplementedBy(PersonChoice.Default.class)
public interface PersonChoice extends Validator<Person> {
	
	String NAME = "PersonChoice";
	String DEFINITION = "optional choice middleName, initial";
	
	class Default implements PersonChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Person person) {
			ComparisonResult result = executeDataRule(person);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Person", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Person", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Person person) {
			try {
				return choice(MapperS.of(person), Arrays.asList("middleName", "initial"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PersonChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Person person) {
			return Collections.emptyList();
		}
	}
}
