package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AssetClassCommodityEnergy3Choice__1;
import iso20022.auth030.fca.EnergyCommodityCoal2__1;
import iso20022.auth030.fca.EnergyCommodityDistillates2__1;
import iso20022.auth030.fca.EnergyCommodityElectricity2__1;
import iso20022.auth030.fca.EnergyCommodityInterEnergy2__1;
import iso20022.auth030.fca.EnergyCommodityLightEnd2__1;
import iso20022.auth030.fca.EnergyCommodityNaturalGas3__1;
import iso20022.auth030.fca.EnergyCommodityOil3__1;
import iso20022.auth030.fca.EnergyCommodityOther2__1;
import iso20022.auth030.fca.EnergyCommodityRenewableEnergy2__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetClassCommodityEnergy3Choice__1OnlyExistsValidator implements ValidatorWithArg<AssetClassCommodityEnergy3Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetClassCommodityEnergy3Choice__1> ValidationResult<AssetClassCommodityEnergy3Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("elctrcty", ExistenceChecker.isSet((EnergyCommodityElectricity2__1) o.getElctrcty()))
				.put("ntrlGas", ExistenceChecker.isSet((EnergyCommodityNaturalGas3__1) o.getNtrlGas()))
				.put("oil", ExistenceChecker.isSet((EnergyCommodityOil3__1) o.getOil()))
				.put("coal", ExistenceChecker.isSet((EnergyCommodityCoal2__1) o.getCoal()))
				.put("intrNrgy", ExistenceChecker.isSet((EnergyCommodityInterEnergy2__1) o.getIntrNrgy()))
				.put("rnwblNrgy", ExistenceChecker.isSet((EnergyCommodityRenewableEnergy2__1) o.getRnwblNrgy()))
				.put("lghtEnd", ExistenceChecker.isSet((EnergyCommodityLightEnd2__1) o.getLghtEnd()))
				.put("dstllts", ExistenceChecker.isSet((EnergyCommodityDistillates2__1) o.getDstllts()))
				.put("othr", ExistenceChecker.isSet((EnergyCommodityOther2__1) o.getOthr()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetClassCommodityEnergy3Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityEnergy3Choice__1", path, "");
		}
		return failure("AssetClassCommodityEnergy3Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "AssetClassCommodityEnergy3Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
