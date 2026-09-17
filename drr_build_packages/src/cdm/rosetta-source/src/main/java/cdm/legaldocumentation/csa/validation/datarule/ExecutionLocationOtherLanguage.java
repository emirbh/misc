package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.common.ExecutionLocationEnum;
import cdm.legaldocumentation.csa.ExecutionLocation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ExecutionLocationOtherLanguage")
@ImplementedBy(ExecutionLocationOtherLanguage.Default.class)
public interface ExecutionLocationOtherLanguage extends Validator<ExecutionLocation> {
	
	String NAME = "ExecutionLocationOtherLanguage";
	String DEFINITION = "if executionLocation = ExecutionLocationEnum -> OtherLocation then otherLanguage exists";
	
	class Default implements ExecutionLocationOtherLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionLocation executionLocation) {
			ComparisonResult result = executeDataRule(executionLocation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionLocation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionLocation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExecutionLocation executionLocation) {
			try {
				if (areEqual(MapperS.of(executionLocation).<ExecutionLocationEnum>map("getExecutionLocation", _executionLocation -> _executionLocation.getExecutionLocation()), MapperS.of(ExecutionLocationEnum.OTHER_LOCATION), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(executionLocation).<String>map("getOtherLanguage", _executionLocation -> _executionLocation.getOtherLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExecutionLocationOtherLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionLocation executionLocation) {
			return Collections.emptyList();
		}
	}
}
