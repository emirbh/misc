package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CFTCEntityClassificationEnum;
import drr.regulation.common.CFTCFederalEntityClassificationEnum;
import drr.regulation.common.CFTCFinancialEntityClassificationEnum;
import drr.regulation.common.CFTCPartyInformation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CFTCPartyInformationOnlyExistsValidator implements ValidatorWithArg<CFTCPartyInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CFTCPartyInformation> ValidationResult<CFTCPartyInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("organizationType", ExistenceChecker.isSet((CFTCEntityClassificationEnum) o.getOrganizationType()))
				.put("federalEntity", ExistenceChecker.isSet((CFTCFederalEntityClassificationEnum) o.getFederalEntity()))
				.put("financialEntity", ExistenceChecker.isSet((CFTCFinancialEntityClassificationEnum) o.getFinancialEntity()))
				.put("physicalCommodityContractIndicator", ExistenceChecker.isSet((Boolean) o.getPhysicalCommodityContractIndicator()))
				.put("isUSPerson", ExistenceChecker.isSet((Boolean) o.getIsUSPerson()))
				.put("nonReportedTradePortfolio", ExistenceChecker.isSet((Boolean) o.getNonReportedTradePortfolio()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CFTCPartyInformation", ValidationResult.ValidationType.ONLY_EXISTS, "CFTCPartyInformation", path, "");
		}
		return failure("CFTCPartyInformation", ValidationResult.ValidationType.ONLY_EXISTS, "CFTCPartyInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
