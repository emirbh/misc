package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.ReturnSwapNotional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ReturnSwapNotionalChoice")
@ImplementedBy(ReturnSwapNotionalChoice.Default.class)
public interface ReturnSwapNotionalChoice extends Validator<ReturnSwapNotional> {
	
	String NAME = "ReturnSwapNotionalChoice";
	String DEFINITION = "required choice relativeNotionalAmount, relativeDeterminationMethod, determinationMethod, notionalAmount";
	
	class Default implements ReturnSwapNotionalChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapNotional returnSwapNotional) {
			ComparisonResult result = executeDataRule(returnSwapNotional);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReturnSwapNotional", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReturnSwapNotional", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReturnSwapNotional returnSwapNotional) {
			try {
				return choice(MapperS.of(returnSwapNotional), Arrays.asList("relativeNotionalAmount", "relativeDeterminationMethod", "determinationMethod", "notionalAmount"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReturnSwapNotionalChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapNotional returnSwapNotional) {
			return Collections.emptyList();
		}
	}
}
