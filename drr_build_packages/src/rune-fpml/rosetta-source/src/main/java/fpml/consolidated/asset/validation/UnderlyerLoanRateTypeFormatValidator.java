package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.UnderlyerLoanRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class UnderlyerLoanRateTypeFormatValidator implements Validator<UnderlyerLoanRate> {

	private List<ComparisonResult> getComparisonResults(UnderlyerLoanRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnderlyerLoanRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnderlyerLoanRate", ValidationResult.ValidationType.TYPE_FORMAT, "UnderlyerLoanRate", path, "", res.getError());
				}
				return success("UnderlyerLoanRate", ValidationResult.ValidationType.TYPE_FORMAT, "UnderlyerLoanRate", path, "");
			})
			.collect(toList());
	}

}
