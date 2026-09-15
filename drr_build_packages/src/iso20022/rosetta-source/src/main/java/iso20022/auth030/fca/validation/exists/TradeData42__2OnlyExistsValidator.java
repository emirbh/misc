package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.CommonTradeDataReport69__2;
import iso20022.auth030.fca.CounterpartySpecificData36__2;
import iso20022.auth030.fca.ModificationLevel1Code;
import iso20022.auth030.fca.TradeData42__2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeData42__2OnlyExistsValidator implements ValidatorWithArg<TradeData42__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeData42__2> ValidationResult<TradeData42__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrPtySpcfcData", ExistenceChecker.isSet((CounterpartySpecificData36__2) o.getCtrPtySpcfcData()))
				.put("cmonTradData", ExistenceChecker.isSet((CommonTradeDataReport69__2) o.getCmonTradData()))
				.put("lvl", ExistenceChecker.isSet((ModificationLevel1Code) o.getLvl()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeData42__2", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData42__2", path, "");
		}
		return failure("TradeData42__2", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData42__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
