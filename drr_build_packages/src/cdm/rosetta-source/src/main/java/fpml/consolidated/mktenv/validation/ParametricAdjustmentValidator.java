package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.mktenv.ParametricAdjustment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ParametricAdjustmentValidator implements Validator<ParametricAdjustment> {

	private List<ComparisonResult> getComparisonResults(ParametricAdjustment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("inputUnits", (PriceQuoteUnits) o.getInputUnits() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricAdjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ParametricAdjustment", ValidationResult.ValidationType.CARDINALITY, "ParametricAdjustment", path, "", res.getError());
				}
				return success("ParametricAdjustment", ValidationResult.ValidationType.CARDINALITY, "ParametricAdjustment", path, "");
			})
			.collect(toList());
	}

}
