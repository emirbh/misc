package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.AssetClassDetailedSubProductType32Code;
import iso20022.auth030.hkma.dtcc.AssetClassProductType2Code;
import iso20022.auth030.hkma.dtcc.AssetClassSubProductType8Code;
import iso20022.auth030.hkma.dtcc.EnergyCommodityOil3;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EnergyCommodityOil3OnlyExistsValidator implements ValidatorWithArg<EnergyCommodityOil3, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EnergyCommodityOil3> ValidationResult<EnergyCommodityOil3> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType2Code) o.getBasePdct()))
				.put("subPdct", ExistenceChecker.isSet((AssetClassSubProductType8Code) o.getSubPdct()))
				.put("addtlSubPdct", ExistenceChecker.isSet((AssetClassDetailedSubProductType32Code) o.getAddtlSubPdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EnergyCommodityOil3", ValidationResult.ValidationType.ONLY_EXISTS, "EnergyCommodityOil3", path, "");
		}
		return failure("EnergyCommodityOil3", ValidationResult.ValidationType.ONLY_EXISTS, "EnergyCommodityOil3", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
