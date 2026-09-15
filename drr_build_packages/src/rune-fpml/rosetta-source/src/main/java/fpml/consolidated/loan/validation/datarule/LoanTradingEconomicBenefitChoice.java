package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanTradingEconomicBenefit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanTradingEconomicBenefitChoice")
@ImplementedBy(LoanTradingEconomicBenefitChoice.Default.class)
public interface LoanTradingEconomicBenefitChoice extends Validator<LoanTradingEconomicBenefit> {
	
	String NAME = "LoanTradingEconomicBenefitChoice";
	String DEFINITION = "optional choice eventIdentifier, commitmentAdjustment";
	
	class Default implements LoanTradingEconomicBenefitChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingEconomicBenefit loanTradingEconomicBenefit) {
			ComparisonResult result = executeDataRule(loanTradingEconomicBenefit);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradingEconomicBenefit", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradingEconomicBenefit", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanTradingEconomicBenefit loanTradingEconomicBenefit) {
			try {
				return choice(MapperS.of(loanTradingEconomicBenefit), Arrays.asList("eventIdentifier", "commitmentAdjustment"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanTradingEconomicBenefitChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingEconomicBenefit loanTradingEconomicBenefit) {
			return Collections.emptyList();
		}
	}
}
