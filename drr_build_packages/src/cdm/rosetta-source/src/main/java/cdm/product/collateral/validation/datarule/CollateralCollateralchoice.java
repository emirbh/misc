package cdm.product.collateral.validation.datarule;

import cdm.product.collateral.Collateral;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CollateralCollateralchoice")
@ImplementedBy(CollateralCollateralchoice.Default.class)
public interface CollateralCollateralchoice extends Validator<Collateral> {
	
	String NAME = "CollateralCollateralchoice";
	String DEFINITION = "optional choice independentAmount, portfolioIdentifier, collateralPortfolio";
	
	class Default implements CollateralCollateralchoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Collateral collateral) {
			ComparisonResult result = executeDataRule(collateral);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Collateral", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Collateral", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Collateral collateral) {
			try {
				return choice(MapperS.of(collateral), Arrays.asList("independentAmount", "portfolioIdentifier", "collateralPortfolio"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralCollateralchoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Collateral collateral) {
			return Collections.emptyList();
		}
	}
}
