package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FacilityStatementChoice")
@ImplementedBy(FacilityStatementChoice.Default.class)
public interface FacilityStatementChoice extends Validator<FacilityStatement> {
	
	String NAME = "FacilityStatementChoice";
	String DEFINITION = "optional choice dealIdentifier, dealSummary";
	
	class Default implements FacilityStatementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityStatement facilityStatement) {
			ComparisonResult result = executeDataRule(facilityStatement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityStatement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityStatement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FacilityStatement facilityStatement) {
			try {
				return choice(MapperS.of(facilityStatement), Arrays.asList("dealIdentifier", "dealSummary"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FacilityStatementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityStatement facilityStatement) {
			return Collections.emptyList();
		}
	}
}
