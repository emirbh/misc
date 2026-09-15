package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.PrevailingTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PrevailingTimeTypeFormatValidator implements Validator<PrevailingTime> {

	private List<ComparisonResult> getComparisonResults(PrevailingTime o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrevailingTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrevailingTime", ValidationResult.ValidationType.TYPE_FORMAT, "PrevailingTime", path, "", res.getError());
				}
				return success("PrevailingTime", ValidationResult.ValidationType.TYPE_FORMAT, "PrevailingTime", path, "");
			})
			.collect(toList());
	}

}
