package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.CancelableProvision;
import fpml.consolidated.ird.CancelableProvisionAdjustedDates;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SimplePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CancelableProvisionValidator implements Validator<CancelableProvision> {

	private List<ComparisonResult> getComparisonResults(CancelableProvision o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("exercise", (Exercise) o.getExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseNotice", (ExerciseNotice) o.getExerciseNotice() != null ? 1 : 0, 0, 1), 
				checkCardinality("followUpConfirmation", (Boolean) o.getFollowUpConfirmation() != null ? 1 : 0, 0, 1), 
				checkCardinality("cancelableProvisionAdjustedDates", (CancelableProvisionAdjustedDates) o.getCancelableProvisionAdjustedDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialFee", (SimplePayment) o.getInitialFee() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CancelableProvision o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CancelableProvision", ValidationResult.ValidationType.CARDINALITY, "CancelableProvision", path, "", res.getError());
				}
				return success("CancelableProvision", ValidationResult.ValidationType.CARDINALITY, "CancelableProvision", path, "");
			})
			.collect(toList());
	}

}
