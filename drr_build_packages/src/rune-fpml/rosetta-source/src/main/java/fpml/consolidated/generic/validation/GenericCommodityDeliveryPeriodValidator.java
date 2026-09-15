package fpml.consolidated.generic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DayOfWeekExtEnum;
import fpml.consolidated.generic.GenericCommodityDeliveryPeriod;
import fpml.consolidated.shared.OffsetPrevailingTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GenericCommodityDeliveryPeriodValidator implements Validator<GenericCommodityDeliveryPeriod> {

	private List<ComparisonResult> getComparisonResults(GenericCommodityDeliveryPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicableDay", (List<DayOfWeekExtEnum>) o.getApplicableDay() == null ? 0 : o.getApplicableDay().size(), 1, 7), 
				checkCardinality("startTime", (OffsetPrevailingTime) o.getStartTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("endTime", (OffsetPrevailingTime) o.getEndTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericCommodityDeliveryPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericCommodityDeliveryPeriod", ValidationResult.ValidationType.CARDINALITY, "GenericCommodityDeliveryPeriod", path, "", res.getError());
				}
				return success("GenericCommodityDeliveryPeriod", ValidationResult.ValidationType.CARDINALITY, "GenericCommodityDeliveryPeriod", path, "");
			})
			.collect(toList());
	}

}
