package fpml.consolidated.recordkeeping.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.ESMAProductUnderlyer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ESMAProductUnderlyerChoice0")
@ImplementedBy(ESMAProductUnderlyerChoice0.Default.class)
public interface ESMAProductUnderlyerChoice0 extends Validator<ESMAProductUnderlyer> {
	
	String NAME = "ESMAProductUnderlyerChoice0";
	String DEFINITION = "optional choice instrumentId, index";
	
	class Default implements ESMAProductUnderlyerChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAProductUnderlyer eSMAProductUnderlyer) {
			ComparisonResult result = executeDataRule(eSMAProductUnderlyer);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAProductUnderlyer", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAProductUnderlyer", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAProductUnderlyer eSMAProductUnderlyer) {
			try {
				return choice(MapperS.of(eSMAProductUnderlyer), Arrays.asList("instrumentId", "index"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAProductUnderlyerChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAProductUnderlyer eSMAProductUnderlyer) {
			return Collections.emptyList();
		}
	}
}
