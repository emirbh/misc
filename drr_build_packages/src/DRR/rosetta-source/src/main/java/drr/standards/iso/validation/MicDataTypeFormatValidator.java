package drr.standards.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iso.MicData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MicDataTypeFormatValidator implements Validator<MicData> {

	private List<ComparisonResult> getComparisonResults(MicData o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MicData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MicData", ValidationResult.ValidationType.TYPE_FORMAT, "MicData", path, "", res.getError());
				}
				return success("MicData", ValidationResult.ValidationType.TYPE_FORMAT, "MicData", path, "");
			})
			.collect(toList());
	}

}
