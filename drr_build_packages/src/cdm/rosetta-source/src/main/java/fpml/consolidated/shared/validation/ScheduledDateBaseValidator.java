package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ScheduledDateBase;
import fpml.consolidated.shared.ScheduledDateType;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ScheduledDateBaseValidator implements Validator<ScheduledDateBase> {

	private List<ComparisonResult> getComparisonResults(ScheduledDateBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("unadjustedDate", (ZonedDateTime) o.getUnadjustedDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedDate", (ZonedDateTime) o.getAdjustedDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("type", (ScheduledDateType) o._getType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ScheduledDateBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ScheduledDateBase", ValidationResult.ValidationType.CARDINALITY, "ScheduledDateBase", path, "", res.getError());
				}
				return success("ScheduledDateBase", ValidationResult.ValidationType.CARDINALITY, "ScheduledDateBase", path, "");
			})
			.collect(toList());
	}

}
