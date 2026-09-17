package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Cash;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class CashTypeFormatValidator implements Validator<Cash> {

	private List<ComparisonResult> getComparisonResults(Cash o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Cash o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Cash", ValidationResult.ValidationType.TYPE_FORMAT, "Cash", path, "", res.getError());
				}
				return success("Cash", ValidationResult.ValidationType.TYPE_FORMAT, "Cash", path, "");
			})
			.collect(toList());
	}

}
