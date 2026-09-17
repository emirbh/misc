package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.CollateralAccessBreach;
import cdm.legaldocumentation.csa.CollateralManagementAgreement;
import cdm.legaldocumentation.csa.ControlAgreement;
import cdm.legaldocumentation.csa.Custodian;
import cdm.legaldocumentation.csa.CustodianEvent;
import cdm.legaldocumentation.csa.CustodianRisk;
import cdm.legaldocumentation.csa.CustodyArrangements;
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

public class CustodyArrangementsOnlyExistsValidator implements ValidatorWithArg<CustodyArrangements, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CustodyArrangements> ValidationResult<CustodyArrangements> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isCreditSupportDocument", ExistenceChecker.isSet((Boolean) o.getIsCreditSupportDocument()))
				.put("hasControlAgreementLanguage", ExistenceChecker.isSet((Boolean) o.getHasControlAgreementLanguage()))
				.put("otherProvisions", ExistenceChecker.isSet((String) o.getOtherProvisions()))
				.put("collateralAccessBreach", ExistenceChecker.isSet((CollateralAccessBreach) o.getCollateralAccessBreach()))
				.put("custodianRisk", ExistenceChecker.isSet((CustodianRisk) o.getCustodianRisk()))
				.put("controlAgreement", ExistenceChecker.isSet((ControlAgreement) o.getControlAgreement()))
				.put("custodianEvent", ExistenceChecker.isSet((CustodianEvent) o.getCustodianEvent()))
				.put("custodian", ExistenceChecker.isSet((Custodian) o.getCustodian()))
				.put("collateralManagementAgreement", ExistenceChecker.isSet((CollateralManagementAgreement) o.getCollateralManagementAgreement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CustodyArrangements", ValidationResult.ValidationType.ONLY_EXISTS, "CustodyArrangements", path, "");
		}
		return failure("CustodyArrangements", ValidationResult.ValidationType.ONLY_EXISTS, "CustodyArrangements", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
