package cdm.legaldocumentation.master.isda.validation;

import cdm.legaldocumentation.master.isda.TerminationCurrencySelection;
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

public class TerminationCurrencySelectionTypeFormatValidator implements Validator<TerminationCurrencySelection> {

	private List<ComparisonResult> getComparisonResults(TerminationCurrencySelection o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TerminationCurrencySelection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TerminationCurrencySelection", ValidationResult.ValidationType.TYPE_FORMAT, "TerminationCurrencySelection", path, "", res.getError());
				}
				return success("TerminationCurrencySelection", ValidationResult.ValidationType.TYPE_FORMAT, "TerminationCurrencySelection", path, "");
			})
			.collect(toList());
	}

}
