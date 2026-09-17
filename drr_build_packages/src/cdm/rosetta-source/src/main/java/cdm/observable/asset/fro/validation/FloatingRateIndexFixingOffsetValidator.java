package cdm.observable.asset.fro.validation;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.PeriodEnum;
import cdm.observable.asset.fro.FloatingRateIndexFixingOffset;
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

public class FloatingRateIndexFixingOffsetValidator implements Validator<FloatingRateIndexFixingOffset> {

	private List<ComparisonResult> getComparisonResults(FloatingRateIndexFixingOffset o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 1, 1), 
				checkCardinality("period", (PeriodEnum) o.getPeriod() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingOffsetDefinition", (String) o.getFixingOffsetDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingOffsetReason", (String) o.getFixingOffsetReason() != null ? 1 : 0, 0, 1), 
				checkCardinality("designatedMaturity", (String) o.getDesignatedMaturity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexFixingOffset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateIndexFixingOffset", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexFixingOffset", path, "", res.getError());
				}
				return success("FloatingRateIndexFixingOffset", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexFixingOffset", path, "");
			})
			.collect(toList());
	}

}
