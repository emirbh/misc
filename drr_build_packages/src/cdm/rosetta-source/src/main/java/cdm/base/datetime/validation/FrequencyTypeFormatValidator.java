package cdm.base.datetime.validation;

import cdm.base.datetime.Frequency;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class FrequencyTypeFormatValidator implements Validator<Frequency> {

	private List<ComparisonResult> getComparisonResults(Frequency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("periodMultiplier", o.getPeriodMultiplier(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Frequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Frequency", ValidationResult.ValidationType.TYPE_FORMAT, "Frequency", path, "", res.getError());
				}
				return success("Frequency", ValidationResult.ValidationType.TYPE_FORMAT, "Frequency", path, "");
			})
			.collect(toList());
	}

}
