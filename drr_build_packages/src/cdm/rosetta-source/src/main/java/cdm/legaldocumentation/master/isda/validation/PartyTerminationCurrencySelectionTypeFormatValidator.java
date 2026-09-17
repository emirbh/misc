package cdm.legaldocumentation.master.isda.validation;

import cdm.legaldocumentation.master.isda.PartyTerminationCurrencySelection;
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

public class PartyTerminationCurrencySelectionTypeFormatValidator implements Validator<PartyTerminationCurrencySelection> {

	private List<ComparisonResult> getComparisonResults(PartyTerminationCurrencySelection o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTerminationCurrencySelection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyTerminationCurrencySelection", ValidationResult.ValidationType.TYPE_FORMAT, "PartyTerminationCurrencySelection", path, "", res.getError());
				}
				return success("PartyTerminationCurrencySelection", ValidationResult.ValidationType.TYPE_FORMAT, "PartyTerminationCurrencySelection", path, "");
			})
			.collect(toList());
	}

}
