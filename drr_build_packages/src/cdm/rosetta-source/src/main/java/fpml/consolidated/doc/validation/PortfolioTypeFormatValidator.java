package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.Portfolio;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PortfolioTypeFormatValidator implements Validator<Portfolio> {

	private List<ComparisonResult> getComparisonResults(Portfolio o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Portfolio o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Portfolio", ValidationResult.ValidationType.TYPE_FORMAT, "Portfolio", path, "", res.getError());
				}
				return success("Portfolio", ValidationResult.ValidationType.TYPE_FORMAT, "Portfolio", path, "");
			})
			.collect(toList());
	}

}
