package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.SecurityIdentification46__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecurityIdentification46__3TypeFormatValidator implements Validator<SecurityIdentification46__3> {

	private List<ComparisonResult> getComparisonResults(SecurityIdentification46__3 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityIdentification46__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecurityIdentification46__3", ValidationResult.ValidationType.TYPE_FORMAT, "SecurityIdentification46__3", path, "", res.getError());
				}
				return success("SecurityIdentification46__3", ValidationResult.ValidationType.TYPE_FORMAT, "SecurityIdentification46__3", path, "");
			})
			.collect(toList());
	}

}
