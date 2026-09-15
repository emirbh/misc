package drr.regulation.common.trade.quantity.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.quantity.QuantityFrequency;
import drr.standards.iso.FrequencyPeriodEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class QuantityFrequencyValidator implements Validator<QuantityFrequency> {

	private List<ComparisonResult> getComparisonResults(QuantityFrequency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("period", (FrequencyPeriodEnum) o.getPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuantityFrequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuantityFrequency", ValidationResult.ValidationType.CARDINALITY, "QuantityFrequency", path, "", res.getError());
				}
				return success("QuantityFrequency", ValidationResult.ValidationType.CARDINALITY, "QuantityFrequency", path, "");
			})
			.collect(toList());
	}

}
