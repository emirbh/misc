package cdm.observable.asset.fro.validation.datarule;

import cdm.observable.asset.fro.ContractualDefinition;
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
@RosettaDataRule("ContractualDefinitionChoice")
@ImplementedBy(ContractualDefinitionChoice.Default.class)
public interface ContractualDefinitionChoice extends Validator<ContractualDefinition> {
	
	String NAME = "ContractualDefinitionChoice";
	String DEFINITION = "optional choice identifier, contractualDefinitionIdentifier";
	
	class Default implements ContractualDefinitionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractualDefinition contractualDefinition) {
			ComparisonResult result = executeDataRule(contractualDefinition);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ContractualDefinition", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ContractualDefinition", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ContractualDefinition contractualDefinition) {
			try {
				return choice(MapperS.of(contractualDefinition), Arrays.asList("identifier", "contractualDefinitionIdentifier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ContractualDefinitionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractualDefinition contractualDefinition) {
			return Collections.emptyList();
		}
	}
}
