package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.NonAccruingFeeTypeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NonAccruingFeeTypeIdValidator implements Validator<NonAccruingFeeTypeId> {

	private List<ComparisonResult> getComparisonResults(NonAccruingFeeTypeId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("nonAccruingFeeTypeIdScheme", (String) o.getNonAccruingFeeTypeIdScheme() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonAccruingFeeTypeId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonAccruingFeeTypeId", ValidationResult.ValidationType.CARDINALITY, "NonAccruingFeeTypeId", path, "", res.getError());
				}
				return success("NonAccruingFeeTypeId", ValidationResult.ValidationType.CARDINALITY, "NonAccruingFeeTypeId", path, "");
			})
			.collect(toList());
	}

}
