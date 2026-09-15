package fpml.consolidated.valuation.fpmlreporting.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.valuation.ValuationSet;
import fpml.consolidated.valuation.fpmlreporting.Portfolio;
import fpml.consolidated.valuation.fpmlreporting.PortfolioValuationItem;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PortfolioValuationItemValidator implements Validator<PortfolioValuationItem> {

	private List<ComparisonResult> getComparisonResults(PortfolioValuationItem o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("portfolio", (Portfolio) o.getPortfolio() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationSet", (ValuationSet) o.getValuationSet() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioValuationItem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PortfolioValuationItem", ValidationResult.ValidationType.CARDINALITY, "PortfolioValuationItem", path, "", res.getError());
				}
				return success("PortfolioValuationItem", ValidationResult.ValidationType.CARDINALITY, "PortfolioValuationItem", path, "");
			})
			.collect(toList());
	}

}
