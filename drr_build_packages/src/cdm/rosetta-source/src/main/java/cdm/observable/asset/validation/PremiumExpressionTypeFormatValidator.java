package cdm.observable.asset.validation;

import cdm.observable.asset.PremiumExpression;
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

public class PremiumExpressionTypeFormatValidator implements Validator<PremiumExpression> {

	private List<ComparisonResult> getComparisonResults(PremiumExpression o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PremiumExpression o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PremiumExpression", ValidationResult.ValidationType.TYPE_FORMAT, "PremiumExpression", path, "", res.getError());
				}
				return success("PremiumExpression", ValidationResult.ValidationType.TYPE_FORMAT, "PremiumExpression", path, "");
			})
			.collect(toList());
	}

}
