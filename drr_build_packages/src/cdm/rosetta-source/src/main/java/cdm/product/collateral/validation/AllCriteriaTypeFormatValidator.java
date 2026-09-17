package cdm.product.collateral.validation;

import cdm.product.collateral.AllCriteria;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AllCriteriaTypeFormatValidator implements Validator<AllCriteria> {

	private List<ComparisonResult> getComparisonResults(AllCriteria o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AllCriteria o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AllCriteria", ValidationResult.ValidationType.TYPE_FORMAT, "AllCriteria", path, "", res.getError());
				}
				return success("AllCriteria", ValidationResult.ValidationType.TYPE_FORMAT, "AllCriteria", path, "");
			})
			.collect(toList());
	}

}
