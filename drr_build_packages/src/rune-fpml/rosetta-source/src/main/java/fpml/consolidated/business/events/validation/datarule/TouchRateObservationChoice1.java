package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TouchRateObservation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TouchRateObservationChoice1")
@ImplementedBy(TouchRateObservationChoice1.Default.class)
public interface TouchRateObservationChoice1 extends Validator<TouchRateObservation> {
	
	String NAME = "TouchRateObservationChoice1";
	String DEFINITION = "optional choice settlementType, cashSettlement, physicalSettlement, isExercisable";
	
	class Default implements TouchRateObservationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TouchRateObservation touchRateObservation) {
			ComparisonResult result = executeDataRule(touchRateObservation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TouchRateObservation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TouchRateObservation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TouchRateObservation touchRateObservation) {
			try {
				return choice(MapperS.of(touchRateObservation), Arrays.asList("settlementType", "cashSettlement", "physicalSettlement", "isExercisable"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TouchRateObservationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TouchRateObservation touchRateObservation) {
			return Collections.emptyList();
		}
	}
}
