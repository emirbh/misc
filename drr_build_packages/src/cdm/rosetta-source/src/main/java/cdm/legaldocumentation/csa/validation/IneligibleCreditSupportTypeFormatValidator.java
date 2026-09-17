package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.IneligibleCreditSupport;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IneligibleCreditSupportTypeFormatValidator implements Validator<IneligibleCreditSupport> {

	private List<ComparisonResult> getComparisonResults(IneligibleCreditSupport o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IneligibleCreditSupport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IneligibleCreditSupport", ValidationResult.ValidationType.TYPE_FORMAT, "IneligibleCreditSupport", path, "", res.getError());
				}
				return success("IneligibleCreditSupport", ValidationResult.ValidationType.TYPE_FORMAT, "IneligibleCreditSupport", path, "");
			})
			.collect(toList());
	}

}
