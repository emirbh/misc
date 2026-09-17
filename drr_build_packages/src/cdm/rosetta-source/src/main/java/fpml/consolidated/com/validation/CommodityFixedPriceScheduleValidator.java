package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityFixedPriceScheduleValidator implements Validator<CommodityFixedPriceSchedule> {

	private List<ComparisonResult> getComparisonResults(CommodityFixedPriceSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodsReference", (CalculationPeriodsReference) o.getCalculationPeriodsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsScheduleReference", (CalculationPeriodsScheduleReference) o.getCalculationPeriodsScheduleReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsDatesReference", (CalculationPeriodsDatesReference) o.getCalculationPeriodsDatesReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedPriceSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFixedPriceSchedule", ValidationResult.ValidationType.CARDINALITY, "CommodityFixedPriceSchedule", path, "", res.getError());
				}
				return success("CommodityFixedPriceSchedule", ValidationResult.ValidationType.CARDINALITY, "CommodityFixedPriceSchedule", path, "");
			})
			.collect(toList());
	}

}
