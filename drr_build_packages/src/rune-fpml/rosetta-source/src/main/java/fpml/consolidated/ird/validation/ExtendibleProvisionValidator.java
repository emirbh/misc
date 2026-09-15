package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.ExtendibleProvision;
import fpml.consolidated.ird.ExtendibleProvisionAdjustedDates;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExtendibleProvisionValidator implements Validator<ExtendibleProvision> {

	private List<ComparisonResult> getComparisonResults(ExtendibleProvision o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("exercise", (Exercise) o.getExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseNotice", (ExerciseNotice) o.getExerciseNotice() != null ? 1 : 0, 0, 1), 
				checkCardinality("followUpConfirmation", (Boolean) o.getFollowUpConfirmation() != null ? 1 : 0, 0, 1), 
				checkCardinality("extendibleProvisionAdjustedDates", (ExtendibleProvisionAdjustedDates) o.getExtendibleProvisionAdjustedDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExtendibleProvision o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExtendibleProvision", ValidationResult.ValidationType.CARDINALITY, "ExtendibleProvision", path, "", res.getError());
				}
				return success("ExtendibleProvision", ValidationResult.ValidationType.CARDINALITY, "ExtendibleProvision", path, "");
			})
			.collect(toList());
	}

}
