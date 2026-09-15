package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Beneficiary;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("BeneficiaryChoice")
@ImplementedBy(BeneficiaryChoice.Default.class)
public interface BeneficiaryChoice extends Validator<Beneficiary> {
	
	String NAME = "BeneficiaryChoice";
	String DEFINITION = "required choice routingIds, routingExplicitDetails, routingIdsAndExplicitDetails";
	
	class Default implements BeneficiaryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Beneficiary beneficiary) {
			ComparisonResult result = executeDataRule(beneficiary);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Beneficiary", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Beneficiary", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Beneficiary beneficiary) {
			try {
				return choice(MapperS.of(beneficiary), Arrays.asList("routingIds", "routingExplicitDetails", "routingIdsAndExplicitDetails"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BeneficiaryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Beneficiary beneficiary) {
			return Collections.emptyList();
		}
	}
}
