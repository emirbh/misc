package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.FixedPriceLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FixedPriceLegTypeFormatValidator implements Validator<FixedPriceLeg> {

	private List<ComparisonResult> getComparisonResults(FixedPriceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPriceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedPriceLeg", ValidationResult.ValidationType.TYPE_FORMAT, "FixedPriceLeg", path, "", res.getError());
				}
				return success("FixedPriceLeg", ValidationResult.ValidationType.TYPE_FORMAT, "FixedPriceLeg", path, "");
			})
			.collect(toList());
	}

}
