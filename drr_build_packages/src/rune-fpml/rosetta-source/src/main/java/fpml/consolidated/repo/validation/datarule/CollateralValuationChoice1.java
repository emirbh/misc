package fpml.consolidated.repo.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.CollateralValuation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CollateralValuationChoice1")
@ImplementedBy(CollateralValuationChoice1.Default.class)
public interface CollateralValuationChoice1 extends Validator<CollateralValuation> {
	
	String NAME = "CollateralValuationChoice1";
	String DEFINITION = "optional choice nominalAmount, unitPrice";
	
	class Default implements CollateralValuationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuation collateralValuation) {
			ComparisonResult result = executeDataRule(collateralValuation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValuation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValuation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralValuation collateralValuation) {
			try {
				return choice(MapperS.of(collateralValuation), Arrays.asList("nominalAmount", "unitPrice"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralValuationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuation collateralValuation) {
			return Collections.emptyList();
		}
	}
}
