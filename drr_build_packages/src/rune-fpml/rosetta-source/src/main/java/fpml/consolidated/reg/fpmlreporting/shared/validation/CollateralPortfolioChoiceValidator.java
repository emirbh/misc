package fpml.consolidated.reg.fpmlreporting.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolioChoice;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPosition;
import fpml.consolidated.shared.PositiveMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralPortfolioChoiceValidator implements Validator<CollateralPortfolioChoice> {

	private List<ComparisonResult> getComparisonResults(CollateralPortfolioChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cash", (PositiveMoney) o.getCash() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonCash", (CollateralPosition) o.getNonCash() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPortfolioChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralPortfolioChoice", ValidationResult.ValidationType.CARDINALITY, "CollateralPortfolioChoice", path, "", res.getError());
				}
				return success("CollateralPortfolioChoice", ValidationResult.ValidationType.CARDINALITY, "CollateralPortfolioChoice", path, "");
			})
			.collect(toList());
	}

}
