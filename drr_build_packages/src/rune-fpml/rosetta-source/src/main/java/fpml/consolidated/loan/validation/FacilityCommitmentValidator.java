package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityCommitment;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FacilityCommitmentValidator implements Validator<FacilityCommitment> {

	private List<ComparisonResult> getComparisonResults(FacilityCommitment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("totalCommitmentAmount", (MoneyWithParticipantShare) o.getTotalCommitmentAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("requiredFundedAmount", (MoneyWithParticipantShare) o.getRequiredFundedAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("unfundedAmount", (MoneyWithParticipantShare) o.getUnfundedAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("requiredUnfundedAmount", (MoneyWithParticipantShare) o.getRequiredUnfundedAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("fundedAmount", (MoneyWithParticipantShare) o.getFundedAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("unavailableToUtilizeAmount", (MoneyWithParticipantShare) o.getUnavailableToUtilizeAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityCommitment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityCommitment", ValidationResult.ValidationType.CARDINALITY, "FacilityCommitment", path, "", res.getError());
				}
				return success("FacilityCommitment", ValidationResult.ValidationType.CARDINALITY, "FacilityCommitment", path, "");
			})
			.collect(toList());
	}

}
