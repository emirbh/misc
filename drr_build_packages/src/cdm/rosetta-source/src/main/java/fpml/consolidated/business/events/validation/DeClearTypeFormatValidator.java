package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.DeClear;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DeClearTypeFormatValidator implements Validator<DeClear> {

	private List<ComparisonResult> getComparisonResults(DeClear o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeClear o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeClear", ValidationResult.ValidationType.TYPE_FORMAT, "DeClear", path, "", res.getError());
				}
				return success("DeClear", ValidationResult.ValidationType.TYPE_FORMAT, "DeClear", path, "");
			})
			.collect(toList());
	}

}
