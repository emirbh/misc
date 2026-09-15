package fpml.consolidated.reg.fpmlreporting.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolioChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralPortfolioChoiceTypeFormatValidator implements Validator<CollateralPortfolioChoice> {

	private List<ComparisonResult> getComparisonResults(CollateralPortfolioChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPortfolioChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralPortfolioChoice", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralPortfolioChoice", path, "", res.getError());
				}
				return success("CollateralPortfolioChoice", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralPortfolioChoice", path, "");
			})
			.collect(toList());
	}

}
