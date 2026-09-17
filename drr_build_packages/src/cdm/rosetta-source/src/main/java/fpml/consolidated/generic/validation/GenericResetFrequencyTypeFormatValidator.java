package fpml.consolidated.generic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.generic.GenericResetFrequency;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class GenericResetFrequencyTypeFormatValidator implements Validator<GenericResetFrequency> {

	private List<ComparisonResult> getComparisonResults(GenericResetFrequency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("periodMultiplier", o.getPeriodMultiplier(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericResetFrequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericResetFrequency", ValidationResult.ValidationType.TYPE_FORMAT, "GenericResetFrequency", path, "", res.getError());
				}
				return success("GenericResetFrequency", ValidationResult.ValidationType.TYPE_FORMAT, "GenericResetFrequency", path, "");
			})
			.collect(toList());
	}

}
