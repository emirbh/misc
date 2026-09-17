package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityPositionStatementChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FacilityPositionStatementChoiceChoice")
@ImplementedBy(FacilityPositionStatementChoiceChoice.Default.class)
public interface FacilityPositionStatementChoiceChoice extends Validator<FacilityPositionStatementChoice> {
	
	String NAME = "FacilityPositionStatementChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements FacilityPositionStatementChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityPositionStatementChoice facilityPositionStatementChoice) {
			ComparisonResult result = executeDataRule(facilityPositionStatementChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityPositionStatementChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityPositionStatementChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FacilityPositionStatementChoice facilityPositionStatementChoice) {
			try {
				return choice(MapperS.of(facilityPositionStatementChoice), Arrays.asList("contractIdentifier", "contractSummary", "contract"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FacilityPositionStatementChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityPositionStatementChoice facilityPositionStatementChoice) {
			return Collections.emptyList();
		}
	}
}
