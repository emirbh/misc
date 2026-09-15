package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityGrain3;
import iso20022.auth030.hkma.dtcc.AssetClassDetailedSubProductType30Code;
import iso20022.auth030.hkma.dtcc.AssetClassProductType1Code;
import iso20022.auth030.hkma.dtcc.AssetClassSubProductType5Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AgriculturalCommodityGrain3OnlyExistsValidator implements ValidatorWithArg<AgriculturalCommodityGrain3, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AgriculturalCommodityGrain3> ValidationResult<AgriculturalCommodityGrain3> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType1Code) o.getBasePdct()))
				.put("subPdct", ExistenceChecker.isSet((AssetClassSubProductType5Code) o.getSubPdct()))
				.put("addtlSubPdct", ExistenceChecker.isSet((AssetClassDetailedSubProductType30Code) o.getAddtlSubPdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AgriculturalCommodityGrain3", ValidationResult.ValidationType.ONLY_EXISTS, "AgriculturalCommodityGrain3", path, "");
		}
		return failure("AgriculturalCommodityGrain3", ValidationResult.ValidationType.ONLY_EXISTS, "AgriculturalCommodityGrain3", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
