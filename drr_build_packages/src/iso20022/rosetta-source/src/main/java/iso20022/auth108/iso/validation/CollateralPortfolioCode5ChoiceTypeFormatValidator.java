package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.CollateralPortfolioCode5Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralPortfolioCode5ChoiceTypeFormatValidator implements Validator<CollateralPortfolioCode5Choice> {

	private List<ComparisonResult> getComparisonResults(CollateralPortfolioCode5Choice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPortfolioCode5Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralPortfolioCode5Choice", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralPortfolioCode5Choice", path, "", res.getError());
				}
				return success("CollateralPortfolioCode5Choice", ValidationResult.ValidationType.TYPE_FORMAT, "CollateralPortfolioCode5Choice", path, "");
			})
			.collect(toList());
	}

}
