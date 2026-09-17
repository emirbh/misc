package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxFallbackReferencePrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxFallbackReferencePriceTypeFormatValidator implements Validator<FxFallbackReferencePrice> {

	private List<ComparisonResult> getComparisonResults(FxFallbackReferencePrice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFallbackReferencePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFallbackReferencePrice", ValidationResult.ValidationType.TYPE_FORMAT, "FxFallbackReferencePrice", path, "", res.getError());
				}
				return success("FxFallbackReferencePrice", ValidationResult.ValidationType.TYPE_FORMAT, "FxFallbackReferencePrice", path, "");
			})
			.collect(toList());
	}

}
