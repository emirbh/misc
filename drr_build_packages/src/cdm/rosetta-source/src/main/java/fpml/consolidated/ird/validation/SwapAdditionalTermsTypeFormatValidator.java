package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.SwapAdditionalTerms;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SwapAdditionalTermsTypeFormatValidator implements Validator<SwapAdditionalTerms> {

	private List<ComparisonResult> getComparisonResults(SwapAdditionalTerms o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SwapAdditionalTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SwapAdditionalTerms", ValidationResult.ValidationType.TYPE_FORMAT, "SwapAdditionalTerms", path, "", res.getError());
				}
				return success("SwapAdditionalTerms", ValidationResult.ValidationType.TYPE_FORMAT, "SwapAdditionalTerms", path, "");
			})
			.collect(toList());
	}

}
