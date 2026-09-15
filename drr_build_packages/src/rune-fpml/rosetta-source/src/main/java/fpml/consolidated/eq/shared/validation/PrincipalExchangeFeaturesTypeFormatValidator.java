package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.PrincipalExchangeFeatures;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeFeaturesTypeFormatValidator implements Validator<PrincipalExchangeFeatures> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchangeFeatures o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchangeFeatures o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchangeFeatures", ValidationResult.ValidationType.TYPE_FORMAT, "PrincipalExchangeFeatures", path, "", res.getError());
				}
				return success("PrincipalExchangeFeatures", ValidationResult.ValidationType.TYPE_FORMAT, "PrincipalExchangeFeatures", path, "");
			})
			.collect(toList());
	}

}
