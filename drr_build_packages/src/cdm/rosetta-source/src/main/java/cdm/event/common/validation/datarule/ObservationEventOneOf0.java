package cdm.event.common.validation.datarule;

import cdm.event.common.ObservationEvent;
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
@RosettaDataRule("ObservationEventOneOf0")
@ImplementedBy(ObservationEventOneOf0.Default.class)
public interface ObservationEventOneOf0 extends Validator<ObservationEvent> {
	
	String NAME = "ObservationEventOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements ObservationEventOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationEvent observationEvent) {
			ComparisonResult result = executeDataRule(observationEvent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ObservationEvent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ObservationEvent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ObservationEvent observationEvent) {
			try {
				return choice(MapperS.of(observationEvent), Arrays.asList("creditEvent", "corporateAction"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ObservationEventOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationEvent observationEvent) {
			return Collections.emptyList();
		}
	}
}
