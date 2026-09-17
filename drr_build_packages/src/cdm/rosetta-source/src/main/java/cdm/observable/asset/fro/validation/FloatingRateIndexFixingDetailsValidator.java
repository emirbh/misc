package cdm.observable.asset.fro.validation;

import cdm.observable.asset.fro.BusinessDayOffset;
import cdm.observable.asset.fro.FloatingRateIndexFixingDetails;
import cdm.observable.asset.fro.FloatingRateIndexFixingTime;
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

public class FloatingRateIndexFixingDetailsValidator implements Validator<FloatingRateIndexFixingDetails> {

	private List<ComparisonResult> getComparisonResults(FloatingRateIndexFixingDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixingTime", (FloatingRateIndexFixingTime) o.getFixingTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingOffset", (BusinessDayOffset) o.getFixingOffset() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndexFixingDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateIndexFixingDetails", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexFixingDetails", path, "", res.getError());
				}
				return success("FloatingRateIndexFixingDetails", ValidationResult.ValidationType.CARDINALITY, "FloatingRateIndexFixingDetails", path, "");
			})
			.collect(toList());
	}

}
