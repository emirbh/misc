package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.OutstandingsPosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("OutstandingsPositionChoice")
@ImplementedBy(OutstandingsPositionChoice.Default.class)
public interface OutstandingsPositionChoice extends Validator<OutstandingsPosition> {
	
	String NAME = "OutstandingsPositionChoice";
	String DEFINITION = "required choice loanContractReference, letterOfCreditReference";
	
	class Default implements OutstandingsPositionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingsPosition outstandingsPosition) {
			ComparisonResult result = executeDataRule(outstandingsPosition);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OutstandingsPosition", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OutstandingsPosition", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OutstandingsPosition outstandingsPosition) {
			try {
				return choice(MapperS.of(outstandingsPosition), Arrays.asList("loanContractReference", "letterOfCreditReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OutstandingsPositionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingsPosition outstandingsPosition) {
			return Collections.emptyList();
		}
	}
}
