package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.com.CommodityReturnCalculation;
import fpml.consolidated.com.CommodityValuationDates;
import fpml.consolidated.fpmlenum.CommodityReturnCalculationFormulaEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityReturnCalculationValidator implements Validator<CommodityReturnCalculation> {

	private List<ComparisonResult> getComparisonResults(CommodityReturnCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("formula", (CommodityReturnCalculationFormulaEnum) o.getFormula() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingDates", (CommodityPricingDates) o.getPricingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDates", (CommodityValuationDates) o.getValuationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialPrice", (BigDecimal) o.getInitialPrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityReturnCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityReturnCalculation", ValidationResult.ValidationType.CARDINALITY, "CommodityReturnCalculation", path, "", res.getError());
				}
				return success("CommodityReturnCalculation", ValidationResult.ValidationType.CARDINALITY, "CommodityReturnCalculation", path, "");
			})
			.collect(toList());
	}

}
