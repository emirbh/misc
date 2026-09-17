package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.SecuredPartyRightsEvent;
import cdm.legaldocumentation.csa.SecuredPartyRightsEventElection;
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

public class SecuredPartyRightsEventValidator implements Validator<SecuredPartyRightsEvent> {

	private List<ComparisonResult> getComparisonResults(SecuredPartyRightsEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("securedPartyRightsEventElection", (List<? extends SecuredPartyRightsEventElection>) o.getSecuredPartyRightsEventElection() == null ? 0 : o.getSecuredPartyRightsEventElection().size(), 0, 2), 
				checkCardinality("earlyTerminationDateOptionalLanguage", (Boolean) o.getEarlyTerminationDateOptionalLanguage() != null ? 1 : 0, 1, 1), 
				checkCardinality("failureToPayEarlyTermination", (Boolean) o.getFailureToPayEarlyTermination() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecuredPartyRightsEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecuredPartyRightsEvent", ValidationResult.ValidationType.CARDINALITY, "SecuredPartyRightsEvent", path, "", res.getError());
				}
				return success("SecuredPartyRightsEvent", ValidationResult.ValidationType.CARDINALITY, "SecuredPartyRightsEvent", path, "");
			})
			.collect(toList());
	}

}
