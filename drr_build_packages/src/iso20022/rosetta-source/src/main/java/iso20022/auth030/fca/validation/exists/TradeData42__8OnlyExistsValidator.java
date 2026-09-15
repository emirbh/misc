package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.CommonTradeDataReport69__7;
import iso20022.auth030.fca.CounterpartySpecificData36__1;
import iso20022.auth030.fca.ModificationLevel1Code;
import iso20022.auth030.fca.TradeData42__8;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeData42__8OnlyExistsValidator implements ValidatorWithArg<TradeData42__8, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeData42__8> ValidationResult<TradeData42__8> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrPtySpcfcData", ExistenceChecker.isSet((CounterpartySpecificData36__1) o.getCtrPtySpcfcData()))
				.put("cmonTradData", ExistenceChecker.isSet((CommonTradeDataReport69__7) o.getCmonTradData()))
				.put("lvl", ExistenceChecker.isSet((ModificationLevel1Code) o.getLvl()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeData42__8", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData42__8", path, "");
		}
		return failure("TradeData42__8", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData42__8", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
