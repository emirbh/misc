package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityPositionStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FacilityPositionStatementChoice1")
@ImplementedBy(FacilityPositionStatementChoice1.Default.class)
public interface FacilityPositionStatementChoice1 extends Validator<FacilityPositionStatement> {
	
	String NAME = "FacilityPositionStatementChoice1";
	String DEFINITION = "required choice facilityIdentifier, facilitySummary";
	
	class Default implements FacilityPositionStatementChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityPositionStatement facilityPositionStatement) {
			ComparisonResult result = executeDataRule(facilityPositionStatement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityPositionStatement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityPositionStatement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FacilityPositionStatement facilityPositionStatement) {
			try {
				return choice(MapperS.of(facilityPositionStatement), Arrays.asList("facilityIdentifier", "facilitySummary"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FacilityPositionStatementChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityPositionStatement facilityPositionStatement) {
			return Collections.emptyList();
		}
	}
}
