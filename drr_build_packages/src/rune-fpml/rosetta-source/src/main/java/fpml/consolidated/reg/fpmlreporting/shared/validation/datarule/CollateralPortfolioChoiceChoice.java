package fpml.consolidated.reg.fpmlreporting.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolioChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CollateralPortfolioChoiceChoice")
@ImplementedBy(CollateralPortfolioChoiceChoice.Default.class)
public interface CollateralPortfolioChoiceChoice extends Validator<CollateralPortfolioChoice> {
	
	String NAME = "CollateralPortfolioChoiceChoice";
	String DEFINITION = "optional choice cash, nonCash";
	
	class Default implements CollateralPortfolioChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPortfolioChoice collateralPortfolioChoice) {
			ComparisonResult result = executeDataRule(collateralPortfolioChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralPortfolioChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralPortfolioChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralPortfolioChoice collateralPortfolioChoice) {
			try {
				return choice(MapperS.of(collateralPortfolioChoice), Arrays.asList("cash", "nonCash"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralPortfolioChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPortfolioChoice collateralPortfolioChoice) {
			return Collections.emptyList();
		}
	}
}
