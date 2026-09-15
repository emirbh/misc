package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ObservationOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObservationOffsetValidator implements Validator<ObservationOffset> {

	private List<ComparisonResult> getComparisonResults(ObservationOffset o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("offsetDays", (Integer) o.getOffsetDays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationOffset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservationOffset", ValidationResult.ValidationType.CARDINALITY, "ObservationOffset", path, "", res.getError());
				}
				return success("ObservationOffset", ValidationResult.ValidationType.CARDINALITY, "ObservationOffset", path, "");
			})
			.collect(toList());
	}

}
