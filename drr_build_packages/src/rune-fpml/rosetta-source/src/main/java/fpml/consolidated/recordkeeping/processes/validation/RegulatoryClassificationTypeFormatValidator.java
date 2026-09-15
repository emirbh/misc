package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationTypeFormatValidator implements Validator<RegulatoryClassification> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassification o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassification", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassification", path, "", res.getError());
				}
				return success("RegulatoryClassification", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassification", path, "");
			})
			.collect(toList());
	}

}
