package fpml.consolidated.reg.fpmlreporting.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.DisseminationId;
import fpml.consolidated.reg.fpmlreporting.shared.PublicDissemination;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PublicDisseminationOnlyExistsValidator implements ValidatorWithArg<PublicDissemination, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PublicDissemination> ValidationResult<PublicDissemination> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("disseminationId", ExistenceChecker.isSet((DisseminationId) o.getDisseminationId()))
				.put("publicationTime", ExistenceChecker.isSet((ZonedDateTime) o.getPublicationTime()))
				.put("projectedTime", ExistenceChecker.isSet((ZonedDateTime) o.getProjectedTime()))
				.put("withdrawn", ExistenceChecker.isSet((ZonedDateTime) o.getWithdrawn()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PublicDissemination", ValidationResult.ValidationType.ONLY_EXISTS, "PublicDissemination", path, "");
		}
		return failure("PublicDissemination", ValidationResult.ValidationType.ONLY_EXISTS, "PublicDissemination", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
