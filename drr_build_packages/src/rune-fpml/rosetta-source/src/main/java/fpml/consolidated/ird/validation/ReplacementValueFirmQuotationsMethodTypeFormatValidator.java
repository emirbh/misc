package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.ReplacementValueFirmQuotationsMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReplacementValueFirmQuotationsMethodTypeFormatValidator implements Validator<ReplacementValueFirmQuotationsMethod> {

	private List<ComparisonResult> getComparisonResults(ReplacementValueFirmQuotationsMethod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReplacementValueFirmQuotationsMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReplacementValueFirmQuotationsMethod", ValidationResult.ValidationType.TYPE_FORMAT, "ReplacementValueFirmQuotationsMethod", path, "", res.getError());
				}
				return success("ReplacementValueFirmQuotationsMethod", ValidationResult.ValidationType.TYPE_FORMAT, "ReplacementValueFirmQuotationsMethod", path, "");
			})
			.collect(toList());
	}

}
