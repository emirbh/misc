package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.SPKIData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SPKIDataTypeFormatValidator implements Validator<SPKIData> {

	private List<ComparisonResult> getComparisonResults(SPKIData o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SPKIData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SPKIData", ValidationResult.ValidationType.TYPE_FORMAT, "SPKIData", path, "", res.getError());
				}
				return success("SPKIData", ValidationResult.ValidationType.TYPE_FORMAT, "SPKIData", path, "");
			})
			.collect(toList());
	}

}
