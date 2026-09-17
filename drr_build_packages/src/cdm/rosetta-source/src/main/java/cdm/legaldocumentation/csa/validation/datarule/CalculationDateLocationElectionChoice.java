package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.CalculationDateLocationElection;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CalculationDateLocationElectionChoice")
@ImplementedBy(CalculationDateLocationElectionChoice.Default.class)
public interface CalculationDateLocationElectionChoice extends Validator<CalculationDateLocationElection> {
	
	String NAME = "CalculationDateLocationElectionChoice";
	String DEFINITION = "required choice businessCenter, customLocation";
	
	class Default implements CalculationDateLocationElectionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationDateLocationElection calculationDateLocationElection) {
			ComparisonResult result = executeDataRule(calculationDateLocationElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationDateLocationElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationDateLocationElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CalculationDateLocationElection calculationDateLocationElection) {
			try {
				return choice(MapperS.of(calculationDateLocationElection), Arrays.asList("businessCenter", "customLocation"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationDateLocationElectionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationDateLocationElection calculationDateLocationElection) {
			return Collections.emptyList();
		}
	}
}
