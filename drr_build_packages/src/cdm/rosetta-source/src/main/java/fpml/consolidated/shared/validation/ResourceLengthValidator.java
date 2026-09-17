package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.LengthUnitEnum;
import fpml.consolidated.shared.ResourceLength;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ResourceLengthValidator implements Validator<ResourceLength> {

	private List<ComparisonResult> getComparisonResults(ResourceLength o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lengthUnit", (LengthUnitEnum) o.getLengthUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("lengthValue", (BigDecimal) o.getLengthValue() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResourceLength o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResourceLength", ValidationResult.ValidationType.CARDINALITY, "ResourceLength", path, "", res.getError());
				}
				return success("ResourceLength", ValidationResult.ValidationType.CARDINALITY, "ResourceLength", path, "");
			})
			.collect(toList());
	}

}
