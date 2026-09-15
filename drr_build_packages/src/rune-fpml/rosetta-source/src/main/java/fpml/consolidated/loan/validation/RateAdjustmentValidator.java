package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.RateAdjustment;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RateAdjustmentValidator implements Validator<RateAdjustment> {

	private List<ComparisonResult> getComparisonResults(RateAdjustment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("margin", (BigDecimal) o.getMargin() != null ? 1 : 0, 1, 1), 
				checkCardinality("pikSpread", (BigDecimal) o.getPikSpread() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RateAdjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RateAdjustment", ValidationResult.ValidationType.CARDINALITY, "RateAdjustment", path, "", res.getError());
				}
				return success("RateAdjustment", ValidationResult.ValidationType.CARDINALITY, "RateAdjustment", path, "");
			})
			.collect(toList());
	}

}
