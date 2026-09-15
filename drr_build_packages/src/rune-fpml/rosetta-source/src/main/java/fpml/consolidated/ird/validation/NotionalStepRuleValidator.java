package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.StepRelativeToEnum;
import fpml.consolidated.ird.CalculationPeriodDatesReference;
import fpml.consolidated.ird.NotionalStepRule;
import fpml.consolidated.shared.Frequency;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NotionalStepRuleValidator implements Validator<NotionalStepRule> {

	private List<ComparisonResult> getComparisonResults(NotionalStepRule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodDatesReference", (CalculationPeriodDatesReference) o.getCalculationPeriodDatesReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("stepFrequency", (Frequency) o.getStepFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstNotionalStepDate", (ZonedDateTime) o.getFirstNotionalStepDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastNotionalStepDate", (ZonedDateTime) o.getLastNotionalStepDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalStepAmount", (BigDecimal) o.getNotionalStepAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalStepRate", (BigDecimal) o.getNotionalStepRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("stepRelativeTo", (StepRelativeToEnum) o.getStepRelativeTo() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalStepRule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalStepRule", ValidationResult.ValidationType.CARDINALITY, "NotionalStepRule", path, "", res.getError());
				}
				return success("NotionalStepRule", ValidationResult.ValidationType.CARDINALITY, "NotionalStepRule", path, "");
			})
			.collect(toList());
	}

}
