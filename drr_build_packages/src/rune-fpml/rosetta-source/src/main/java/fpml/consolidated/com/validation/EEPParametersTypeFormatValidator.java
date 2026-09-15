package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.EEPParameters;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EEPParametersTypeFormatValidator implements Validator<EEPParameters> {

	private List<ComparisonResult> getComparisonResults(EEPParameters o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EEPParameters o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EEPParameters", ValidationResult.ValidationType.TYPE_FORMAT, "EEPParameters", path, "", res.getError());
				}
				return success("EEPParameters", ValidationResult.ValidationType.TYPE_FORMAT, "EEPParameters", path, "");
			})
			.collect(toList());
	}

}
