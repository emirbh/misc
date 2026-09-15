package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassDetailedSubProductType5Code;
import iso20022.auth030.hkma.dtcc.AssetClassProductType2Code;
import iso20022.auth030.hkma.dtcc.AssetClassSubProductType6Code;
import iso20022.auth030.hkma.dtcc.EnergyCommodityElectricity2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EnergyCommodityElectricity2OnlyExistsValidator implements ValidatorWithArg<EnergyCommodityElectricity2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EnergyCommodityElectricity2> ValidationResult<EnergyCommodityElectricity2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType2Code) o.getBasePdct()))
				.put("subPdct", ExistenceChecker.isSet((AssetClassSubProductType6Code) o.getSubPdct()))
				.put("addtlSubPdct", ExistenceChecker.isSet((AssetClassDetailedSubProductType5Code) o.getAddtlSubPdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EnergyCommodityElectricity2", ValidationResult.ValidationType.ONLY_EXISTS, "EnergyCommodityElectricity2", path, "");
		}
		return failure("EnergyCommodityElectricity2", ValidationResult.ValidationType.ONLY_EXISTS, "EnergyCommodityElectricity2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
