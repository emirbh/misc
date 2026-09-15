package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassCommodity7Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityAgricultural6Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityC10Other1;
import iso20022.auth030.hkma.tr.AssetClassCommodityEnergy3Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityEnvironmental3Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityFertilizer4Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityFreight4Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityIndex1;
import iso20022.auth030.hkma.tr.AssetClassCommodityIndustrialProduct2Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityInflation1;
import iso20022.auth030.hkma.tr.AssetClassCommodityMetal2Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityMultiCommodityExotic1;
import iso20022.auth030.hkma.tr.AssetClassCommodityOfficialEconomicStatistics1;
import iso20022.auth030.hkma.tr.AssetClassCommodityOther1;
import iso20022.auth030.hkma.tr.AssetClassCommodityPaper5Choice;
import iso20022.auth030.hkma.tr.AssetClassCommodityPolypropylene4Choice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodity7ChoiceOnlyExistsValidator implements ValidatorWithArg<AssetClassCommodity7Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodity7Choice> ValidationResult<AssetClassCommodity7Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("agrcltrl", ExistenceChecker.isSet((AssetClassCommodityAgricultural6Choice) o.getAgrcltrl()))
				.put("nrgy", ExistenceChecker.isSet((AssetClassCommodityEnergy3Choice) o.getNrgy()))
				.put("envttl", ExistenceChecker.isSet((AssetClassCommodityEnvironmental3Choice) o.getEnvttl()))
				.put("frtlzr", ExistenceChecker.isSet((AssetClassCommodityFertilizer4Choice) o.getFrtlzr()))
				.put("frght", ExistenceChecker.isSet((AssetClassCommodityFreight4Choice) o.getFrght()))
				.put("indx", ExistenceChecker.isSet((AssetClassCommodityIndex1) o.getIndx()))
				.put("indstrlPdct", ExistenceChecker.isSet((AssetClassCommodityIndustrialProduct2Choice) o.getIndstrlPdct()))
				.put("infltn", ExistenceChecker.isSet((AssetClassCommodityInflation1) o.getInfltn()))
				.put("metl", ExistenceChecker.isSet((AssetClassCommodityMetal2Choice) o.getMetl()))
				.put("multiCmmdtyExtc", ExistenceChecker.isSet((AssetClassCommodityMultiCommodityExotic1) o.getMultiCmmdtyExtc()))
				.put("offclEcnmcSttstcs", ExistenceChecker.isSet((AssetClassCommodityOfficialEconomicStatistics1) o.getOffclEcnmcSttstcs()))
				.put("othr", ExistenceChecker.isSet((AssetClassCommodityOther1) o.getOthr()))
				.put("othrC10", ExistenceChecker.isSet((AssetClassCommodityC10Other1) o.getOthrC10()))
				.put("ppr", ExistenceChecker.isSet((AssetClassCommodityPaper5Choice) o.getPpr()))
				.put("plprpln", ExistenceChecker.isSet((AssetClassCommodityPolypropylene4Choice) o.getPlprpln()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodity7Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodity7Choice", path, "");
		}
		return failure("AssetClassCommodity7Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodity7Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
