package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.ControlAgreementElections;
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

public class ControlAgreementElectionsTypeFormatValidator implements Validator<ControlAgreementElections> {

	private List<ComparisonResult> getComparisonResults(ControlAgreementElections o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ControlAgreementElections o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ControlAgreementElections", ValidationResult.ValidationType.TYPE_FORMAT, "ControlAgreementElections", path, "", res.getError());
				}
				return success("ControlAgreementElections", ValidationResult.ValidationType.TYPE_FORMAT, "ControlAgreementElections", path, "");
			})
			.collect(toList());
	}

}
