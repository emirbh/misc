package cdm.observable.asset.validation;

import cdm.observable.asset.TransactedPrice;
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

public class TransactedPriceTypeFormatValidator implements Validator<TransactedPrice> {

	private List<ComparisonResult> getComparisonResults(TransactedPrice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransactedPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransactedPrice", ValidationResult.ValidationType.TYPE_FORMAT, "TransactedPrice", path, "", res.getError());
				}
				return success("TransactedPrice", ValidationResult.ValidationType.TYPE_FORMAT, "TransactedPrice", path, "");
			})
			.collect(toList());
	}

}
