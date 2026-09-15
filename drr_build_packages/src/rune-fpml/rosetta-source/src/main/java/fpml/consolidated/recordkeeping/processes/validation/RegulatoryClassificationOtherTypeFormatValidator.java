package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationOther;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationOtherTypeFormatValidator implements Validator<RegulatoryClassificationOther> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationOther o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationOther o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationOther", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassificationOther", path, "", res.getError());
				}
				return success("RegulatoryClassificationOther", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassificationOther", path, "");
			})
			.collect(toList());
	}

}
