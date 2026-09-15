package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassDetailedSubProductType11Code;
import iso20022.auth030.hkma.dtcc.AssetClassProductType7Code;
import iso20022.auth030.hkma.dtcc.AssetClassSubProductType16Code;
import iso20022.auth030.hkma.dtcc.MetalCommodityPrecious2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MetalCommodityPrecious2OnlyExistsValidator implements ValidatorWithArg<MetalCommodityPrecious2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MetalCommodityPrecious2> ValidationResult<MetalCommodityPrecious2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType7Code) o.getBasePdct()))
				.put("subPdct", ExistenceChecker.isSet((AssetClassSubProductType16Code) o.getSubPdct()))
				.put("addtlSubPdct", ExistenceChecker.isSet((AssetClassDetailedSubProductType11Code) o.getAddtlSubPdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MetalCommodityPrecious2", ValidationResult.ValidationType.ONLY_EXISTS, "MetalCommodityPrecious2", path, "");
		}
		return failure("MetalCommodityPrecious2", ValidationResult.ValidationType.ONLY_EXISTS, "MetalCommodityPrecious2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
