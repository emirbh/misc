package fpml.consolidated.eqd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eqd.EquityDerivativeBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EquityDerivativeBaseTypeFormatValidator implements Validator<EquityDerivativeBase> {

	private List<ComparisonResult> getComparisonResults(EquityDerivativeBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityDerivativeBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityDerivativeBase", ValidationResult.ValidationType.TYPE_FORMAT, "EquityDerivativeBase", path, "", res.getError());
				}
				return success("EquityDerivativeBase", ValidationResult.ValidationType.TYPE_FORMAT, "EquityDerivativeBase", path, "");
			})
			.collect(toList());
	}

}
