package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.SettlementPeriodFixingDates;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodFixingDatesValidator implements Validator<SettlementPeriodFixingDates> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriodFixingDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("startDate", (ZonedDateTime) o.getStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("endDate", (ZonedDateTime) o.getEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfFixings", (Integer) o.getNumberOfFixings() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodFixingDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriodFixingDates", ValidationResult.ValidationType.CARDINALITY, "SettlementPeriodFixingDates", path, "", res.getError());
				}
				return success("SettlementPeriodFixingDates", ValidationResult.ValidationType.CARDINALITY, "SettlementPeriodFixingDates", path, "");
			})
			.collect(toList());
	}

}
