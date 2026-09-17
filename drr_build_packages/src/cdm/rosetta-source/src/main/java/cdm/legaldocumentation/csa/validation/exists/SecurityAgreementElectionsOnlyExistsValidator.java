package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.party.Account;
import cdm.legaldocumentation.csa.AppropriatedCollateralValuation;
import cdm.legaldocumentation.csa.EnforcementEvent;
import cdm.legaldocumentation.csa.ExecutionTerms;
import cdm.legaldocumentation.csa.JurisdictionRelatedTerms;
import cdm.legaldocumentation.csa.ProcessAgent;
import cdm.legaldocumentation.csa.SecurityAgreementElections;
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

public class SecurityAgreementElectionsOnlyExistsValidator implements ValidatorWithArg<SecurityAgreementElections, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecurityAgreementElections> ValidationResult<SecurityAgreementElections> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pledgedAccount", ExistenceChecker.isSet((Account) o.getPledgedAccount()))
				.put("enforcementEvent", ExistenceChecker.isSet((EnforcementEvent) o.getEnforcementEvent()))
				.put("deliveryInLieuRight", ExistenceChecker.isSet((Boolean) o.getDeliveryInLieuRight()))
				.put("fullDischarge", ExistenceChecker.isSet((Boolean) o.getFullDischarge()))
				.put("appropriatedCollateralValuation", ExistenceChecker.isSet((AppropriatedCollateralValuation) o.getAppropriatedCollateralValuation()))
				.put("processAgent", ExistenceChecker.isSet((ProcessAgent) o.getProcessAgent()))
				.put("jurisdictionRelatedTerms", ExistenceChecker.isSet((JurisdictionRelatedTerms) o.getJurisdictionRelatedTerms()))
				.put("additionalAmendments", ExistenceChecker.isSet((String) o.getAdditionalAmendments()))
				.put("additionalBespokeTerms", ExistenceChecker.isSet((String) o.getAdditionalBespokeTerms()))
				.put("executionTerms", ExistenceChecker.isSet((ExecutionTerms) o.getExecutionTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecurityAgreementElections", ValidationResult.ValidationType.ONLY_EXISTS, "SecurityAgreementElections", path, "");
		}
		return failure("SecurityAgreementElections", ValidationResult.ValidationType.ONLY_EXISTS, "SecurityAgreementElections", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
