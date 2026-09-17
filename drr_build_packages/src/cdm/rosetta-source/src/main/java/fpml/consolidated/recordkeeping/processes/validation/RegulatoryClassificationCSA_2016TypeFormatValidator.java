package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationCSA_2016;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationCSA_2016TypeFormatValidator implements Validator<RegulatoryClassificationCSA_2016> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationCSA_2016 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationCSA_2016 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationCSA_2016", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassificationCSA_2016", path, "", res.getError());
				}
				return success("RegulatoryClassificationCSA_2016", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassificationCSA_2016", path, "");
			})
			.collect(toList());
	}

}
