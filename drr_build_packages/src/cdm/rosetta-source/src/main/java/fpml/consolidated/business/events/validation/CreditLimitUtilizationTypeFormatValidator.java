package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CreditLimitUtilization;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditLimitUtilizationTypeFormatValidator implements Validator<CreditLimitUtilization> {

	private List<ComparisonResult> getComparisonResults(CreditLimitUtilization o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimitUtilization o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditLimitUtilization", ValidationResult.ValidationType.TYPE_FORMAT, "CreditLimitUtilization", path, "", res.getError());
				}
				return success("CreditLimitUtilization", ValidationResult.ValidationType.TYPE_FORMAT, "CreditLimitUtilization", path, "");
			})
			.collect(toList());
	}

}
