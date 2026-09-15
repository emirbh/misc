package fpml.consolidated.accumulator.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.accumulator.Gearing;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GearingValidator implements Validator<Gearing> {

	private List<ComparisonResult> getComparisonResults(Gearing o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("gearingFactor", (BigDecimal) o.getGearingFactor() != null ? 1 : 0, 1, 1), 
				checkCardinality("leverageTriggerPrice", (BigDecimal) o.getLeverageTriggerPrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Gearing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Gearing", ValidationResult.ValidationType.CARDINALITY, "Gearing", path, "", res.getError());
				}
				return success("Gearing", ValidationResult.ValidationType.CARDINALITY, "Gearing", path, "");
			})
			.collect(toList());
	}

}
