package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.TransferFeeDefinitionChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TransferFeeDefinitionChoiceChoice")
@ImplementedBy(TransferFeeDefinitionChoiceChoice.Default.class)
public interface TransferFeeDefinitionChoiceChoice extends Validator<TransferFeeDefinitionChoice> {
	
	String NAME = "TransferFeeDefinitionChoiceChoice";
	String DEFINITION = "optional choice paymentRule, description";
	
	class Default implements TransferFeeDefinitionChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransferFeeDefinitionChoice transferFeeDefinitionChoice) {
			ComparisonResult result = executeDataRule(transferFeeDefinitionChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TransferFeeDefinitionChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TransferFeeDefinitionChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TransferFeeDefinitionChoice transferFeeDefinitionChoice) {
			try {
				return choice(MapperS.of(transferFeeDefinitionChoice), Arrays.asList("paymentRule", "description"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TransferFeeDefinitionChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransferFeeDefinitionChoice transferFeeDefinitionChoice) {
			return Collections.emptyList();
		}
	}
}
