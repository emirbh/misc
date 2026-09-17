package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.TermDeposit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TermDepositChoice")
@ImplementedBy(TermDepositChoice.Default.class)
public interface TermDepositChoice extends Validator<TermDeposit> {
	
	String NAME = "TermDepositChoice";
	String DEFINITION = "optional choice tenorName, tenorPeriod";
	
	class Default implements TermDepositChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermDeposit termDeposit) {
			ComparisonResult result = executeDataRule(termDeposit);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TermDeposit", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TermDeposit", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TermDeposit termDeposit) {
			try {
				return choice(MapperS.of(termDeposit), Arrays.asList("tenorName", "tenorPeriod"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TermDepositChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermDeposit termDeposit) {
			return Collections.emptyList();
		}
	}
}
