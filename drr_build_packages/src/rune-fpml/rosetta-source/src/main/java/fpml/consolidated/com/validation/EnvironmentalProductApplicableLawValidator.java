package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.EnvironmentalProductApplicableLaw;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnvironmentalProductApplicableLawValidator implements Validator<EnvironmentalProductApplicableLaw> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalProductApplicableLaw o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("environmentalProductApplicableLawScheme", (String) o.getEnvironmentalProductApplicableLawScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalProductApplicableLaw o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalProductApplicableLaw", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalProductApplicableLaw", path, "", res.getError());
				}
				return success("EnvironmentalProductApplicableLaw", ValidationResult.ValidationType.CARDINALITY, "EnvironmentalProductApplicableLaw", path, "");
			})
			.collect(toList());
	}

}
