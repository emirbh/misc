package cdm.legaldocumentation.master.icma.validation.exists;

import cdm.legaldocumentation.master.icma.GlobalMasterRepoAgreement;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GlobalMasterRepoAgreementOnlyExistsValidator implements ValidatorWithArg<GlobalMasterRepoAgreement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GlobalMasterRepoAgreement> ValidationResult<GlobalMasterRepoAgreement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GlobalMasterRepoAgreement", ValidationResult.ValidationType.ONLY_EXISTS, "GlobalMasterRepoAgreement", path, "");
		}
		return failure("GlobalMasterRepoAgreement", ValidationResult.ValidationType.ONLY_EXISTS, "GlobalMasterRepoAgreement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
