package fpml.consolidated.valuation.fpmlreporting.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.valuation.fpmlreporting.Portfolio;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PortfolioChoice")
@ImplementedBy(PortfolioChoice.Default.class)
public interface PortfolioChoice extends Validator<Portfolio> {
	
	String NAME = "PortfolioChoice";
	String DEFINITION = "optional choice tradeId, partyTradeIdentifier";
	
	class Default implements PortfolioChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Portfolio portfolio) {
			ComparisonResult result = executeDataRule(portfolio);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Portfolio", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Portfolio", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Portfolio portfolio) {
			try {
				return choice(MapperS.of(portfolio), Arrays.asList("tradeId", "partyTradeIdentifier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PortfolioChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Portfolio portfolio) {
			return Collections.emptyList();
		}
	}
}
