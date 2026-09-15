package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdjustableOrRelativeDateValidator implements Validator<AdjustableOrRelativeDate> {

	private List<ComparisonResult> getComparisonResults(AdjustableOrRelativeDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustableDate", (AdjustableDate) o.getAdjustableDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeDate", (RelativeDateOffset) o.getRelativeDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOrRelativeDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableOrRelativeDate", ValidationResult.ValidationType.CARDINALITY, "AdjustableOrRelativeDate", path, "", res.getError());
				}
				return success("AdjustableOrRelativeDate", ValidationResult.ValidationType.CARDINALITY, "AdjustableOrRelativeDate", path, "");
			})
			.collect(toList());
	}

}
