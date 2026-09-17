package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.ExchangeRestrictions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExchangeRestrictionsValidator implements Validator<ExchangeRestrictions> {

	private List<ComparisonResult> getComparisonResults(ExchangeRestrictions o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeRestrictions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeRestrictions", ValidationResult.ValidationType.CARDINALITY, "ExchangeRestrictions", path, "", res.getError());
				}
				return success("ExchangeRestrictions", ValidationResult.ValidationType.CARDINALITY, "ExchangeRestrictions", path, "");
			})
			.collect(toList());
	}

}
