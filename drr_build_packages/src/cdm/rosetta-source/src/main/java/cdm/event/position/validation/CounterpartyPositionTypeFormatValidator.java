package cdm.event.position.validation;

import cdm.event.position.CounterpartyPosition;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CounterpartyPositionTypeFormatValidator implements Validator<CounterpartyPosition> {

	private List<ComparisonResult> getComparisonResults(CounterpartyPosition o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CounterpartyPosition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CounterpartyPosition", ValidationResult.ValidationType.TYPE_FORMAT, "CounterpartyPosition", path, "", res.getError());
				}
				return success("CounterpartyPosition", ValidationResult.ValidationType.TYPE_FORMAT, "CounterpartyPosition", path, "");
			})
			.collect(toList());
	}

}
