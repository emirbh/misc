package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationMifirRTS22_2015;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationMifirRTS22_2015TypeFormatValidator implements Validator<RegulatoryClassificationMifirRTS22_2015> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationMifirRTS22_2015 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationMifirRTS22_2015 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationMifirRTS22_2015", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassificationMifirRTS22_2015", path, "", res.getError());
				}
				return success("RegulatoryClassificationMifirRTS22_2015", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassificationMifirRTS22_2015", path, "");
			})
			.collect(toList());
	}

}
