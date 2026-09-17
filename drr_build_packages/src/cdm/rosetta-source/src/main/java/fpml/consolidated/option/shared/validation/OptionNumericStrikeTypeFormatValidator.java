package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.OptionNumericStrike;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionNumericStrikeTypeFormatValidator implements Validator<OptionNumericStrike> {

	private List<ComparisonResult> getComparisonResults(OptionNumericStrike o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionNumericStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionNumericStrike", ValidationResult.ValidationType.TYPE_FORMAT, "OptionNumericStrike", path, "", res.getError());
				}
				return success("OptionNumericStrike", ValidationResult.ValidationType.TYPE_FORMAT, "OptionNumericStrike", path, "");
			})
			.collect(toList());
	}

}
