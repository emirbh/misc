package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityFx;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.com.CommoditySpread;
import fpml.consolidated.com.FloatingLegCalculation;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.shared.Rounding;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FloatingLegCalculationValidator implements Validator<FloatingLegCalculation> {

	private List<ComparisonResult> getComparisonResults(FloatingLegCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pricingDates", (CommodityPricingDates) o.getPricingDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("conversionFactor", (BigDecimal) o.getConversionFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("rounding", (Rounding) o.getRounding() != null ? 1 : 0, 0, 1), 
				checkCardinality("spread", (CommoditySpread) o.getSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("spreadPercentage", (BigDecimal) o.getSpreadPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("fx", (CommodityFx) o.getFx() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingLegCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingLegCalculation", ValidationResult.ValidationType.CARDINALITY, "FloatingLegCalculation", path, "", res.getError());
				}
				return success("FloatingLegCalculation", ValidationResult.ValidationType.CARDINALITY, "FloatingLegCalculation", path, "");
			})
			.collect(toList());
	}

}
