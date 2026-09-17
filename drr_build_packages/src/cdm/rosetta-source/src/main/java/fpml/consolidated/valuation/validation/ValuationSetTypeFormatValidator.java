package fpml.consolidated.valuation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.valuation.ValuationSet;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class ValuationSetTypeFormatValidator implements Validator<ValuationSet> {

	private List<ComparisonResult> getComparisonResults(ValuationSet o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("name", o.getName(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationSet o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationSet", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationSet", path, "", res.getError());
				}
				return success("ValuationSet", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationSet", path, "");
			})
			.collect(toList());
	}

}
