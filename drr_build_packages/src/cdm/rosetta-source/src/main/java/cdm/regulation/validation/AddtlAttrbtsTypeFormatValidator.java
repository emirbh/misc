package cdm.regulation.validation;

import cdm.regulation.AddtlAttrbts;
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

public class AddtlAttrbtsTypeFormatValidator implements Validator<AddtlAttrbts> {

	private List<ComparisonResult> getComparisonResults(AddtlAttrbts o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AddtlAttrbts o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AddtlAttrbts", ValidationResult.ValidationType.TYPE_FORMAT, "AddtlAttrbts", path, "", res.getError());
				}
				return success("AddtlAttrbts", ValidationResult.ValidationType.TYPE_FORMAT, "AddtlAttrbts", path, "");
			})
			.collect(toList());
	}

}
