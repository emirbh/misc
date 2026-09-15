package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.EEPRiskPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EEPRiskPeriodTypeFormatValidator implements Validator<EEPRiskPeriod> {

	private List<ComparisonResult> getComparisonResults(EEPRiskPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EEPRiskPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EEPRiskPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "EEPRiskPeriod", path, "", res.getError());
				}
				return success("EEPRiskPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "EEPRiskPeriod", path, "");
			})
			.collect(toList());
	}

}
