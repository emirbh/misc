package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.TimePeriodDetails1;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TimePeriodDetails1Validator implements Validator<TimePeriodDetails1> {

	private List<ComparisonResult> getComparisonResults(TimePeriodDetails1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("frTm", (LocalTime) o.getFrTm() != null ? 1 : 0, 1, 1), 
				checkCardinality("toTm", (LocalTime) o.getToTm() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TimePeriodDetails1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TimePeriodDetails1", ValidationResult.ValidationType.CARDINALITY, "TimePeriodDetails1", path, "", res.getError());
				}
				return success("TimePeriodDetails1", ValidationResult.ValidationType.CARDINALITY, "TimePeriodDetails1", path, "");
			})
			.collect(toList());
	}

}
