package fpml.consolidated.doc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ContractIdentifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ContractIdentifierChoice")
@ImplementedBy(ContractIdentifierChoice.Default.class)
public interface ContractIdentifierChoice extends Validator<ContractIdentifier> {
	
	String NAME = "ContractIdentifierChoice";
	String DEFINITION = "required choice contractId, versionedContractId";
	
	class Default implements ContractIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractIdentifier contractIdentifier) {
			ComparisonResult result = executeDataRule(contractIdentifier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ContractIdentifier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ContractIdentifier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ContractIdentifier contractIdentifier) {
			try {
				return choice(MapperS.of(contractIdentifier), Arrays.asList("contractId", "versionedContractId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ContractIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractIdentifier contractIdentifier) {
			return Collections.emptyList();
		}
	}
}
