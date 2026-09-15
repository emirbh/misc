package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MasterConfirmation;
import fpml.consolidated.shared.MasterConfirmationAnnexType;
import fpml.consolidated.shared.MasterConfirmationType;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MasterConfirmationOnlyExistsValidator implements ValidatorWithArg<MasterConfirmation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MasterConfirmation> ValidationResult<MasterConfirmation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("masterConfirmationType", ExistenceChecker.isSet((MasterConfirmationType) o.getMasterConfirmationType()))
				.put("masterConfirmationDate", ExistenceChecker.isSet((ZonedDateTime) o.getMasterConfirmationDate()))
				.put("masterConfirmationAnnexDate", ExistenceChecker.isSet((ZonedDateTime) o.getMasterConfirmationAnnexDate()))
				.put("masterConfirmationAnnexType", ExistenceChecker.isSet((MasterConfirmationAnnexType) o.getMasterConfirmationAnnexType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MasterConfirmation", ValidationResult.ValidationType.ONLY_EXISTS, "MasterConfirmation", path, "");
		}
		return failure("MasterConfirmation", ValidationResult.ValidationType.ONLY_EXISTS, "MasterConfirmation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
