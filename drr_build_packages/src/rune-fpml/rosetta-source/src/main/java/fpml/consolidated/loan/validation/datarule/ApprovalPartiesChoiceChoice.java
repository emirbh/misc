package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApprovalPartiesChoice;
import fpml.consolidated.loan.IneligiblePartyReasonType;
import fpml.consolidated.shared.PartyReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ApprovalPartiesChoiceChoice")
@ImplementedBy(ApprovalPartiesChoiceChoice.Default.class)
public interface ApprovalPartiesChoiceChoice extends Validator<ApprovalPartiesChoice> {
	
	String NAME = "ApprovalPartiesChoiceChoice";
	String DEFINITION = "if eligibleParty exists then ineligibleParty is absent and ineligibleReason is absent else if ineligibleParty exists then eligibleParty is absent else False";
	
	class Default implements ApprovalPartiesChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApprovalPartiesChoice approvalPartiesChoice) {
			ComparisonResult result = executeDataRule(approvalPartiesChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ApprovalPartiesChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ApprovalPartiesChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ApprovalPartiesChoice approvalPartiesChoice) {
			try {
				if (exists(MapperS.of(approvalPartiesChoice).<PartyReference>map("getEligibleParty", _approvalPartiesChoice -> _approvalPartiesChoice.getEligibleParty())).getOrDefault(false)) {
					return notExists(MapperS.of(approvalPartiesChoice).<PartyReference>map("getIneligibleParty", _approvalPartiesChoice -> _approvalPartiesChoice.getIneligibleParty())).andNullSafe(notExists(MapperS.of(approvalPartiesChoice).<IneligiblePartyReasonType>map("getIneligibleReason", _approvalPartiesChoice -> _approvalPartiesChoice.getIneligibleReason())));
				}
				if (exists(MapperS.of(approvalPartiesChoice).<PartyReference>map("getIneligibleParty", _approvalPartiesChoice -> _approvalPartiesChoice.getIneligibleParty())).getOrDefault(false)) {
					return notExists(MapperS.of(approvalPartiesChoice).<PartyReference>map("getEligibleParty", _approvalPartiesChoice -> _approvalPartiesChoice.getEligibleParty()));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ApprovalPartiesChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApprovalPartiesChoice approvalPartiesChoice) {
			return Collections.emptyList();
		}
	}
}
