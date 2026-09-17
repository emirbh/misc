package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.SecurityProviderRightsEvent;
import cdm.legaldocumentation.csa.SecurityProviderRightsEventElection;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecurityProviderRightsEventValidator implements Validator<SecurityProviderRightsEvent> {

	private List<ComparisonResult> getComparisonResults(SecurityProviderRightsEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElection", (List<? extends SecurityProviderRightsEventElection>) o.getPartyElection() == null ? 0 : o.getPartyElection().size(), 0, 2), 
				checkCardinality("includeCoolingOffLanguage", (Boolean) o.getIncludeCoolingOffLanguage() != null ? 1 : 0, 1, 1), 
				checkCardinality("fullDischarge", (Boolean) o.getFullDischarge() != null ? 1 : 0, 0, 1), 
				checkCardinality("automaticSetOff", (Boolean) o.getAutomaticSetOff() != null ? 1 : 0, 0, 1), 
				checkCardinality("customElection", (String) o.getCustomElection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecurityProviderRightsEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecurityProviderRightsEvent", ValidationResult.ValidationType.CARDINALITY, "SecurityProviderRightsEvent", path, "", res.getError());
				}
				return success("SecurityProviderRightsEvent", ValidationResult.ValidationType.CARDINALITY, "SecurityProviderRightsEvent", path, "");
			})
			.collect(toList());
	}

}
