package cdm.observable.event.validation;

import cdm.observable.event.Restructuring;
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

public class RestructuringTypeFormatValidator implements Validator<Restructuring> {

	private List<ComparisonResult> getComparisonResults(Restructuring o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Restructuring o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Restructuring", ValidationResult.ValidationType.TYPE_FORMAT, "Restructuring", path, "", res.getError());
				}
				return success("Restructuring", ValidationResult.ValidationType.TYPE_FORMAT, "Restructuring", path, "");
			})
			.collect(toList());
	}

}
