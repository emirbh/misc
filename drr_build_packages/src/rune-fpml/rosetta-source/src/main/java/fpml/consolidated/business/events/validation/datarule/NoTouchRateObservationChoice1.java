package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.NoTouchRateObservation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("NoTouchRateObservationChoice1")
@ImplementedBy(NoTouchRateObservationChoice1.Default.class)
public interface NoTouchRateObservationChoice1 extends Validator<NoTouchRateObservation> {
	
	String NAME = "NoTouchRateObservationChoice1";
	String DEFINITION = "optional choice settlementType, cashSettlement, physicalSettlement, isExercisable";
	
	class Default implements NoTouchRateObservationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchRateObservation noTouchRateObservation) {
			ComparisonResult result = executeDataRule(noTouchRateObservation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchRateObservation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchRateObservation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NoTouchRateObservation noTouchRateObservation) {
			try {
				return choice(MapperS.of(noTouchRateObservation), Arrays.asList("settlementType", "cashSettlement", "physicalSettlement", "isExercisable"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NoTouchRateObservationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchRateObservation noTouchRateObservation) {
			return Collections.emptyList();
		}
	}
}
