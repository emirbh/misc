package fpml.consolidated.credit.event.notification.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.credit.event.notification.BankruptcyEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BankruptcyEventTypeFormatValidator implements Validator<BankruptcyEvent> {

	private List<ComparisonResult> getComparisonResults(BankruptcyEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BankruptcyEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BankruptcyEvent", ValidationResult.ValidationType.TYPE_FORMAT, "BankruptcyEvent", path, "", res.getError());
				}
				return success("BankruptcyEvent", ValidationResult.ValidationType.TYPE_FORMAT, "BankruptcyEvent", path, "");
			})
			.collect(toList());
	}

}
