package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fpmlenum.PeriodEnum;
import fpml.consolidated.repo.AdjustableOffset;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdjustableOffsetValidator implements Validator<AdjustableOffset> {

	private List<ComparisonResult> getComparisonResults(AdjustableOffset o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 1, 1), 
				checkCardinality("period", (PeriodEnum) o.getPeriod() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayType", (DayTypeEnum) o.getDayType() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCentersReference", (BusinessCentersReference) o.getBusinessCentersReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessCenters", (BusinessCenters) o.getBusinessCenters() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableOffset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableOffset", ValidationResult.ValidationType.CARDINALITY, "AdjustableOffset", path, "", res.getError());
				}
				return success("AdjustableOffset", ValidationResult.ValidationType.CARDINALITY, "AdjustableOffset", path, "");
			})
			.collect(toList());
	}

}
