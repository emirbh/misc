package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AppropriatedCollateralValuation;
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

public class AppropriatedCollateralValuationValidator implements Validator<AppropriatedCollateralValuation> {

	private List<ComparisonResult> getComparisonResults(AppropriatedCollateralValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isSpecified", (Boolean) o.getIsSpecified() != null ? 1 : 0, 1, 1), 
				checkCardinality("election", (String) o.getElection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AppropriatedCollateralValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AppropriatedCollateralValuation", ValidationResult.ValidationType.CARDINALITY, "AppropriatedCollateralValuation", path, "", res.getError());
				}
				return success("AppropriatedCollateralValuation", ValidationResult.ValidationType.CARDINALITY, "AppropriatedCollateralValuation", path, "");
			})
			.collect(toList());
	}

}
