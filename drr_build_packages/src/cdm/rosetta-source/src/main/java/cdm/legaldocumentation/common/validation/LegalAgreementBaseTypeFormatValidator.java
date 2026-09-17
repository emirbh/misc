package cdm.legaldocumentation.common.validation;

import cdm.legaldocumentation.common.LegalAgreementBase;
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

public class LegalAgreementBaseTypeFormatValidator implements Validator<LegalAgreementBase> {

	private List<ComparisonResult> getComparisonResults(LegalAgreementBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalAgreementBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegalAgreementBase", ValidationResult.ValidationType.TYPE_FORMAT, "LegalAgreementBase", path, "", res.getError());
				}
				return success("LegalAgreementBase", ValidationResult.ValidationType.TYPE_FORMAT, "LegalAgreementBase", path, "");
			})
			.collect(toList());
	}

}
