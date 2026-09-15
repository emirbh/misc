package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApplicableCommunicationDetailsChoice;
import fpml.consolidated.shared.RelatedBusinessUnit;
import fpml.consolidated.shared.RelatedPerson;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApplicableCommunicationDetailsChoiceValidator implements Validator<ApplicableCommunicationDetailsChoice> {

	private List<ComparisonResult> getComparisonResults(ApplicableCommunicationDetailsChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("relatedPerson", (RelatedPerson) o.getRelatedPerson() != null ? 1 : 0, 0, 1), 
				checkCardinality("relatedBusinessUnit", (RelatedBusinessUnit) o.getRelatedBusinessUnit() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableCommunicationDetailsChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApplicableCommunicationDetailsChoice", ValidationResult.ValidationType.CARDINALITY, "ApplicableCommunicationDetailsChoice", path, "", res.getError());
				}
				return success("ApplicableCommunicationDetailsChoice", ValidationResult.ValidationType.CARDINALITY, "ApplicableCommunicationDetailsChoice", path, "");
			})
			.collect(toList());
	}

}
