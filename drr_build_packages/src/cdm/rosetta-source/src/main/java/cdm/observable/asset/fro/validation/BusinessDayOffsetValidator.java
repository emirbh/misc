package cdm.observable.asset.fro.validation;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.PeriodEnum;
import cdm.observable.asset.fro.BusinessDayOffset;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BusinessDayOffsetValidator implements Validator<BusinessDayOffset> {

	private List<ComparisonResult> getComparisonResults(BusinessDayOffset o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 1, 1), 
				checkCardinality("period", (PeriodEnum) o.getPeriod() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingOffsetDefinition", (String) o.getFixingOffsetDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingOffsetReason", (String) o.getFixingOffsetReason() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BusinessDayOffset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BusinessDayOffset", ValidationResult.ValidationType.CARDINALITY, "BusinessDayOffset", path, "", res.getError());
				}
				return success("BusinessDayOffset", ValidationResult.ValidationType.CARDINALITY, "BusinessDayOffset", path, "");
			})
			.collect(toList());
	}

}
