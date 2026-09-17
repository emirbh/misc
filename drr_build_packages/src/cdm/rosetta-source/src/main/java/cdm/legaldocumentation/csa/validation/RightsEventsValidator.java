package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AdditionalRightsEvent;
import cdm.legaldocumentation.csa.ControlAgreementNecEvent;
import cdm.legaldocumentation.csa.RightsEvents;
import cdm.legaldocumentation.csa.SecuredPartyRightsEvent;
import cdm.legaldocumentation.csa.SecurityProviderRightsEvent;
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

public class RightsEventsValidator implements Validator<RightsEvents> {

	private List<ComparisonResult> getComparisonResults(RightsEvents o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("securityTakerRightsEvent", (SecuredPartyRightsEvent) o.getSecurityTakerRightsEvent() != null ? 1 : 0, 1, 1), 
				checkCardinality("controlAgreementNecEvent", (ControlAgreementNecEvent) o.getControlAgreementNecEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("securityProviderRightsEvent", (SecurityProviderRightsEvent) o.getSecurityProviderRightsEvent() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryInLieuRight", (Boolean) o.getDeliveryInLieuRight() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalRightsEvent", (AdditionalRightsEvent) o.getAdditionalRightsEvent() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RightsEvents o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RightsEvents", ValidationResult.ValidationType.CARDINALITY, "RightsEvents", path, "", res.getError());
				}
				return success("RightsEvents", ValidationResult.ValidationType.CARDINALITY, "RightsEvents", path, "");
			})
			.collect(toList());
	}

}
