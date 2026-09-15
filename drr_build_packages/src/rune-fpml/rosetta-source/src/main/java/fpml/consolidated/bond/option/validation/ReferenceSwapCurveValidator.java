package fpml.consolidated.bond.option.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.bond.option.MakeWholeAmount;
import fpml.consolidated.bond.option.ReferenceSwapCurve;
import fpml.consolidated.bond.option.SwapCurveValuation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferenceSwapCurveValidator implements Validator<ReferenceSwapCurve> {

	private List<ComparisonResult> getComparisonResults(ReferenceSwapCurve o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("swapUnwindValue", (SwapCurveValuation) o.getSwapUnwindValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("makeWholeAmount", (MakeWholeAmount) o.getMakeWholeAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceSwapCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceSwapCurve", ValidationResult.ValidationType.CARDINALITY, "ReferenceSwapCurve", path, "", res.getError());
				}
				return success("ReferenceSwapCurve", ValidationResult.ValidationType.CARDINALITY, "ReferenceSwapCurve", path, "");
			})
			.collect(toList());
	}

}
