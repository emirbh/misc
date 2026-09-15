package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.PrincipalExchange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeTypeFormatValidator implements Validator<PrincipalExchange> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchange o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchange", ValidationResult.ValidationType.TYPE_FORMAT, "PrincipalExchange", path, "", res.getError());
				}
				return success("PrincipalExchange", ValidationResult.ValidationType.TYPE_FORMAT, "PrincipalExchange", path, "");
			})
			.collect(toList());
	}

}
