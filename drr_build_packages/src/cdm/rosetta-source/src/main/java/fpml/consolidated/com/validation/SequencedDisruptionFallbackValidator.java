package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.DisruptionFallback;
import fpml.consolidated.com.SequencedDisruptionFallback;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SequencedDisruptionFallbackValidator implements Validator<SequencedDisruptionFallback> {

	private List<ComparisonResult> getComparisonResults(SequencedDisruptionFallback o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fallback", (DisruptionFallback) o.getFallback() != null ? 1 : 0, 0, 1), 
				checkCardinality("sequence", (Integer) o.getSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SequencedDisruptionFallback o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SequencedDisruptionFallback", ValidationResult.ValidationType.CARDINALITY, "SequencedDisruptionFallback", path, "", res.getError());
				}
				return success("SequencedDisruptionFallback", ValidationResult.ValidationType.CARDINALITY, "SequencedDisruptionFallback", path, "");
			})
			.collect(toList());
	}

}
