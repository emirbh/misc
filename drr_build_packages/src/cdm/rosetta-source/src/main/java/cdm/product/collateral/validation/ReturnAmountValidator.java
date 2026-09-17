package cdm.product.collateral.validation;

import cdm.product.collateral.ReturnAmount;
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

public class ReturnAmountValidator implements Validator<ReturnAmount> {

	private List<ComparisonResult> getComparisonResults(ReturnAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("includesDefaultLanguage", (Boolean) o.getIncludesDefaultLanguage() != null ? 1 : 0, 0, 1), 
				checkCardinality("customElection", (String) o.getCustomElection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnAmount", ValidationResult.ValidationType.CARDINALITY, "ReturnAmount", path, "", res.getError());
				}
				return success("ReturnAmount", ValidationResult.ValidationType.CARDINALITY, "ReturnAmount", path, "");
			})
			.collect(toList());
	}

}
