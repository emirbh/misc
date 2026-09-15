package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.AssetClassCommodity6Choice__1;
import iso20022.auth030.esma.AssetClassCommodityAgricultural6Choice;
import iso20022.auth030.esma.AssetClassCommodityC10Other1;
import iso20022.auth030.esma.AssetClassCommodityEnergy3Choice;
import iso20022.auth030.esma.AssetClassCommodityEnvironmental3Choice;
import iso20022.auth030.esma.AssetClassCommodityFertilizer4Choice;
import iso20022.auth030.esma.AssetClassCommodityFreight4Choice;
import iso20022.auth030.esma.AssetClassCommodityIndustrialProduct2Choice;
import iso20022.auth030.esma.AssetClassCommodityInflation1;
import iso20022.auth030.esma.AssetClassCommodityMetal2Choice;
import iso20022.auth030.esma.AssetClassCommodityMultiCommodityExotic1;
import iso20022.auth030.esma.AssetClassCommodityOfficialEconomicStatistics1;
import iso20022.auth030.esma.AssetClassCommodityOther1;
import iso20022.auth030.esma.AssetClassCommodityPaper4Choice;
import iso20022.auth030.esma.AssetClassCommodityPolypropylene4Choice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodity6Choice__1OnlyExistsValidator implements ValidatorWithArg<AssetClassCommodity6Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodity6Choice__1> ValidationResult<AssetClassCommodity6Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("agrcltrl", ExistenceChecker.isSet((AssetClassCommodityAgricultural6Choice) o.getAgrcltrl()))
				.put("nrgy", ExistenceChecker.isSet((AssetClassCommodityEnergy3Choice) o.getNrgy()))
				.put("envttl", ExistenceChecker.isSet((AssetClassCommodityEnvironmental3Choice) o.getEnvttl()))
				.put("frtlzr", ExistenceChecker.isSet((AssetClassCommodityFertilizer4Choice) o.getFrtlzr()))
				.put("frght", ExistenceChecker.isSet((AssetClassCommodityFreight4Choice) o.getFrght()))
				.put("indstrlPdct", ExistenceChecker.isSet((AssetClassCommodityIndustrialProduct2Choice) o.getIndstrlPdct()))
				.put("infltn", ExistenceChecker.isSet((AssetClassCommodityInflation1) o.getInfltn()))
				.put("metl", ExistenceChecker.isSet((AssetClassCommodityMetal2Choice) o.getMetl()))
				.put("multiCmmdtyExtc", ExistenceChecker.isSet((AssetClassCommodityMultiCommodityExotic1) o.getMultiCmmdtyExtc()))
				.put("offclEcnmcSttstcs", ExistenceChecker.isSet((AssetClassCommodityOfficialEconomicStatistics1) o.getOffclEcnmcSttstcs()))
				.put("othr", ExistenceChecker.isSet((AssetClassCommodityOther1) o.getOthr()))
				.put("othrC10", ExistenceChecker.isSet((AssetClassCommodityC10Other1) o.getOthrC10()))
				.put("ppr", ExistenceChecker.isSet((AssetClassCommodityPaper4Choice) o.getPpr()))
				.put("plprpln", ExistenceChecker.isSet((AssetClassCommodityPolypropylene4Choice) o.getPlprpln()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodity6Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodity6Choice__1", path, "");
		}
		return failure("AssetClassCommodity6Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodity6Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
