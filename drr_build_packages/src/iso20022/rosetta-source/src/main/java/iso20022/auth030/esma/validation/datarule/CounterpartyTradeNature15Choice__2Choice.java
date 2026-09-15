package iso20022.auth030.esma.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.CounterpartyTradeNature15Choice__2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CounterpartyTradeNature15Choice__2Choice")
@ImplementedBy(CounterpartyTradeNature15Choice__2Choice.Default.class)
public interface CounterpartyTradeNature15Choice__2Choice extends Validator<CounterpartyTradeNature15Choice__2> {
	
	String NAME = "CounterpartyTradeNature15Choice__2Choice";
	String DEFINITION = "one-of";
	
	class Default implements CounterpartyTradeNature15Choice__2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CounterpartyTradeNature15Choice__2 counterpartyTradeNature15Choice__2) {
			ComparisonResult result = executeDataRule(counterpartyTradeNature15Choice__2);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CounterpartyTradeNature15Choice__2", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CounterpartyTradeNature15Choice__2", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CounterpartyTradeNature15Choice__2 counterpartyTradeNature15Choice__2) {
			try {
				return choice(MapperS.of(counterpartyTradeNature15Choice__2), Arrays.asList("fi", "nfi", "cntrlCntrPty", "othr"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CounterpartyTradeNature15Choice__2Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CounterpartyTradeNature15Choice__2 counterpartyTradeNature15Choice__2) {
			return Collections.emptyList();
		}
	}
}
