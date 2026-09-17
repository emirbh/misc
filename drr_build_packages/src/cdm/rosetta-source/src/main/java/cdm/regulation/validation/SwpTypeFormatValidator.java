package cdm.regulation.validation;

import cdm.regulation.Swp;
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

public class SwpTypeFormatValidator implements Validator<Swp> {

	private List<ComparisonResult> getComparisonResults(Swp o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Swp o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Swp", ValidationResult.ValidationType.TYPE_FORMAT, "Swp", path, "", res.getError());
				}
				return success("Swp", ValidationResult.ValidationType.TYPE_FORMAT, "Swp", path, "");
			})
			.collect(toList());
	}

}
