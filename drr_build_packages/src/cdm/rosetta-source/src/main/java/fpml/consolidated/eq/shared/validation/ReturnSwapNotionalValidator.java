package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.ReturnSwapNotional;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.DeterminationMethodReference;
import fpml.consolidated.shared.NotionalAmount;
import fpml.consolidated.shared.ReturnSwapNotionalAmountReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReturnSwapNotionalValidator implements Validator<ReturnSwapNotional> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapNotional o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeNotionalAmount", (ReturnSwapNotionalAmountReference) o.getRelativeNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeDeterminationMethod", (DeterminationMethodReference) o.getRelativeDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (NotionalAmount) o.getNotionalAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapNotional o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapNotional", ValidationResult.ValidationType.CARDINALITY, "ReturnSwapNotional", path, "", res.getError());
				}
				return success("ReturnSwapNotional", ValidationResult.ValidationType.CARDINALITY, "ReturnSwapNotional", path, "");
			})
			.collect(toList());
	}

}
