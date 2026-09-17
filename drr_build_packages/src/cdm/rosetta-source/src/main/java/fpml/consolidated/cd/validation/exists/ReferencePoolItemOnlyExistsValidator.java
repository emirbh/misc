package fpml.consolidated.cd.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.ConstituentWeight;
import fpml.consolidated.cd.ProtectionTermsReference;
import fpml.consolidated.cd.ReferencePair;
import fpml.consolidated.cd.ReferencePoolItem;
import fpml.consolidated.cd.SettlementTermsReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReferencePoolItemOnlyExistsValidator implements ValidatorWithArg<ReferencePoolItem, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReferencePoolItem> ValidationResult<ReferencePoolItem> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("constituentWeight", ExistenceChecker.isSet((ConstituentWeight) o.getConstituentWeight()))
				.put("referencePair", ExistenceChecker.isSet((ReferencePair) o.getReferencePair()))
				.put("protectionTermsReference", ExistenceChecker.isSet((ProtectionTermsReference) o.getProtectionTermsReference()))
				.put("settlementTermsReference", ExistenceChecker.isSet((SettlementTermsReference) o.getSettlementTermsReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReferencePoolItem", ValidationResult.ValidationType.ONLY_EXISTS, "ReferencePoolItem", path, "");
		}
		return failure("ReferencePoolItem", ValidationResult.ValidationType.ONLY_EXISTS, "ReferencePoolItem", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
