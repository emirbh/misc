package fpml.consolidated.dividend.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.dividend.swaps.FixedPaymentLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FixedPaymentLegTypeFormatValidator implements Validator<FixedPaymentLeg> {

	private List<ComparisonResult> getComparisonResults(FixedPaymentLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPaymentLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedPaymentLeg", ValidationResult.ValidationType.TYPE_FORMAT, "FixedPaymentLeg", path, "", res.getError());
				}
				return success("FixedPaymentLeg", ValidationResult.ValidationType.TYPE_FORMAT, "FixedPaymentLeg", path, "");
			})
			.collect(toList());
	}

}
