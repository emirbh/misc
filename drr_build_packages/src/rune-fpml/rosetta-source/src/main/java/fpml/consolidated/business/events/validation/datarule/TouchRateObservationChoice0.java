package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ClearingInstructions;
import fpml.consolidated.business.events.TouchRateObservation;
import fpml.consolidated.fpmlenum.ExerciseSideEnum;
import fpml.consolidated.shared.NonNegativePayment;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TouchRateObservationChoice0")
@ImplementedBy(TouchRateObservationChoice0.Default.class)
public interface TouchRateObservationChoice0 extends Validator<TouchRateObservation> {
	
	String NAME = "TouchRateObservationChoice0";
	String DEFINITION = "isExercisable is absent or exerciseSide is absent and payment is absent and clearingInstructions is absent";
	
	class Default implements TouchRateObservationChoice0 {
	
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
				return notExists(MapperS.of(touchRateObservation).<Boolean>map("getIsExercisable", _touchRateObservation -> _touchRateObservation.getIsExercisable())).orNullSafe(notExists(MapperS.of(touchRateObservation).<ExerciseSideEnum>map("getExerciseSide", _touchRateObservation -> _touchRateObservation.getExerciseSide())).andNullSafe(notExists(MapperS.of(touchRateObservation).<NonNegativePayment>map("getPayment", _touchRateObservation -> _touchRateObservation.getPayment()))).andNullSafe(notExists(MapperS.of(touchRateObservation).<ClearingInstructions>map("getClearingInstructions", _touchRateObservation -> _touchRateObservation.getClearingInstructions()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TouchRateObservationChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TouchRateObservation touchRateObservation) {
			return Collections.emptyList();
		}
	}
}
