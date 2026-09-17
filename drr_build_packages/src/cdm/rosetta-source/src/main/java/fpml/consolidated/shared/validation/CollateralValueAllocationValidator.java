package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.CollateralValueAllocationEnum;
import fpml.consolidated.shared.CollateralValueAllocation;
import fpml.consolidated.shared.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralValueAllocationValidator implements Validator<CollateralValueAllocation> {

	private List<ComparisonResult> getComparisonResults(CollateralValueAllocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (CollateralValueAllocationEnum) o._getType() != null ? 1 : 0, 1, 1), 
				checkCardinality("value", (List<? extends Money>) o.getValue() == null ? 0 : o.getValue().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValueAllocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralValueAllocation", ValidationResult.ValidationType.CARDINALITY, "CollateralValueAllocation", path, "", res.getError());
				}
				return success("CollateralValueAllocation", ValidationResult.ValidationType.CARDINALITY, "CollateralValueAllocation", path, "");
			})
			.collect(toList());
	}

}
