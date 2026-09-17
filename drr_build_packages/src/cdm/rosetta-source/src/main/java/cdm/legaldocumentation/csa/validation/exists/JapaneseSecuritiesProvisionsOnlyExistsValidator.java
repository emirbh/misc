package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.JapaneseSecuritiesProvisions;
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

public class JapaneseSecuritiesProvisionsOnlyExistsValidator implements ValidatorWithArg<JapaneseSecuritiesProvisions, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends JapaneseSecuritiesProvisions> ValidationResult<JapaneseSecuritiesProvisions> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isApplicable", ExistenceChecker.isSet((Boolean) o.getIsApplicable()))
				.put("relevantProvisionsElection", ExistenceChecker.isSet((Boolean) o.getRelevantProvisionsElection()))
				.put("relevantProvisionsTerms", ExistenceChecker.isSet((String) o.getRelevantProvisionsTerms()))
				.put("amendmentsToJapaneseProvisions", ExistenceChecker.isSet((Boolean) o.getAmendmentsToJapaneseProvisions()))
				.put("amendmentsToJapaneseProvisionsTerms", ExistenceChecker.isSet((String) o.getAmendmentsToJapaneseProvisionsTerms()))
				.put("clearstreamAmendmentToJapaneseProvisions", ExistenceChecker.isSet((Boolean) o.getClearstreamAmendmentToJapaneseProvisions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("JapaneseSecuritiesProvisions", ValidationResult.ValidationType.ONLY_EXISTS, "JapaneseSecuritiesProvisions", path, "");
		}
		return failure("JapaneseSecuritiesProvisions", ValidationResult.ValidationType.ONLY_EXISTS, "JapaneseSecuritiesProvisions", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
