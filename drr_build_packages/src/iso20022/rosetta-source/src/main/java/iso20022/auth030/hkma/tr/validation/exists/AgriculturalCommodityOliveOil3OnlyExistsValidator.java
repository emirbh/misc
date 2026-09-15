package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AgriculturalCommodityOliveOil3;
import iso20022.auth030.hkma.tr.AssetClassDetailedSubProductType29Code;
import iso20022.auth030.hkma.tr.AssetClassProductType1Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType3Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AgriculturalCommodityOliveOil3OnlyExistsValidator implements ValidatorWithArg<AgriculturalCommodityOliveOil3, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AgriculturalCommodityOliveOil3> ValidationResult<AgriculturalCommodityOliveOil3> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType1Code) o.getBasePdct()))
				.put("subPdct", ExistenceChecker.isSet((AssetClassSubProductType3Code) o.getSubPdct()))
				.put("addtlSubPdct", ExistenceChecker.isSet((AssetClassDetailedSubProductType29Code) o.getAddtlSubPdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AgriculturalCommodityOliveOil3", ValidationResult.ValidationType.ONLY_EXISTS, "AgriculturalCommodityOliveOil3", path, "");
		}
		return failure("AgriculturalCommodityOliveOil3", ValidationResult.ValidationType.ONLY_EXISTS, "AgriculturalCommodityOliveOil3", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
