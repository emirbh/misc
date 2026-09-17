package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.GenericDimension;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GenericDimensionValidator implements Validator<GenericDimension> {

	private List<ComparisonResult> getComparisonResults(GenericDimension o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 1, 1), 
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericDimension o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericDimension", ValidationResult.ValidationType.CARDINALITY, "GenericDimension", path, "", res.getError());
				}
				return success("GenericDimension", ValidationResult.ValidationType.CARDINALITY, "GenericDimension", path, "");
			})
			.collect(toList());
	}

}
