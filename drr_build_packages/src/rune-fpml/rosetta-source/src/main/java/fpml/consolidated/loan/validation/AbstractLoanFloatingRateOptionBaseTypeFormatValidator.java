package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractLoanFloatingRateOptionBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AbstractLoanFloatingRateOptionBaseTypeFormatValidator implements Validator<AbstractLoanFloatingRateOptionBase> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanFloatingRateOptionBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanFloatingRateOptionBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanFloatingRateOptionBase", ValidationResult.ValidationType.TYPE_FORMAT, "AbstractLoanFloatingRateOptionBase", path, "", res.getError());
				}
				return success("AbstractLoanFloatingRateOptionBase", ValidationResult.ValidationType.TYPE_FORMAT, "AbstractLoanFloatingRateOptionBase", path, "");
			})
			.collect(toList());
	}

}
