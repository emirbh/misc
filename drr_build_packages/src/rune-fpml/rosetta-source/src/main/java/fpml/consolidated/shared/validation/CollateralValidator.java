package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Collateral;
import fpml.consolidated.shared.IndependentAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralValidator implements Validator<Collateral> {

	private List<ComparisonResult> getComparisonResults(Collateral o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("independentAmount", (List<? extends IndependentAmount>) o.getIndependentAmount() == null ? 0 : o.getIndependentAmount().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Collateral o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Collateral", ValidationResult.ValidationType.CARDINALITY, "Collateral", path, "", res.getError());
				}
				return success("Collateral", ValidationResult.ValidationType.CARDINALITY, "Collateral", path, "");
			})
			.collect(toList());
	}

}
