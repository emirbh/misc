package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CorporateSector;
import drr.regulation.common.HKMAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class HKMAPartyInformationOnlyExistsValidator implements ValidatorWithArg<HKMAPartyInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends HKMAPartyInformation> ValidationResult<HKMAPartyInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("natureOfParty", ExistenceChecker.isSet((NatureOfPartyEnum) o.getNatureOfParty()))
				.put("nonReportedTradePortfolio", ExistenceChecker.isSet((Boolean) o.getNonReportedTradePortfolio()))
				.put("corporateSector", ExistenceChecker.isSet((CorporateSector) o.getCorporateSector()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("HKMAPartyInformation", ValidationResult.ValidationType.ONLY_EXISTS, "HKMAPartyInformation", path, "");
		}
		return failure("HKMAPartyInformation", ValidationResult.ValidationType.ONLY_EXISTS, "HKMAPartyInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
