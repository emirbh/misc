package cdm.legaldocumentation.transaction.validation;

import cdm.legaldocumentation.transaction.Clause;
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

public class ClauseTypeFormatValidator implements Validator<Clause> {

	private List<ComparisonResult> getComparisonResults(Clause o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Clause o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Clause", ValidationResult.ValidationType.TYPE_FORMAT, "Clause", path, "", res.getError());
				}
				return success("Clause", ValidationResult.ValidationType.TYPE_FORMAT, "Clause", path, "");
			})
			.collect(toList());
	}

}
