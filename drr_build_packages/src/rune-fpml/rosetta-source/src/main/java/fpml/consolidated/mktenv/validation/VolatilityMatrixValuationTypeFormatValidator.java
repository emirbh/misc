package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.VolatilityMatrixValuation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VolatilityMatrixValuationTypeFormatValidator implements Validator<VolatilityMatrixValuation> {

	private List<ComparisonResult> getComparisonResults(VolatilityMatrixValuation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityMatrixValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityMatrixValuation", ValidationResult.ValidationType.TYPE_FORMAT, "VolatilityMatrixValuation", path, "", res.getError());
				}
				return success("VolatilityMatrixValuation", ValidationResult.ValidationType.TYPE_FORMAT, "VolatilityMatrixValuation", path, "");
			})
			.collect(toList());
	}

}
