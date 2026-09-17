package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.PricingParameterDerivativeReference;
import fpml.consolidated.riskdef.WeightedPartialDerivative;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class WeightedPartialDerivativeValidator implements Validator<WeightedPartialDerivative> {

	private List<ComparisonResult> getComparisonResults(WeightedPartialDerivative o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partialDerivativeReference", (PricingParameterDerivativeReference) o.getPartialDerivativeReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("weight", (BigDecimal) o.getWeight() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeightedPartialDerivative o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeightedPartialDerivative", ValidationResult.ValidationType.CARDINALITY, "WeightedPartialDerivative", path, "", res.getError());
				}
				return success("WeightedPartialDerivative", ValidationResult.ValidationType.CARDINALITY, "WeightedPartialDerivative", path, "");
			})
			.collect(toList());
	}

}
