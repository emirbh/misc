package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.StrikePriceBasketReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class StrikePriceBasketReferenceValidator implements Validator<StrikePriceBasketReference> {

	private List<ComparisonResult> getComparisonResults(StrikePriceBasketReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StrikePriceBasketReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StrikePriceBasketReference", ValidationResult.ValidationType.CARDINALITY, "StrikePriceBasketReference", path, "", res.getError());
				}
				return success("StrikePriceBasketReference", ValidationResult.ValidationType.CARDINALITY, "StrikePriceBasketReference", path, "");
			})
			.collect(toList());
	}

}
