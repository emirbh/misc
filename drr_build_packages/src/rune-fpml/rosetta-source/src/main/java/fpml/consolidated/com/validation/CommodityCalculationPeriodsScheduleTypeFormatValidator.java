package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CommodityCalculationPeriodsScheduleTypeFormatValidator implements Validator<CommodityCalculationPeriodsSchedule> {

	private List<ComparisonResult> getComparisonResults(CommodityCalculationPeriodsSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("periodMultiplier", o.getPeriodMultiplier(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityCalculationPeriodsSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityCalculationPeriodsSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityCalculationPeriodsSchedule", path, "", res.getError());
				}
				return success("CommodityCalculationPeriodsSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "CommodityCalculationPeriodsSchedule", path, "");
			})
			.collect(toList());
	}

}
