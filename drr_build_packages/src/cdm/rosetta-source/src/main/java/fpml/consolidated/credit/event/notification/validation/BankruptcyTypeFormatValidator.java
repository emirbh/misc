package fpml.consolidated.credit.event.notification.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.credit.event.notification.Bankruptcy;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BankruptcyTypeFormatValidator implements Validator<Bankruptcy> {

	private List<ComparisonResult> getComparisonResults(Bankruptcy o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Bankruptcy o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Bankruptcy", ValidationResult.ValidationType.TYPE_FORMAT, "Bankruptcy", path, "", res.getError());
				}
				return success("Bankruptcy", ValidationResult.ValidationType.TYPE_FORMAT, "Bankruptcy", path, "");
			})
			.collect(toList());
	}

}
