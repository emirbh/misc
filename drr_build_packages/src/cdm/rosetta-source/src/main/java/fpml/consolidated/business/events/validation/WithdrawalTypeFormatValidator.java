package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.Withdrawal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class WithdrawalTypeFormatValidator implements Validator<Withdrawal> {

	private List<ComparisonResult> getComparisonResults(Withdrawal o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Withdrawal o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Withdrawal", ValidationResult.ValidationType.TYPE_FORMAT, "Withdrawal", path, "", res.getError());
				}
				return success("Withdrawal", ValidationResult.ValidationType.TYPE_FORMAT, "Withdrawal", path, "");
			})
			.collect(toList());
	}

}
