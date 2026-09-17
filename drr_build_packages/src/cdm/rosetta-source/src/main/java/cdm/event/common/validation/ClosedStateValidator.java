package cdm.event.common.validation;

import cdm.event.common.ClosedState;
import cdm.event.common.ClosedStateEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClosedStateValidator implements Validator<ClosedState> {

	private List<ComparisonResult> getComparisonResults(ClosedState o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("state", (ClosedStateEnum) o.getState() != null ? 1 : 0, 1, 1), 
				checkCardinality("activityDate", (Date) o.getActivityDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastPaymentDate", (Date) o.getLastPaymentDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClosedState o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClosedState", ValidationResult.ValidationType.CARDINALITY, "ClosedState", path, "", res.getError());
				}
				return success("ClosedState", ValidationResult.ValidationType.CARDINALITY, "ClosedState", path, "");
			})
			.collect(toList());
	}

}
