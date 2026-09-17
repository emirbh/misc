package fpml.consolidated.asset.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.SimpleCreditDefaultSwap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SimpleCreditDefaultSwapChoice")
@ImplementedBy(SimpleCreditDefaultSwapChoice.Default.class)
public interface SimpleCreditDefaultSwapChoice extends Validator<SimpleCreditDefaultSwap> {
	
	String NAME = "SimpleCreditDefaultSwapChoice";
	String DEFINITION = "required choice referenceEntity, creditEntityReference";
	
	class Default implements SimpleCreditDefaultSwapChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SimpleCreditDefaultSwap simpleCreditDefaultSwap) {
			ComparisonResult result = executeDataRule(simpleCreditDefaultSwap);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SimpleCreditDefaultSwap", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SimpleCreditDefaultSwap", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SimpleCreditDefaultSwap simpleCreditDefaultSwap) {
			try {
				return choice(MapperS.of(simpleCreditDefaultSwap), Arrays.asList("referenceEntity", "creditEntityReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SimpleCreditDefaultSwapChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SimpleCreditDefaultSwap simpleCreditDefaultSwap) {
			return Collections.emptyList();
		}
	}
}
