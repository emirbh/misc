package cdm.legaldocumentation.csa.validation.datarule;

import cdm.base.staticdata.party.PartyContactInformation;
import cdm.legaldocumentation.csa.ProcessAgentElection;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ProcessAgentElectionApplicable")
@ImplementedBy(ProcessAgentElectionApplicable.Default.class)
public interface ProcessAgentElectionApplicable extends Validator<ProcessAgentElection> {
	
	String NAME = "ProcessAgentElectionApplicable";
	String DEFINITION = "if isApplicable = True then processAgent exists";
	
	class Default implements ProcessAgentElectionApplicable {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProcessAgentElection processAgentElection) {
			ComparisonResult result = executeDataRule(processAgentElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ProcessAgentElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ProcessAgentElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ProcessAgentElection processAgentElection) {
			try {
				if (areEqual(MapperS.of(processAgentElection).<Boolean>map("getIsApplicable", _processAgentElection -> _processAgentElection.getIsApplicable()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(processAgentElection).<PartyContactInformation>map("getProcessAgent", _processAgentElection -> _processAgentElection.getProcessAgent()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ProcessAgentElectionApplicable {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProcessAgentElection processAgentElection) {
			return Collections.emptyList();
		}
	}
}
