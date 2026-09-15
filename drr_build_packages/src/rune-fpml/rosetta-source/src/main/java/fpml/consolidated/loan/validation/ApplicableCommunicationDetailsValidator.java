package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApplicableAssets;
import fpml.consolidated.loan.ApplicableCommunicationDetails;
import fpml.consolidated.loan.ApplicableCommunicationDetailsChoice;
import fpml.consolidated.loan.ApplicableTransactions;
import fpml.consolidated.loan.AssociationToAssetIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApplicableCommunicationDetailsValidator implements Validator<ApplicableCommunicationDetails> {

	private List<ComparisonResult> getComparisonResults(ApplicableCommunicationDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (AssociationToAssetIdentifier) o.getIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("applicableAssets", (ApplicableAssets) o.getApplicableAssets() != null ? 1 : 0, 1, 1), 
				checkCardinality("applicableTransactions", (ApplicableTransactions) o.getApplicableTransactions() != null ? 1 : 0, 1, 1), 
				checkCardinality("applicableCommunicationDetailsChoice", (List<? extends ApplicableCommunicationDetailsChoice>) o.getApplicableCommunicationDetailsChoice() == null ? 0 : o.getApplicableCommunicationDetailsChoice().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableCommunicationDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApplicableCommunicationDetails", ValidationResult.ValidationType.CARDINALITY, "ApplicableCommunicationDetails", path, "", res.getError());
				}
				return success("ApplicableCommunicationDetails", ValidationResult.ValidationType.CARDINALITY, "ApplicableCommunicationDetails", path, "");
			})
			.collect(toList());
	}

}
