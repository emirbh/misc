package cdm.product.common.schedule.validation;

import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.common.schedule.RateSchedule;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RateScheduleValidator implements Validator<RateSchedule> {

	private List<ComparisonResult> getComparisonResults(RateSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("price", (ReferenceWithMetaPriceSchedule) o.getPrice() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RateSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RateSchedule", ValidationResult.ValidationType.CARDINALITY, "RateSchedule", path, "", res.getError());
				}
				return success("RateSchedule", ValidationResult.ValidationType.CARDINALITY, "RateSchedule", path, "");
			})
			.collect(toList());
	}

}
