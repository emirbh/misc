package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.OtherAgreement;
import fpml.consolidated.shared.OtherAgreementId;
import fpml.consolidated.shared.OtherAgreementType;
import fpml.consolidated.shared.OtherAgreementVersion;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OtherAgreementOnlyExistsValidator implements ValidatorWithArg<OtherAgreement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OtherAgreement> ValidationResult<OtherAgreement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((List<? extends OtherAgreementId>) o.getIdentifier()))
				.put("type", ExistenceChecker.isSet((OtherAgreementType) o._getType()))
				.put("version", ExistenceChecker.isSet((OtherAgreementVersion) o.getVersion()))
				.put("date", ExistenceChecker.isSet((ZonedDateTime) o.getDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OtherAgreement", ValidationResult.ValidationType.ONLY_EXISTS, "OtherAgreement", path, "");
		}
		return failure("OtherAgreement", ValidationResult.ValidationType.ONLY_EXISTS, "OtherAgreement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
