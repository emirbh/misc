package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CreditSupportObligations;
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

public class CreditSupportObligationsTypeFormatValidator implements Validator<CreditSupportObligations> {

	private List<ComparisonResult> getComparisonResults(CreditSupportObligations o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportObligations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportObligations", ValidationResult.ValidationType.TYPE_FORMAT, "CreditSupportObligations", path, "", res.getError());
				}
				return success("CreditSupportObligations", ValidationResult.ValidationType.TYPE_FORMAT, "CreditSupportObligations", path, "");
			})
			.collect(toList());
	}

}
