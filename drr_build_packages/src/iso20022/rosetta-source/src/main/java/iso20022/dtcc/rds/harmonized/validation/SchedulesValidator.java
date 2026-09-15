package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.Schedules;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SchedulesValidator implements Validator<Schedules> {

	private List<ComparisonResult> getComparisonResults(Schedules o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Schedules o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Schedules", ValidationResult.ValidationType.CARDINALITY, "Schedules", path, "", res.getError());
				}
				return success("Schedules", ValidationResult.ValidationType.CARDINALITY, "Schedules", path, "");
			})
			.collect(toList());
	}

}
