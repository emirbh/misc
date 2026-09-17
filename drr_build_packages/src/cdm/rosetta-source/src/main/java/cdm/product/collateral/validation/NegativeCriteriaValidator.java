package cdm.product.collateral.validation;

import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.NegativeCriteria;
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

public class NegativeCriteriaValidator implements Validator<NegativeCriteria> {

	private List<ComparisonResult> getComparisonResults(NegativeCriteria o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("negativeCriteria", (CollateralCriteria) o.getNegativeCriteria() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NegativeCriteria o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NegativeCriteria", ValidationResult.ValidationType.CARDINALITY, "NegativeCriteria", path, "", res.getError());
				}
				return success("NegativeCriteria", ValidationResult.ValidationType.CARDINALITY, "NegativeCriteria", path, "");
			})
			.collect(toList());
	}

}
