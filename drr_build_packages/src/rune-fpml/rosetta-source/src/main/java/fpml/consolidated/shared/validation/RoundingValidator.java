package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.RoundingDirectionEnum;
import fpml.consolidated.shared.Rounding;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RoundingValidator implements Validator<Rounding> {

	private List<ComparisonResult> getComparisonResults(Rounding o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("roundingDirection", (RoundingDirectionEnum) o.getRoundingDirection() != null ? 1 : 0, 0, 1), 
				checkCardinality("precision", (Integer) o.getPrecision() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Rounding o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Rounding", ValidationResult.ValidationType.CARDINALITY, "Rounding", path, "", res.getError());
				}
				return success("Rounding", ValidationResult.ValidationType.CARDINALITY, "Rounding", path, "");
			})
			.collect(toList());
	}

}
