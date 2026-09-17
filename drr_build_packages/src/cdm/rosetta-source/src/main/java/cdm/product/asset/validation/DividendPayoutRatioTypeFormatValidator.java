package cdm.product.asset.validation;

import cdm.product.asset.DividendPayoutRatio;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DividendPayoutRatioTypeFormatValidator implements Validator<DividendPayoutRatio> {

	private List<ComparisonResult> getComparisonResults(DividendPayoutRatio o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPayoutRatio o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPayoutRatio", ValidationResult.ValidationType.TYPE_FORMAT, "DividendPayoutRatio", path, "", res.getError());
				}
				return success("DividendPayoutRatio", ValidationResult.ValidationType.TYPE_FORMAT, "DividendPayoutRatio", path, "");
			})
			.collect(toList());
	}

}
