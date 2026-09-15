package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbAttributesRecord;
import drr.standards.iosco.upi.AnnaDsbDerived;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbIdentifier;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbUpiRecordOnlyExistsValidator implements ValidatorWithArg<AnnaDsbUpiRecord, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbUpiRecord> ValidationResult<AnnaDsbUpiRecord> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("Identifier", ExistenceChecker.isSet((AnnaDsbIdentifier) o.getIdentifier()))
				.put("Header", ExistenceChecker.isSet((AnnaDsbHeader) o.getHeader()))
				.put("Derived", ExistenceChecker.isSet((AnnaDsbDerived) o.getDerived()))
				.put("Attributes", ExistenceChecker.isSet((AnnaDsbAttributesRecord) o.getAttributes()))
				.put("TemplateVersion", ExistenceChecker.isSet((Integer) o.getTemplateVersion()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbUpiRecord", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUpiRecord", path, "");
		}
		return failure("AnnaDsbUpiRecord", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUpiRecord", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
