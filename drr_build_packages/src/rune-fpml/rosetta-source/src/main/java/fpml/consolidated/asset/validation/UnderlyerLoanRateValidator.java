package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.UnderlyerLoanRate;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class UnderlyerLoanRateValidator implements Validator<UnderlyerLoanRate> {

	private List<ComparisonResult> getComparisonResults(UnderlyerLoanRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lossOfStockBorrow", (Boolean) o.getLossOfStockBorrow() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumStockLoanRate", (BigDecimal) o.getMaximumStockLoanRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("increasedCostOfStockBorrow", (Boolean) o.getIncreasedCostOfStockBorrow() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialStockLoanRate", (BigDecimal) o.getInitialStockLoanRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnderlyerLoanRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnderlyerLoanRate", ValidationResult.ValidationType.CARDINALITY, "UnderlyerLoanRate", path, "", res.getError());
				}
				return success("UnderlyerLoanRate", ValidationResult.ValidationType.CARDINALITY, "UnderlyerLoanRate", path, "");
			})
			.collect(toList());
	}

}
