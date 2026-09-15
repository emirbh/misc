package iso20022.auth108.iso.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.CounterpartyTradeNature15Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CounterpartyTradeNature15ChoiceChoice")
@ImplementedBy(CounterpartyTradeNature15ChoiceChoice.Default.class)
public interface CounterpartyTradeNature15ChoiceChoice extends Validator<CounterpartyTradeNature15Choice> {
	
	String NAME = "CounterpartyTradeNature15ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements CounterpartyTradeNature15ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CounterpartyTradeNature15Choice counterpartyTradeNature15Choice) {
			ComparisonResult result = executeDataRule(counterpartyTradeNature15Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CounterpartyTradeNature15Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CounterpartyTradeNature15Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CounterpartyTradeNature15Choice counterpartyTradeNature15Choice) {
			try {
				return choice(MapperS.of(counterpartyTradeNature15Choice), Arrays.asList("fi", "nfi", "cntrlCntrPty", "othr"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CounterpartyTradeNature15ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CounterpartyTradeNature15Choice counterpartyTradeNature15Choice) {
			return Collections.emptyList();
		}
	}
}
