package cdm.product.asset.validation;

import cdm.product.asset.CreditDefaultPayout;
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

public class CreditDefaultPayoutTypeFormatValidator implements Validator<CreditDefaultPayout> {

	private List<ComparisonResult> getComparisonResults(CreditDefaultPayout o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDefaultPayout o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDefaultPayout", ValidationResult.ValidationType.TYPE_FORMAT, "CreditDefaultPayout", path, "", res.getError());
				}
				return success("CreditDefaultPayout", ValidationResult.ValidationType.TYPE_FORMAT, "CreditDefaultPayout", path, "");
			})
			.collect(toList());
	}

}
