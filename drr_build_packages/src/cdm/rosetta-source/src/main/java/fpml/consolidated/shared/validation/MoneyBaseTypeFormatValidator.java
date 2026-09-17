package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.MoneyBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MoneyBaseTypeFormatValidator implements Validator<MoneyBase> {

	private List<ComparisonResult> getComparisonResults(MoneyBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MoneyBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MoneyBase", ValidationResult.ValidationType.TYPE_FORMAT, "MoneyBase", path, "", res.getError());
				}
				return success("MoneyBase", ValidationResult.ValidationType.TYPE_FORMAT, "MoneyBase", path, "");
			})
			.collect(toList());
	}

}
