package fpml.consolidated.reg.fpmlreporting.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.RegulationName;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatorApplicability;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatorApplicabilityOnlyExistsValidator implements ValidatorWithArg<RegulatorApplicability, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatorApplicability> ValidationResult<RegulatorApplicability> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("supervisoryBody", ExistenceChecker.isSet((String) o.getSupervisoryBody()))
				.put("regulation", ExistenceChecker.isSet((List<? extends RegulationName>) o.getRegulation()))
				.put("reportingPartyReference", ExistenceChecker.isSet((PartyReference) o.getReportingPartyReference()))
				.put("counterPartyReference", ExistenceChecker.isSet((PartyReference) o.getCounterPartyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatorApplicability", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatorApplicability", path, "");
		}
		return failure("RegulatorApplicability", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatorApplicability", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
