package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.DividendPayout;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class DividendPayoutTypeFormatValidator implements Validator<DividendPayout> {

	private List<ComparisonResult> getComparisonResults(DividendPayout o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("dividendPayoutConditions", o.getDividendPayoutConditions(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPayout o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPayout", ValidationResult.ValidationType.TYPE_FORMAT, "DividendPayout", path, "", res.getError());
				}
				return success("DividendPayout", ValidationResult.ValidationType.TYPE_FORMAT, "DividendPayout", path, "");
			})
			.collect(toList());
	}

}
