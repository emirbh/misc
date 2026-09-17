package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ClearingInstructions;
import fpml.consolidated.business.events.NoTouchRateObservation;
import fpml.consolidated.fpmlenum.ExerciseSideEnum;
import fpml.consolidated.shared.NonNegativePayment;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("NoTouchRateObservationChoice0")
@ImplementedBy(NoTouchRateObservationChoice0.Default.class)
public interface NoTouchRateObservationChoice0 extends Validator<NoTouchRateObservation> {
	
	String NAME = "NoTouchRateObservationChoice0";
	String DEFINITION = "isExercisable is absent or exerciseSide is absent and payment is absent and clearingInstructions is absent";
	
	class Default implements NoTouchRateObservationChoice0 {
	
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
				return notExists(MapperS.of(noTouchRateObservation).<Boolean>map("getIsExercisable", _noTouchRateObservation -> _noTouchRateObservation.getIsExercisable())).orNullSafe(notExists(MapperS.of(noTouchRateObservation).<ExerciseSideEnum>map("getExerciseSide", _noTouchRateObservation -> _noTouchRateObservation.getExerciseSide())).andNullSafe(notExists(MapperS.of(noTouchRateObservation).<NonNegativePayment>map("getPayment", _noTouchRateObservation -> _noTouchRateObservation.getPayment()))).andNullSafe(notExists(MapperS.of(noTouchRateObservation).<ClearingInstructions>map("getClearingInstructions", _noTouchRateObservation -> _noTouchRateObservation.getClearingInstructions()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NoTouchRateObservationChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchRateObservation noTouchRateObservation) {
			return Collections.emptyList();
		}
	}
}
