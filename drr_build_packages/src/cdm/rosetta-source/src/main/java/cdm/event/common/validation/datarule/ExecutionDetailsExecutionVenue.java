package cdm.event.common.validation.datarule;

import cdm.base.staticdata.party.LegalEntity;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.ExecutionTypeEnum;
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
@RosettaDataRule("ExecutionDetailsExecutionVenue")
@ImplementedBy(ExecutionDetailsExecutionVenue.Default.class)
public interface ExecutionDetailsExecutionVenue extends Validator<ExecutionDetails> {
	
	String NAME = "ExecutionDetailsExecutionVenue";
	String DEFINITION = "if executionType = ExecutionTypeEnum -> Electronic then executionVenue exists";
	
	class Default implements ExecutionDetailsExecutionVenue {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionDetails executionDetails) {
			ComparisonResult result = executeDataRule(executionDetails);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionDetails", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionDetails", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExecutionDetails executionDetails) {
			try {
				if (areEqual(MapperS.of(executionDetails).<ExecutionTypeEnum>map("getExecutionType", _executionDetails -> _executionDetails.getExecutionType()), MapperS.of(ExecutionTypeEnum.ELECTRONIC), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(executionDetails).<LegalEntity>map("getExecutionVenue", _executionDetails -> _executionDetails.getExecutionVenue()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExecutionDetailsExecutionVenue {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionDetails executionDetails) {
			return Collections.emptyList();
		}
	}
}
