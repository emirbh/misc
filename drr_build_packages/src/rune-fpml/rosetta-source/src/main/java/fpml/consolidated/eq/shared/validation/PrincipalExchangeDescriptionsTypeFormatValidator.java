package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.PrincipalExchangeDescriptions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeDescriptionsTypeFormatValidator implements Validator<PrincipalExchangeDescriptions> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchangeDescriptions o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchangeDescriptions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchangeDescriptions", ValidationResult.ValidationType.TYPE_FORMAT, "PrincipalExchangeDescriptions", path, "", res.getError());
				}
				return success("PrincipalExchangeDescriptions", ValidationResult.ValidationType.TYPE_FORMAT, "PrincipalExchangeDescriptions", path, "");
			})
			.collect(toList());
	}

}
