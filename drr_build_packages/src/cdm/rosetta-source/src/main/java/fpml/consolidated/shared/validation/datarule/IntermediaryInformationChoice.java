package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.IntermediaryInformation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("IntermediaryInformationChoice")
@ImplementedBy(IntermediaryInformationChoice.Default.class)
public interface IntermediaryInformationChoice extends Validator<IntermediaryInformation> {
	
	String NAME = "IntermediaryInformationChoice";
	String DEFINITION = "required choice routingIds, routingExplicitDetails, routingIdsAndExplicitDetails";
	
	class Default implements IntermediaryInformationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, IntermediaryInformation intermediaryInformation) {
			ComparisonResult result = executeDataRule(intermediaryInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "IntermediaryInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "IntermediaryInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(IntermediaryInformation intermediaryInformation) {
			try {
				return choice(MapperS.of(intermediaryInformation), Arrays.asList("routingIds", "routingExplicitDetails", "routingIdsAndExplicitDetails"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements IntermediaryInformationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, IntermediaryInformation intermediaryInformation) {
			return Collections.emptyList();
		}
	}
}
