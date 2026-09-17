package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.EventCurrency;
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

public class EventCurrencyTypeFormatValidator implements Validator<EventCurrency> {

	private List<ComparisonResult> getComparisonResults(EventCurrency o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventCurrency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventCurrency", ValidationResult.ValidationType.TYPE_FORMAT, "EventCurrency", path, "", res.getError());
				}
				return success("EventCurrency", ValidationResult.ValidationType.TYPE_FORMAT, "EventCurrency", path, "");
			})
			.collect(toList());
	}

}
