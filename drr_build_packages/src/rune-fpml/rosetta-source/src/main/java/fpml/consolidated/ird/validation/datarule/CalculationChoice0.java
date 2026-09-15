package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.Calculation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CalculationChoice0")
@ImplementedBy(CalculationChoice0.Default.class)
public interface CalculationChoice0 extends Validator<Calculation> {
	
	String NAME = "CalculationChoice0";
	String DEFINITION = "optional choice notionalSchedule, fxLinkedNotionalSchedule";
	
	class Default implements CalculationChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Calculation calculation) {
			ComparisonResult result = executeDataRule(calculation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Calculation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Calculation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Calculation calculation) {
			try {
				return choice(MapperS.of(calculation), Arrays.asList("notionalSchedule", "fxLinkedNotionalSchedule"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Calculation calculation) {
			return Collections.emptyList();
		}
	}
}
