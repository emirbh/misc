package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DiscountingTypeEnum;
import fpml.consolidated.ird.Discounting;
import fpml.consolidated.shared.DayCountFraction;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DiscountingValidator implements Validator<Discounting> {

	private List<ComparisonResult> getComparisonResults(Discounting o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("discountingType", (DiscountingTypeEnum) o.getDiscountingType() != null ? 1 : 0, 0, 1), 
				checkCardinality("discountRate", (BigDecimal) o.getDiscountRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("discountRateDayCountFraction", (DayCountFraction) o.getDiscountRateDayCountFraction() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Discounting o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Discounting", ValidationResult.ValidationType.CARDINALITY, "Discounting", path, "", res.getError());
				}
				return success("Discounting", ValidationResult.ValidationType.CARDINALITY, "Discounting", path, "");
			})
			.collect(toList());
	}

}
