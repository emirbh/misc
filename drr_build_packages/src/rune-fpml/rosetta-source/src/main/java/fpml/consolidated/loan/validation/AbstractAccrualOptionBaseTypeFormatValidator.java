package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractAccrualOptionBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AbstractAccrualOptionBaseTypeFormatValidator implements Validator<AbstractAccrualOptionBase> {

	private List<ComparisonResult> getComparisonResults(AbstractAccrualOptionBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractAccrualOptionBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractAccrualOptionBase", ValidationResult.ValidationType.TYPE_FORMAT, "AbstractAccrualOptionBase", path, "", res.getError());
				}
				return success("AbstractAccrualOptionBase", ValidationResult.ValidationType.TYPE_FORMAT, "AbstractAccrualOptionBase", path, "");
			})
			.collect(toList());
	}

}
