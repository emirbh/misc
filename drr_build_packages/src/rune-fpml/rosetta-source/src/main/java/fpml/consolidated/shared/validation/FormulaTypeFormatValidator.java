package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Formula;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class FormulaTypeFormatValidator implements Validator<Formula> {

	private List<ComparisonResult> getComparisonResults(Formula o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("formulaDescription", o.getFormulaDescription(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Formula o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Formula", ValidationResult.ValidationType.TYPE_FORMAT, "Formula", path, "", res.getError());
				}
				return success("Formula", ValidationResult.ValidationType.TYPE_FORMAT, "Formula", path, "");
			})
			.collect(toList());
	}

}
