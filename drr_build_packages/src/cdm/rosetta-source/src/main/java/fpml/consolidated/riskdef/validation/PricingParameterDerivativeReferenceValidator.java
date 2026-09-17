package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.PricingParameterDerivativeReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PricingParameterDerivativeReferenceValidator implements Validator<PricingParameterDerivativeReference> {

	private List<ComparisonResult> getComparisonResults(PricingParameterDerivativeReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingParameterDerivativeReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingParameterDerivativeReference", ValidationResult.ValidationType.CARDINALITY, "PricingParameterDerivativeReference", path, "", res.getError());
				}
				return success("PricingParameterDerivativeReference", ValidationResult.ValidationType.CARDINALITY, "PricingParameterDerivativeReference", path, "");
			})
			.collect(toList());
	}

}
