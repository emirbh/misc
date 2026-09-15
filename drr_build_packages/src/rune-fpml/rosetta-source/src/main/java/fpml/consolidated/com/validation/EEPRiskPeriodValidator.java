package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.EEPRiskPeriod;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EEPRiskPeriodValidator implements Validator<EEPRiskPeriod> {

	private List<ComparisonResult> getComparisonResults(EEPRiskPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("startDate", (ZonedDateTime) o.getStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("endDate", (ZonedDateTime) o.getEndDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EEPRiskPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EEPRiskPeriod", ValidationResult.ValidationType.CARDINALITY, "EEPRiskPeriod", path, "", res.getError());
				}
				return success("EEPRiskPeriod", ValidationResult.ValidationType.CARDINALITY, "EEPRiskPeriod", path, "");
			})
			.collect(toList());
	}

}
