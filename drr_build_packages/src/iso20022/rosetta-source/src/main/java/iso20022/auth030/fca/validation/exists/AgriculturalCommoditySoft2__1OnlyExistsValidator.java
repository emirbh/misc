package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AgriculturalCommoditySoft2__1;
import iso20022.auth030.fca.AssetClassDetailedSubProductType2Code;
import iso20022.auth030.fca.AssetClassProductType1Code;
import iso20022.auth030.fca.AssetClassSubProductType2Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AgriculturalCommoditySoft2__1OnlyExistsValidator implements ValidatorWithArg<AgriculturalCommoditySoft2__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AgriculturalCommoditySoft2__1> ValidationResult<AgriculturalCommoditySoft2__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType1Code) o.getBasePdct()))
				.put("subPdct", ExistenceChecker.isSet((AssetClassSubProductType2Code) o.getSubPdct()))
				.put("addtlSubPdct", ExistenceChecker.isSet((AssetClassDetailedSubProductType2Code) o.getAddtlSubPdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AgriculturalCommoditySoft2__1", ValidationResult.ValidationType.ONLY_EXISTS, "AgriculturalCommoditySoft2__1", path, "");
		}
		return failure("AgriculturalCommoditySoft2__1", ValidationResult.ValidationType.ONLY_EXISTS, "AgriculturalCommoditySoft2__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
