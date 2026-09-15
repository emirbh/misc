package iso20022.auth108.iso.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.CollateralPortfolioCode5Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CollateralPortfolioCode5ChoiceChoice")
@ImplementedBy(CollateralPortfolioCode5ChoiceChoice.Default.class)
public interface CollateralPortfolioCode5ChoiceChoice extends Validator<CollateralPortfolioCode5Choice> {
	
	String NAME = "CollateralPortfolioCode5ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements CollateralPortfolioCode5ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPortfolioCode5Choice collateralPortfolioCode5Choice) {
			ComparisonResult result = executeDataRule(collateralPortfolioCode5Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralPortfolioCode5Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralPortfolioCode5Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralPortfolioCode5Choice collateralPortfolioCode5Choice) {
			try {
				return choice(MapperS.of(collateralPortfolioCode5Choice), Arrays.asList("prtfl", "mrgnPrtflCd"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralPortfolioCode5ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPortfolioCode5Choice collateralPortfolioCode5Choice) {
			return Collections.emptyList();
		}
	}
}
