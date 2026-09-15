package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.CollateralPortfolioCode5Choice__1;
import iso20022.auth030.fca.PortfolioCode3Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralPortfolioCode5Choice__1Validator implements Validator<CollateralPortfolioCode5Choice__1> {

	private List<ComparisonResult> getComparisonResults(CollateralPortfolioCode5Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("prtfl", (PortfolioCode3Choice) o.getPrtfl() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPortfolioCode5Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralPortfolioCode5Choice__1", ValidationResult.ValidationType.CARDINALITY, "CollateralPortfolioCode5Choice__1", path, "", res.getError());
				}
				return success("CollateralPortfolioCode5Choice__1", ValidationResult.ValidationType.CARDINALITY, "CollateralPortfolioCode5Choice__1", path, "");
			})
			.collect(toList());
	}

}
