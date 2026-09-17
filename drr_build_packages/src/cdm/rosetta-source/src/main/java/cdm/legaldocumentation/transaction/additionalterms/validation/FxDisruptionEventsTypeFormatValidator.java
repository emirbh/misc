package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.FxDisruptionEvents;
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

public class FxDisruptionEventsTypeFormatValidator implements Validator<FxDisruptionEvents> {

	private List<ComparisonResult> getComparisonResults(FxDisruptionEvents o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDisruptionEvents o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDisruptionEvents", ValidationResult.ValidationType.TYPE_FORMAT, "FxDisruptionEvents", path, "", res.getError());
				}
				return success("FxDisruptionEvents", ValidationResult.ValidationType.TYPE_FORMAT, "FxDisruptionEvents", path, "");
			})
			.collect(toList());
	}

}
