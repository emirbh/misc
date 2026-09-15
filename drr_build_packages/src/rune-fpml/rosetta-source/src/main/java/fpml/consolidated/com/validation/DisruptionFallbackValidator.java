package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.DisruptionFallback;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DisruptionFallbackValidator implements Validator<DisruptionFallback> {

	private List<ComparisonResult> getComparisonResults(DisruptionFallback o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityMarketDisruptionFallbackScheme", (String) o.getCommodityMarketDisruptionFallbackScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DisruptionFallback o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DisruptionFallback", ValidationResult.ValidationType.CARDINALITY, "DisruptionFallback", path, "", res.getError());
				}
				return success("DisruptionFallback", ValidationResult.ValidationType.CARDINALITY, "DisruptionFallback", path, "");
			})
			.collect(toList());
	}

}
