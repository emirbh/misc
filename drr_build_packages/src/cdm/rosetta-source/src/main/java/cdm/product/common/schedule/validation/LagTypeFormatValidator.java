package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.Lag;
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

public class LagTypeFormatValidator implements Validator<Lag> {

	private List<ComparisonResult> getComparisonResults(Lag o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Lag o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Lag", ValidationResult.ValidationType.TYPE_FORMAT, "Lag", path, "", res.getError());
				}
				return success("Lag", ValidationResult.ValidationType.TYPE_FORMAT, "Lag", path, "");
			})
			.collect(toList());
	}

}
