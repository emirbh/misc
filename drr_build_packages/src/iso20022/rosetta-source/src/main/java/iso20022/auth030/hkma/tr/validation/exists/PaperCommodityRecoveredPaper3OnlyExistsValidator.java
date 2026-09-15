package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassProductType8Code;
import iso20022.auth030.hkma.tr.AssetClassSubProductType50Code;
import iso20022.auth030.hkma.tr.PaperCommodityRecoveredPaper3;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PaperCommodityRecoveredPaper3OnlyExistsValidator implements ValidatorWithArg<PaperCommodityRecoveredPaper3, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PaperCommodityRecoveredPaper3> ValidationResult<PaperCommodityRecoveredPaper3> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basePdct", ExistenceChecker.isSet((AssetClassProductType8Code) o.getBasePdct()))
				.put("subPdct", ExistenceChecker.isSet((AssetClassSubProductType50Code) o.getSubPdct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PaperCommodityRecoveredPaper3", ValidationResult.ValidationType.ONLY_EXISTS, "PaperCommodityRecoveredPaper3", path, "");
		}
		return failure("PaperCommodityRecoveredPaper3", ValidationResult.ValidationType.ONLY_EXISTS, "PaperCommodityRecoveredPaper3", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
