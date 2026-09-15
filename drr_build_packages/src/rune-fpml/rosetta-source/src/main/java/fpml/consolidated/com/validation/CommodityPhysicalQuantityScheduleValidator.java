package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalQuantityScheduleValidator implements Validator<CommodityPhysicalQuantitySchedule> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalQuantitySchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryPeriodsReference", (CalculationPeriodsReference) o.getDeliveryPeriodsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryPeriodsScheduleReference", (CalculationPeriodsScheduleReference) o.getDeliveryPeriodsScheduleReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalQuantitySchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalQuantitySchedule", ValidationResult.ValidationType.CARDINALITY, "CommodityPhysicalQuantitySchedule", path, "", res.getError());
				}
				return success("CommodityPhysicalQuantitySchedule", ValidationResult.ValidationType.CARDINALITY, "CommodityPhysicalQuantitySchedule", path, "");
			})
			.collect(toList());
	}

}
