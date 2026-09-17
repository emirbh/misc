package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.PostingObligations;
import cdm.legaldocumentation.csa.PostingObligationsElection;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PostingObligationsOnlyExistsValidator implements ValidatorWithArg<PostingObligations, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PostingObligations> ValidationResult<PostingObligations> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("securityProvider", ExistenceChecker.isSet((String) o.getSecurityProvider()))
				.put("partyElection", ExistenceChecker.isSet((List<? extends PostingObligationsElection>) o.getPartyElection()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PostingObligations", ValidationResult.ValidationType.ONLY_EXISTS, "PostingObligations", path, "");
		}
		return failure("PostingObligations", ValidationResult.ValidationType.ONLY_EXISTS, "PostingObligations", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
