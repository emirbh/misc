package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbForeign_Exchange;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbPlaceofSettlementEnum;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbForeign_ExchangeOnlyExistsValidator implements ValidatorWithArg<AnnaDsbForeign_Exchange, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbForeign_Exchange> ValidationResult<AnnaDsbForeign_Exchange> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("UnderlierIDSource", ExistenceChecker.isSet((AnnaDsbUnderlierIDSourceEnum) o.getUnderlierIDSource()))
				.put("ReturnorPayoutTrigger", ExistenceChecker.isSet((AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger()))
				.put("PlaceofSettlement", ExistenceChecker.isSet((AnnaDsbPlaceofSettlementEnum) o.getPlaceofSettlement()))
				.put("OtherUnderlierIDSource", ExistenceChecker.isSet((AnnaDsbOtherUnderlierIDSourceEnum) o.getOtherUnderlierIDSource()))
				.put("OtherUnderlierID", ExistenceChecker.isSet((String) o.getOtherUnderlierID()))
				.put("UnderlierID", ExistenceChecker.isSet((String) o.getUnderlierID()))
				.put("SettlementCurrency", ExistenceChecker.isSet((String) o.getSettlementCurrency()))
				.put("NotionalCurrency", ExistenceChecker.isSet((String) o.getNotionalCurrency()))
				.put("OtherNotionalCurrency", ExistenceChecker.isSet((String) o.getOtherNotionalCurrency()))
				.put("UnderlierName", ExistenceChecker.isSet((String) o.getUnderlierName()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbForeign_Exchange", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbForeign_Exchange", path, "");
		}
		return failure("AnnaDsbForeign_Exchange", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbForeign_Exchange", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
