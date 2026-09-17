package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.GenericDimension;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class GenericDimensionTypeFormatValidator implements Validator<GenericDimension> {

	private List<ComparisonResult> getComparisonResults(GenericDimension o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("value", o.getValue(), 0, of(255), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericDimension o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericDimension", ValidationResult.ValidationType.TYPE_FORMAT, "GenericDimension", path, "", res.getError());
				}
				return success("GenericDimension", ValidationResult.ValidationType.TYPE_FORMAT, "GenericDimension", path, "");
			})
			.collect(toList());
	}

}
