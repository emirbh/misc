package cdm.event.position.validation;

import cdm.event.position.AggregationParameters;
import cdm.event.position.Portfolio;
import cdm.event.position.PortfolioState;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PortfolioValidator implements Validator<Portfolio> {

	private List<ComparisonResult> getComparisonResults(Portfolio o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("aggregationParameters", (AggregationParameters) o.getAggregationParameters() != null ? 1 : 0, 1, 1), 
				checkCardinality("portfolioState", (PortfolioState) o.getPortfolioState() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Portfolio o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Portfolio", ValidationResult.ValidationType.CARDINALITY, "Portfolio", path, "", res.getError());
				}
				return success("Portfolio", ValidationResult.ValidationType.CARDINALITY, "Portfolio", path, "");
			})
			.collect(toList());
	}

}
