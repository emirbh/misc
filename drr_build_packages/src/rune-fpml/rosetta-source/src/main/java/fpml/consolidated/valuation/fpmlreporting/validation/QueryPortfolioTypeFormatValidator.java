package fpml.consolidated.valuation.fpmlreporting.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.valuation.fpmlreporting.QueryPortfolio;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class QueryPortfolioTypeFormatValidator implements Validator<QueryPortfolio> {

	private List<ComparisonResult> getComparisonResults(QueryPortfolio o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QueryPortfolio o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QueryPortfolio", ValidationResult.ValidationType.TYPE_FORMAT, "QueryPortfolio", path, "", res.getError());
				}
				return success("QueryPortfolio", ValidationResult.ValidationType.TYPE_FORMAT, "QueryPortfolio", path, "");
			})
			.collect(toList());
	}

}
