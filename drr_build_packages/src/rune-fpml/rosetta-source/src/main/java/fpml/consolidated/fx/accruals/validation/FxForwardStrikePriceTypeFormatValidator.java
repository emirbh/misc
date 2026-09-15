package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxForwardStrikePrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxForwardStrikePriceTypeFormatValidator implements Validator<FxForwardStrikePrice> {

	private List<ComparisonResult> getComparisonResults(FxForwardStrikePrice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxForwardStrikePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxForwardStrikePrice", ValidationResult.ValidationType.TYPE_FORMAT, "FxForwardStrikePrice", path, "", res.getError());
				}
				return success("FxForwardStrikePrice", ValidationResult.ValidationType.TYPE_FORMAT, "FxForwardStrikePrice", path, "");
			})
			.collect(toList());
	}

}
