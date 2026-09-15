package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.CovenantObligationIdentifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CovenantObligationIdentifierChoice")
@ImplementedBy(CovenantObligationIdentifierChoice.Default.class)
public interface CovenantObligationIdentifierChoice extends Validator<CovenantObligationIdentifier> {
	
	String NAME = "CovenantObligationIdentifierChoice";
	String DEFINITION = "required choice covenantObligationId, versionedCovenantObligationId";
	
	class Default implements CovenantObligationIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CovenantObligationIdentifier covenantObligationIdentifier) {
			ComparisonResult result = executeDataRule(covenantObligationIdentifier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CovenantObligationIdentifier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CovenantObligationIdentifier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CovenantObligationIdentifier covenantObligationIdentifier) {
			try {
				return choice(MapperS.of(covenantObligationIdentifier), Arrays.asList("covenantObligationId", "versionedCovenantObligationId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CovenantObligationIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CovenantObligationIdentifier covenantObligationIdentifier) {
			return Collections.emptyList();
		}
	}
}
