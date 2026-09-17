package cdm.legaldocumentation.common.validation;

import cdm.legaldocumentation.common.LegalAgreementIdentification;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class LegalAgreementIdentificationTypeFormatValidator implements Validator<LegalAgreementIdentification> {

	private List<ComparisonResult> getComparisonResults(LegalAgreementIdentification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("vintage", o.getVintage(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalAgreementIdentification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegalAgreementIdentification", ValidationResult.ValidationType.TYPE_FORMAT, "LegalAgreementIdentification", path, "", res.getError());
				}
				return success("LegalAgreementIdentification", ValidationResult.ValidationType.TYPE_FORMAT, "LegalAgreementIdentification", path, "");
			})
			.collect(toList());
	}

}
