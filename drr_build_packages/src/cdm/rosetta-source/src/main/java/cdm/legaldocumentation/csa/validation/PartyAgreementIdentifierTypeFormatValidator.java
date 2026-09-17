package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.PartyAgreementIdentifier;
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

public class PartyAgreementIdentifierTypeFormatValidator implements Validator<PartyAgreementIdentifier> {

	private List<ComparisonResult> getComparisonResults(PartyAgreementIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyAgreementIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyAgreementIdentifier", ValidationResult.ValidationType.TYPE_FORMAT, "PartyAgreementIdentifier", path, "", res.getError());
				}
				return success("PartyAgreementIdentifier", ValidationResult.ValidationType.TYPE_FORMAT, "PartyAgreementIdentifier", path, "");
			})
			.collect(toList());
	}

}
