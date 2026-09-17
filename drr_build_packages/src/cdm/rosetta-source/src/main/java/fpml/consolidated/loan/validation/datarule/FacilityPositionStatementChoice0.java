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
@RosettaDataRule("FacilityPositionStatementChoice0")
@ImplementedBy(FacilityPositionStatementChoice0.Default.class)
public interface FacilityPositionStatementChoice0 extends Validator<FacilityPositionStatement> {
	
	String NAME = "FacilityPositionStatementChoice0";
	String DEFINITION = "optional choice dealIdentifier, dealSummary";
	
	class Default implements FacilityPositionStatementChoice0 {
	
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
				return choice(MapperS.of(facilityPositionStatement), Arrays.asList("dealIdentifier", "dealSummary"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FacilityPositionStatementChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityPositionStatement facilityPositionStatement) {
			return Collections.emptyList();
		}
	}
}
