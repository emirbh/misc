package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.IneligiblePartyReasonType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IneligiblePartyReasonTypeValidator implements Validator<IneligiblePartyReasonType> {

	private List<ComparisonResult> getComparisonResults(IneligiblePartyReasonType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("ineligiblePartyReasonTypeScheme", (String) o.getIneligiblePartyReasonTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IneligiblePartyReasonType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IneligiblePartyReasonType", ValidationResult.ValidationType.CARDINALITY, "IneligiblePartyReasonType", path, "", res.getError());
				}
				return success("IneligiblePartyReasonType", ValidationResult.ValidationType.CARDINALITY, "IneligiblePartyReasonType", path, "");
			})
			.collect(toList());
	}

}
