package iso20022.auth030.esma.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.PortfolioCode3Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PortfolioCode3ChoiceChoice")
@ImplementedBy(PortfolioCode3ChoiceChoice.Default.class)
public interface PortfolioCode3ChoiceChoice extends Validator<PortfolioCode3Choice> {
	
	String NAME = "PortfolioCode3ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements PortfolioCode3ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioCode3Choice portfolioCode3Choice) {
			ComparisonResult result = executeDataRule(portfolioCode3Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PortfolioCode3Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PortfolioCode3Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PortfolioCode3Choice portfolioCode3Choice) {
			try {
				return choice(MapperS.of(portfolioCode3Choice), Arrays.asList("cd", "noPrtfl"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PortfolioCode3ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioCode3Choice portfolioCode3Choice) {
			return Collections.emptyList();
		}
	}
}
