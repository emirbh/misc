package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ObservedPrice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObservedPriceTypeFormatValidator implements Validator<ObservedPrice> {

	private List<ComparisonResult> getComparisonResults(ObservedPrice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservedPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservedPrice", ValidationResult.ValidationType.TYPE_FORMAT, "ObservedPrice", path, "", res.getError());
				}
				return success("ObservedPrice", ValidationResult.ValidationType.TYPE_FORMAT, "ObservedPrice", path, "");
			})
			.collect(toList());
	}

}
