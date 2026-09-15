package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApprovalPartiesChoice;
import fpml.consolidated.loan.IneligiblePartyReasonType;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApprovalPartiesChoiceValidator implements Validator<ApprovalPartiesChoice> {

	private List<ComparisonResult> getComparisonResults(ApprovalPartiesChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eligibleParty", (PartyReference) o.getEligibleParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("ineligibleParty", (PartyReference) o.getIneligibleParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("ineligibleReason", (IneligiblePartyReasonType) o.getIneligibleReason() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApprovalPartiesChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApprovalPartiesChoice", ValidationResult.ValidationType.CARDINALITY, "ApprovalPartiesChoice", path, "", res.getError());
				}
				return success("ApprovalPartiesChoice", ValidationResult.ValidationType.CARDINALITY, "ApprovalPartiesChoice", path, "");
			})
			.collect(toList());
	}

}
