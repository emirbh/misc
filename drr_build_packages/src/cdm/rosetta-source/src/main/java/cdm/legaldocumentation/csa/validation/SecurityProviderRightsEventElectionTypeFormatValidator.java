package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.SecurityProviderRightsEventElection;
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

public class SecurityProviderRightsEventElectionTypeFormatValidator implements Validator<SecurityProviderRightsEventElection> {

	private List<ComparisonResult> getComparisonResults(SecurityProviderRightsEventElection o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityProviderRightsEventElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecurityProviderRightsEventElection", ValidationResult.ValidationType.TYPE_FORMAT, "SecurityProviderRightsEventElection", path, "", res.getError());
				}
				return success("SecurityProviderRightsEventElection", ValidationResult.ValidationType.TYPE_FORMAT, "SecurityProviderRightsEventElection", path, "");
			})
			.collect(toList());
	}

}
