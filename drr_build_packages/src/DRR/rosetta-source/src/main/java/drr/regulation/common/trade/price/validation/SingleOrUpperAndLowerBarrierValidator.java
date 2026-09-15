package drr.regulation.common.trade.price.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.price.BarrierPrice;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SingleOrUpperAndLowerBarrierValidator implements Validator<SingleOrUpperAndLowerBarrier> {

	private List<ComparisonResult> getComparisonResults(SingleOrUpperAndLowerBarrier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("_single", (BarrierPrice) o.get_single() != null ? 1 : 0, 0, 1), 
				checkCardinality("upper", (BarrierPrice) o.getUpper() != null ? 1 : 0, 0, 1), 
				checkCardinality("lower", (BarrierPrice) o.getLower() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SingleOrUpperAndLowerBarrier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SingleOrUpperAndLowerBarrier", ValidationResult.ValidationType.CARDINALITY, "SingleOrUpperAndLowerBarrier", path, "", res.getError());
				}
				return success("SingleOrUpperAndLowerBarrier", ValidationResult.ValidationType.CARDINALITY, "SingleOrUpperAndLowerBarrier", path, "");
			})
			.collect(toList());
	}

}
