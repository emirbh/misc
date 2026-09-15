package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.EquityPremium;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EquityPremiumTypeFormatValidator implements Validator<EquityPremium> {

	private List<ComparisonResult> getComparisonResults(EquityPremium o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityPremium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityPremium", ValidationResult.ValidationType.TYPE_FORMAT, "EquityPremium", path, "", res.getError());
				}
				return success("EquityPremium", ValidationResult.ValidationType.TYPE_FORMAT, "EquityPremium", path, "");
			})
			.collect(toList());
	}

}
