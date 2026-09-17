package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.ExecutionLanguage;
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
@RosettaDataRule("ExecutionLanguageNumberOfOriginals")
@ImplementedBy(ExecutionLanguageNumberOfOriginals.Default.class)
public interface ExecutionLanguageNumberOfOriginals extends Validator<ExecutionLanguage> {
	
	String NAME = "ExecutionLanguageNumberOfOriginals";
	String DEFINITION = "if standardLanguage = False then numberOfOriginals is absent";
	
	class Default implements ExecutionLanguageNumberOfOriginals {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionLanguage executionLanguage) {
			ComparisonResult result = executeDataRule(executionLanguage);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionLanguage", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionLanguage", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExecutionLanguage executionLanguage) {
			try {
				if (areEqual(MapperS.of(executionLanguage).<Boolean>map("getStandardLanguage", _executionLanguage -> _executionLanguage.getStandardLanguage()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(executionLanguage).<String>map("getNumberOfOriginals", _executionLanguage -> _executionLanguage.getNumberOfOriginals()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExecutionLanguageNumberOfOriginals {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionLanguage executionLanguage) {
			return Collections.emptyList();
		}
	}
}
