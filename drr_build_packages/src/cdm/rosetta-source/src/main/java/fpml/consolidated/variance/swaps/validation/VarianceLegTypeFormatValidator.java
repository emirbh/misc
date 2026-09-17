package fpml.consolidated.variance.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.variance.swaps.VarianceLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VarianceLegTypeFormatValidator implements Validator<VarianceLeg> {

	private List<ComparisonResult> getComparisonResults(VarianceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceLeg", ValidationResult.ValidationType.TYPE_FORMAT, "VarianceLeg", path, "", res.getError());
				}
				return success("VarianceLeg", ValidationResult.ValidationType.TYPE_FORMAT, "VarianceLeg", path, "");
			})
			.collect(toList());
	}

}
