package fpml.consolidated.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.KeyInfoType;
import fpml.consolidated.ObjectType;
import fpml.consolidated.Signature;
import fpml.consolidated.SignatureValueType;
import fpml.consolidated.SignedInfoType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SignatureOnlyExistsValidator implements ValidatorWithArg<Signature, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Signature> ValidationResult<Signature> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("signedInfo", ExistenceChecker.isSet((SignedInfoType) o.getSignedInfo()))
				.put("signatureValue", ExistenceChecker.isSet((SignatureValueType) o.getSignatureValue()))
				.put("keyInfo", ExistenceChecker.isSet((KeyInfoType) o.getKeyInfo()))
				.put("object", ExistenceChecker.isSet((List<? extends ObjectType>) o.getObject()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Signature", ValidationResult.ValidationType.ONLY_EXISTS, "Signature", path, "");
		}
		return failure("Signature", ValidationResult.ValidationType.ONLY_EXISTS, "Signature", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
