package fpml.consolidated.credit.event.notification.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.credit.event.notification.AffectedTransactionsChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AffectedTransactionsChoiceChoice")
@ImplementedBy(AffectedTransactionsChoiceChoice.Default.class)
public interface AffectedTransactionsChoiceChoice extends Validator<AffectedTransactionsChoice> {
	
	String NAME = "AffectedTransactionsChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements AffectedTransactionsChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AffectedTransactionsChoice affectedTransactionsChoice) {
			ComparisonResult result = executeDataRule(affectedTransactionsChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AffectedTransactionsChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AffectedTransactionsChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AffectedTransactionsChoice affectedTransactionsChoice) {
			try {
				return choice(MapperS.of(affectedTransactionsChoice), Arrays.asList("trade", "tradeReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AffectedTransactionsChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AffectedTransactionsChoice affectedTransactionsChoice) {
			return Collections.emptyList();
		}
	}
}
