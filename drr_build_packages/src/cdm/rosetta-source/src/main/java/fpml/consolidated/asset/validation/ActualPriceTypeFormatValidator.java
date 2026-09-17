package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ActualPrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ActualPriceTypeFormatValidator implements Validator<ActualPrice> {

	private List<ComparisonResult> getComparisonResults(ActualPrice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ActualPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ActualPrice", ValidationResult.ValidationType.TYPE_FORMAT, "ActualPrice", path, "", res.getError());
				}
				return success("ActualPrice", ValidationResult.ValidationType.TYPE_FORMAT, "ActualPrice", path, "");
			})
			.collect(toList());
	}

}
