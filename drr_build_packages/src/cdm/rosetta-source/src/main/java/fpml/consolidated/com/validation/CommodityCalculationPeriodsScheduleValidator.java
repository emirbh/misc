package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityCalculationPeriodsScheduleValidator implements Validator<CommodityCalculationPeriodsSchedule> {

	private List<ComparisonResult> getComparisonResults(CommodityCalculationPeriodsSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("period", (PeriodExtendedEnum) o.getPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("balanceOfFirstPeriod", (Boolean) o.getBalanceOfFirstPeriod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityCalculationPeriodsSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityCalculationPeriodsSchedule", ValidationResult.ValidationType.CARDINALITY, "CommodityCalculationPeriodsSchedule", path, "", res.getError());
				}
				return success("CommodityCalculationPeriodsSchedule", ValidationResult.ValidationType.CARDINALITY, "CommodityCalculationPeriodsSchedule", path, "");
			})
			.collect(toList());
	}

}
