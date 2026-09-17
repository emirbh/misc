package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CreditSupportAgreementElections;
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

public class CreditSupportAgreementElectionsTypeFormatValidator implements Validator<CreditSupportAgreementElections> {

	private List<ComparisonResult> getComparisonResults(CreditSupportAgreementElections o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportAgreementElections o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportAgreementElections", ValidationResult.ValidationType.TYPE_FORMAT, "CreditSupportAgreementElections", path, "", res.getError());
				}
				return success("CreditSupportAgreementElections", ValidationResult.ValidationType.TYPE_FORMAT, "CreditSupportAgreementElections", path, "");
			})
			.collect(toList());
	}

}
