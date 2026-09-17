package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.ExecutionLocation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ExecutionLocationDutyPaymentLanguage")
@ImplementedBy(ExecutionLocationDutyPaymentLanguage.Default.class)
public interface ExecutionLocationDutyPaymentLanguage extends Validator<ExecutionLocation> {
	
	String NAME = "ExecutionLocationDutyPaymentLanguage";
	String DEFINITION = "if dutyPaymentDate exists then dutyPaymentLanguage is absent";
	
	class Default implements ExecutionLocationDutyPaymentLanguage {
	
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
				if (exists(MapperS.of(executionLocation).<Date>map("getDutyPaymentDate", _executionLocation -> _executionLocation.getDutyPaymentDate())).getOrDefault(false)) {
					return notExists(MapperS.of(executionLocation).<String>map("getDutyPaymentLanguage", _executionLocation -> _executionLocation.getDutyPaymentLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExecutionLocationDutyPaymentLanguage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionLocation executionLocation) {
			return Collections.emptyList();
		}
	}
}
