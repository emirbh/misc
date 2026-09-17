package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.GracePeriodExtension;
import fpml.consolidated.shared.Offset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GracePeriodExtensionValidator implements Validator<GracePeriodExtension> {

	private List<ComparisonResult> getComparisonResults(GracePeriodExtension o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("gracePeriod", (Offset) o.getGracePeriod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GracePeriodExtension o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GracePeriodExtension", ValidationResult.ValidationType.CARDINALITY, "GracePeriodExtension", path, "", res.getError());
				}
				return success("GracePeriodExtension", ValidationResult.ValidationType.CARDINALITY, "GracePeriodExtension", path, "");
			})
			.collect(toList());
	}

}
