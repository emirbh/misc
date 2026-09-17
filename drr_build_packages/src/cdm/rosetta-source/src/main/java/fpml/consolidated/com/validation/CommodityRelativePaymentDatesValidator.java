package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityPayRelativeToEvent;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.fpmlenum.CommodityPayRelativeToEnum;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityRelativePaymentDatesValidator implements Validator<CommodityRelativePaymentDates> {

	private List<ComparisonResult> getComparisonResults(CommodityRelativePaymentDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payRelativeTo", (CommodityPayRelativeToEnum) o.getPayRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("payRelativeToEvent", (CommodityPayRelativeToEvent) o.getPayRelativeToEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsReference", (CalculationPeriodsReference) o.getCalculationPeriodsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsScheduleReference", (CalculationPeriodsScheduleReference) o.getCalculationPeriodsScheduleReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsDatesReference", (CalculationPeriodsDatesReference) o.getCalculationPeriodsDatesReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDaysOffset", (DateOffset) o.getPaymentDaysOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCentersReference", (BusinessCentersReference) o.getBusinessCentersReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityRelativePaymentDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityRelativePaymentDates", ValidationResult.ValidationType.CARDINALITY, "CommodityRelativePaymentDates", path, "", res.getError());
				}
				return success("CommodityRelativePaymentDates", ValidationResult.ValidationType.CARDINALITY, "CommodityRelativePaymentDates", path, "");
			})
			.collect(toList());
	}

}
