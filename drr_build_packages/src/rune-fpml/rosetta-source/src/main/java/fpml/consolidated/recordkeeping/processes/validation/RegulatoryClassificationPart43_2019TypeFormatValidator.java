package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart43_2019;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationPart43_2019TypeFormatValidator implements Validator<RegulatoryClassificationPart43_2019> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationPart43_2019 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationPart43_2019 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationPart43_2019", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassificationPart43_2019", path, "", res.getError());
				}
				return success("RegulatoryClassificationPart43_2019", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassificationPart43_2019", path, "");
			})
			.collect(toList());
	}

}
