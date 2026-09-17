package cdm.event.workflow.validation.datarule;

import cdm.event.workflow.PartyCustomisedWorkflow;
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
@RosettaDataRule("PartyCustomisedWorkflowPartyCustomisedWorkflowChoice")
@ImplementedBy(PartyCustomisedWorkflowPartyCustomisedWorkflowChoice.Default.class)
public interface PartyCustomisedWorkflowPartyCustomisedWorkflowChoice extends Validator<PartyCustomisedWorkflow> {
	
	String NAME = "PartyCustomisedWorkflowPartyCustomisedWorkflowChoice";
	String DEFINITION = "required choice partyName, partyReference";
	
	class Default implements PartyCustomisedWorkflowPartyCustomisedWorkflowChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyCustomisedWorkflow partyCustomisedWorkflow) {
			ComparisonResult result = executeDataRule(partyCustomisedWorkflow);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyCustomisedWorkflow", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyCustomisedWorkflow", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PartyCustomisedWorkflow partyCustomisedWorkflow) {
			try {
				return choice(MapperS.of(partyCustomisedWorkflow), Arrays.asList("partyName", "partyReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyCustomisedWorkflowPartyCustomisedWorkflowChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyCustomisedWorkflow partyCustomisedWorkflow) {
			return Collections.emptyList();
		}
	}
}
