package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.OptionMultipleBarrierLevels1__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionMultipleBarrierLevels1__1TypeFormatValidator implements Validator<OptionMultipleBarrierLevels1__1> {

	private List<ComparisonResult> getComparisonResults(OptionMultipleBarrierLevels1__1 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionMultipleBarrierLevels1__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionMultipleBarrierLevels1__1", ValidationResult.ValidationType.TYPE_FORMAT, "OptionMultipleBarrierLevels1__1", path, "", res.getError());
				}
				return success("OptionMultipleBarrierLevels1__1", ValidationResult.ValidationType.TYPE_FORMAT, "OptionMultipleBarrierLevels1__1", path, "");
			})
			.collect(toList());
	}

}
