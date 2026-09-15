package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.Compounding;
import fpml.consolidated.eq.shared.CompoundingRate;
import fpml.consolidated.fpmlenum.CompoundingMethodEnum;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates2;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CompoundingValidator implements Validator<Compounding> {

	private List<ComparisonResult> getComparisonResults(Compounding o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("compoundingMethod", (CompoundingMethodEnum) o.getCompoundingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("compoundingRate", (CompoundingRate) o.getCompoundingRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("compoundingSpread", (BigDecimal) o.getCompoundingSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("compoundingDates", (AdjustableRelativeOrPeriodicDates2) o.getCompoundingDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Compounding o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Compounding", ValidationResult.ValidationType.CARDINALITY, "Compounding", path, "", res.getError());
				}
				return success("Compounding", ValidationResult.ValidationType.CARDINALITY, "Compounding", path, "");
			})
			.collect(toList());
	}

}
