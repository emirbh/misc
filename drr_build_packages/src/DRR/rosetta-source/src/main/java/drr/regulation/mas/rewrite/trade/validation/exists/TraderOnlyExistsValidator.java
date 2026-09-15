package drr.regulation.mas.rewrite.trade.validation.exists;

import cdm.base.staticdata.party.Address;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.mas.rewrite.trade.Trader;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TraderOnlyExistsValidator implements ValidatorWithArg<Trader, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Trader> ValidationResult<Trader> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("placeOfEmployment", ExistenceChecker.isSet((Address) o.getPlaceOfEmployment()))
				.put("isAuthorisedToTradeInSingapore", ExistenceChecker.isSet((Boolean) o.getIsAuthorisedToTradeInSingapore()))
				.put("currentLocation", ExistenceChecker.isSet((Address) o.getCurrentLocation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Trader", ValidationResult.ValidationType.ONLY_EXISTS, "Trader", path, "");
		}
		return failure("Trader", ValidationResult.ValidationType.ONLY_EXISTS, "Trader", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
