package cdm.product.template.validation.datarule;

import cdm.product.template.EarlyTerminationEvent;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("EarlyTerminationEventFpML_ird_39")
@ImplementedBy(EarlyTerminationEventFpML_ird_39.Default.class)
public interface EarlyTerminationEventFpML_ird_39 extends Validator<EarlyTerminationEvent> {
	
	String NAME = "EarlyTerminationEventFpML_ird_39";
	String DEFINITION = "adjustedExerciseDate <= adjustedEarlyTerminationDate";
	
	class Default implements EarlyTerminationEventFpML_ird_39 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EarlyTerminationEvent earlyTerminationEvent) {
			ComparisonResult result = executeDataRule(earlyTerminationEvent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EarlyTerminationEvent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EarlyTerminationEvent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EarlyTerminationEvent earlyTerminationEvent) {
			try {
				return lessThanEquals(MapperS.of(earlyTerminationEvent).<Date>map("getAdjustedExerciseDate", _earlyTerminationEvent -> _earlyTerminationEvent.getAdjustedExerciseDate()), MapperS.of(earlyTerminationEvent).<Date>map("getAdjustedEarlyTerminationDate", _earlyTerminationEvent -> _earlyTerminationEvent.getAdjustedEarlyTerminationDate()), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EarlyTerminationEventFpML_ird_39 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EarlyTerminationEvent earlyTerminationEvent) {
			return Collections.emptyList();
		}
	}
}
