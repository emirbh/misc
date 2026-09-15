package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.StrategyComponentIdentification;
import fpml.consolidated.shared.ProductReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class StrategyComponentIdentificationValidator implements Validator<StrategyComponentIdentification> {

	private List<ComparisonResult> getComparisonResults(StrategyComponentIdentification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("componentReference", (ProductReference) o.getComponentReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StrategyComponentIdentification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StrategyComponentIdentification", ValidationResult.ValidationType.CARDINALITY, "StrategyComponentIdentification", path, "", res.getError());
				}
				return success("StrategyComponentIdentification", ValidationResult.ValidationType.CARDINALITY, "StrategyComponentIdentification", path, "");
			})
			.collect(toList());
	}

}
