package fpml.consolidated.eqd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eqd.EquityDerivativeLongFormBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EquityDerivativeLongFormBaseTypeFormatValidator implements Validator<EquityDerivativeLongFormBase> {

	private List<ComparisonResult> getComparisonResults(EquityDerivativeLongFormBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityDerivativeLongFormBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityDerivativeLongFormBase", ValidationResult.ValidationType.TYPE_FORMAT, "EquityDerivativeLongFormBase", path, "", res.getError());
				}
				return success("EquityDerivativeLongFormBase", ValidationResult.ValidationType.TYPE_FORMAT, "EquityDerivativeLongFormBase", path, "");
			})
			.collect(toList());
	}

}
