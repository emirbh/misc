package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.Observation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObservationTypeFormatValidator implements Validator<Observation> {

	private List<ComparisonResult> getComparisonResults(Observation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Observation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Observation", ValidationResult.ValidationType.TYPE_FORMAT, "Observation", path, "", res.getError());
				}
				return success("Observation", ValidationResult.ValidationType.TYPE_FORMAT, "Observation", path, "");
			})
			.collect(toList());
	}

}
