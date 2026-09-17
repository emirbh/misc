package fpml.consolidated.asset.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Future;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FutureChoice")
@ImplementedBy(FutureChoice.Default.class)
public interface FutureChoice extends Validator<Future> {
	
	String NAME = "FutureChoice";
	String DEFINITION = "optional choice maturity, contractYearMonth";
	
	class Default implements FutureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Future future) {
			ComparisonResult result = executeDataRule(future);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Future", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Future", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Future future) {
			try {
				return choice(MapperS.of(future), Arrays.asList("maturity", "contractYearMonth"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FutureChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Future future) {
			return Collections.emptyList();
		}
	}
}
