package cdm.regulation.validation;

import cdm.regulation.Sngl;
import cdm.regulation.SwpIn;
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

public class SwpInValidator implements Validator<SwpIn> {

	private List<ComparisonResult> getComparisonResults(SwpIn o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("sngl", (Sngl) o.getSngl() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SwpIn o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SwpIn", ValidationResult.ValidationType.CARDINALITY, "SwpIn", path, "", res.getError());
				}
				return success("SwpIn", ValidationResult.ValidationType.CARDINALITY, "SwpIn", path, "");
			})
			.collect(toList());
	}

}
