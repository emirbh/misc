package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.BasketConstituents3__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BasketConstituents3__1TypeFormatValidator implements Validator<BasketConstituents3__1> {

	private List<ComparisonResult> getComparisonResults(BasketConstituents3__1 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketConstituents3__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketConstituents3__1", ValidationResult.ValidationType.TYPE_FORMAT, "BasketConstituents3__1", path, "", res.getError());
				}
				return success("BasketConstituents3__1", ValidationResult.ValidationType.TYPE_FORMAT, "BasketConstituents3__1", path, "");
			})
			.collect(toList());
	}

}
