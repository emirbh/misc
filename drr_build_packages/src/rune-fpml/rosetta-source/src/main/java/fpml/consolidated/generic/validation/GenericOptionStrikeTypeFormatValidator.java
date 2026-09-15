package fpml.consolidated.generic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.generic.GenericOptionStrike;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GenericOptionStrikeTypeFormatValidator implements Validator<GenericOptionStrike> {

	private List<ComparisonResult> getComparisonResults(GenericOptionStrike o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericOptionStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericOptionStrike", ValidationResult.ValidationType.TYPE_FORMAT, "GenericOptionStrike", path, "", res.getError());
				}
				return success("GenericOptionStrike", ValidationResult.ValidationType.TYPE_FORMAT, "GenericOptionStrike", path, "");
			})
			.collect(toList());
	}

}
