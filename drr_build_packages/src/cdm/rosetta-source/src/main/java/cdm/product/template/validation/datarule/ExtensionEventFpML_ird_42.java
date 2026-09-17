package cdm.product.template.validation.datarule;

import cdm.product.template.ExtensionEvent;
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
@RosettaDataRule("ExtensionEventFpML_ird_42")
@ImplementedBy(ExtensionEventFpML_ird_42.Default.class)
public interface ExtensionEventFpML_ird_42 extends Validator<ExtensionEvent> {
	
	String NAME = "ExtensionEventFpML_ird_42";
	String DEFINITION = "adjustedExerciseDate < adjustedExtendedTerminationDate";
	
	class Default implements ExtensionEventFpML_ird_42 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExtensionEvent extensionEvent) {
			ComparisonResult result = executeDataRule(extensionEvent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExtensionEvent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExtensionEvent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExtensionEvent extensionEvent) {
			try {
				return lessThan(MapperS.of(extensionEvent).<Date>map("getAdjustedExerciseDate", _extensionEvent -> _extensionEvent.getAdjustedExerciseDate()), MapperS.of(extensionEvent).<Date>map("getAdjustedExtendedTerminationDate", _extensionEvent -> _extensionEvent.getAdjustedExtendedTerminationDate()), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExtensionEventFpML_ird_42 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExtensionEvent extensionEvent) {
			return Collections.emptyList();
		}
	}
}
