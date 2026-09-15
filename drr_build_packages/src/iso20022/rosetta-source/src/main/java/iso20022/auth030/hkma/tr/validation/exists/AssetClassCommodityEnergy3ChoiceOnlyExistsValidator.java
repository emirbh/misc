package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.AssetClassCommodityEnergy3Choice;
import iso20022.auth030.hkma.tr.EnergyCommodityCoal2;
import iso20022.auth030.hkma.tr.EnergyCommodityDistillates2;
import iso20022.auth030.hkma.tr.EnergyCommodityElectricity2;
import iso20022.auth030.hkma.tr.EnergyCommodityInterEnergy2;
import iso20022.auth030.hkma.tr.EnergyCommodityLightEnd2;
import iso20022.auth030.hkma.tr.EnergyCommodityNaturalGas3;
import iso20022.auth030.hkma.tr.EnergyCommodityOil3;
import iso20022.auth030.hkma.tr.EnergyCommodityOther2;
import iso20022.auth030.hkma.tr.EnergyCommodityRenewableEnergy2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityEnergy3ChoiceOnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityEnergy3Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityEnergy3Choice> ValidationResult<AssetClassCommodityEnergy3Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("elctrcty", ExistenceChecker.isSet((EnergyCommodityElectricity2) o.getElctrcty()))
				.put("ntrlGas", ExistenceChecker.isSet((EnergyCommodityNaturalGas3) o.getNtrlGas()))
				.put("oil", ExistenceChecker.isSet((EnergyCommodityOil3) o.getOil()))
				.put("coal", ExistenceChecker.isSet((EnergyCommodityCoal2) o.getCoal()))
				.put("intrNrgy", ExistenceChecker.isSet((EnergyCommodityInterEnergy2) o.getIntrNrgy()))
				.put("rnwblNrgy", ExistenceChecker.isSet((EnergyCommodityRenewableEnergy2) o.getRnwblNrgy()))
				.put("lghtEnd", ExistenceChecker.isSet((EnergyCommodityLightEnd2) o.getLghtEnd()))
				.put("dstllts", ExistenceChecker.isSet((EnergyCommodityDistillates2) o.getDstllts()))
				.put("othr", ExistenceChecker.isSet((EnergyCommodityOther2) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityEnergy3Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityEnergy3Choice", path, "");
		}
		return failure("AssetClassCommodityEnergy3Choice", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityEnergy3Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
