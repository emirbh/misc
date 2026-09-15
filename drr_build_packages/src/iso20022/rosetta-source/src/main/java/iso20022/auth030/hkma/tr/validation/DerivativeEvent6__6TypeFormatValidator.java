package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.DerivativeEvent6__6;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DerivativeEvent6__6TypeFormatValidator implements Validator<DerivativeEvent6__6> {

	private List<ComparisonResult> getComparisonResults(DerivativeEvent6__6 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativeEvent6__6 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativeEvent6__6", ValidationResult.ValidationType.TYPE_FORMAT, "DerivativeEvent6__6", path, "", res.getError());
				}
				return success("DerivativeEvent6__6", ValidationResult.ValidationType.TYPE_FORMAT, "DerivativeEvent6__6", path, "");
			})
			.collect(toList());
	}

}
