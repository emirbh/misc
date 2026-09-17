package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.AdditionalRightsEvent;
import cdm.legaldocumentation.csa.ControlAgreementNecEvent;
import cdm.legaldocumentation.csa.RightsEvents;
import cdm.legaldocumentation.csa.SecuredPartyRightsEvent;
import cdm.legaldocumentation.csa.SecurityProviderRightsEvent;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RightsEventsOnlyExistsValidator implements ValidatorWithArg<RightsEvents, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RightsEvents> ValidationResult<RightsEvents> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("securityTakerRightsEvent", ExistenceChecker.isSet((SecuredPartyRightsEvent) o.getSecurityTakerRightsEvent()))
				.put("controlAgreementNecEvent", ExistenceChecker.isSet((ControlAgreementNecEvent) o.getControlAgreementNecEvent()))
				.put("securityProviderRightsEvent", ExistenceChecker.isSet((SecurityProviderRightsEvent) o.getSecurityProviderRightsEvent()))
				.put("deliveryInLieuRight", ExistenceChecker.isSet((Boolean) o.getDeliveryInLieuRight()))
				.put("additionalRightsEvent", ExistenceChecker.isSet((AdditionalRightsEvent) o.getAdditionalRightsEvent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RightsEvents", ValidationResult.ValidationType.ONLY_EXISTS, "RightsEvents", path, "");
		}
		return failure("RightsEvents", ValidationResult.ValidationType.ONLY_EXISTS, "RightsEvents", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
