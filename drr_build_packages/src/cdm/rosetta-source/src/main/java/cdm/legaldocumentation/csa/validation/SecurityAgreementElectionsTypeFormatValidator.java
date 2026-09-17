package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.SecurityAgreementElections;
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

public class SecurityAgreementElectionsTypeFormatValidator implements Validator<SecurityAgreementElections> {

	private List<ComparisonResult> getComparisonResults(SecurityAgreementElections o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityAgreementElections o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecurityAgreementElections", ValidationResult.ValidationType.TYPE_FORMAT, "SecurityAgreementElections", path, "", res.getError());
				}
				return success("SecurityAgreementElections", ValidationResult.ValidationType.TYPE_FORMAT, "SecurityAgreementElections", path, "");
			})
			.collect(toList());
	}

}
