package fpml.consolidated.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.CanonicalizationMethodType;
import fpml.consolidated.ReferenceType;
import fpml.consolidated.SignatureMethodType;
import fpml.consolidated.SignedInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SignedInfoOnlyExistsValidator implements ValidatorWithArg<SignedInfo, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SignedInfo> ValidationResult<SignedInfo> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("canonicalizationMethod", ExistenceChecker.isSet((CanonicalizationMethodType) o.getCanonicalizationMethod()))
				.put("signatureMethod", ExistenceChecker.isSet((SignatureMethodType) o.getSignatureMethod()))
				.put("reference", ExistenceChecker.isSet((List<? extends ReferenceType>) o.getReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SignedInfo", ValidationResult.ValidationType.ONLY_EXISTS, "SignedInfo", path, "");
		}
		return failure("SignedInfo", ValidationResult.ValidationType.ONLY_EXISTS, "SignedInfo", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
