package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassCommodityPaper5Choice;
import iso20022.auth030.hkma.tr.PaperCommodityContainerBoard2;
import iso20022.auth030.hkma.tr.PaperCommodityNewsprint2;
import iso20022.auth030.hkma.tr.PaperCommodityOther1;
import iso20022.auth030.hkma.tr.PaperCommodityPulp2;
import iso20022.auth030.hkma.tr.PaperCommodityRecoveredPaper3;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityPaper5ChoiceOnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityPaper5Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityPaper5Choice> ValidationResult<AssetClassCommodityPaper5Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cntnrBrd", ExistenceChecker.isSet((PaperCommodityContainerBoard2) o.getCntnrBrd()))
				.put("nwsprnt", ExistenceChecker.isSet((PaperCommodityNewsprint2) o.getNwsprnt()))
				.put("pulp", ExistenceChecker.isSet((PaperCommodityPulp2) o.getPulp()))
				.put("rcvrdPpr", ExistenceChecker.isSet((PaperCommodityRecoveredPaper3) o.getRcvrdPpr()))
				.put("othr", ExistenceChecker.isSet((PaperCommodityOther1) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityPaper5Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityPaper5Choice", path, "");
		}
		return failure("AssetClassCommodityPaper5Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityPaper5Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
