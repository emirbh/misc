package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.Variance;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("VarianceChoice")
@ImplementedBy(VarianceChoice.Default.class)
public interface VarianceChoice extends Validator<Variance> {
	
	String NAME = "VarianceChoice";
	String DEFINITION = "required choice volatilityStrikePrice, varianceStrikePrice";
	
	class Default implements VarianceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Variance variance) {
			ComparisonResult result = executeDataRule(variance);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Variance", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Variance", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Variance variance) {
			try {
				return choice(MapperS.of(variance), Arrays.asList("volatilityStrikePrice", "varianceStrikePrice"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VarianceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Variance variance) {
			return Collections.emptyList();
		}
	}
}
