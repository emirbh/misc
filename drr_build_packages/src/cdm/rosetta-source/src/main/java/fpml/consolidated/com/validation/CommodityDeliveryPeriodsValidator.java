package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityDeliveryPeriods;
import fpml.consolidated.shared.AdjustableDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityDeliveryPeriodsValidator implements Validator<CommodityDeliveryPeriods> {

	private List<ComparisonResult> getComparisonResults(CommodityDeliveryPeriods o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("periods", (AdjustableDates) o.getPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodsSchedule", (CommodityCalculationPeriodsSchedule) o.getPeriodsSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsReference", (CalculationPeriodsReference) o.getCalculationPeriodsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsScheduleReference", (CalculationPeriodsScheduleReference) o.getCalculationPeriodsScheduleReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsDatesReference", (CalculationPeriodsDatesReference) o.getCalculationPeriodsDatesReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDeliveryPeriods o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDeliveryPeriods", ValidationResult.ValidationType.CARDINALITY, "CommodityDeliveryPeriods", path, "", res.getError());
				}
				return success("CommodityDeliveryPeriods", ValidationResult.ValidationType.CARDINALITY, "CommodityDeliveryPeriods", path, "");
			})
			.collect(toList());
	}

}
