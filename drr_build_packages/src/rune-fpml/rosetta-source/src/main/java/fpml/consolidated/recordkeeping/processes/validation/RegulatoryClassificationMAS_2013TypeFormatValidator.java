package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationMAS_2013;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryClassificationMAS_2013TypeFormatValidator implements Validator<RegulatoryClassificationMAS_2013> {

	private List<ComparisonResult> getComparisonResults(RegulatoryClassificationMAS_2013 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationMAS_2013 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryClassificationMAS_2013", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassificationMAS_2013", path, "", res.getError());
				}
				return success("RegulatoryClassificationMAS_2013", ValidationResult.ValidationType.TYPE_FORMAT, "RegulatoryClassificationMAS_2013", path, "");
			})
			.collect(toList());
	}

}
