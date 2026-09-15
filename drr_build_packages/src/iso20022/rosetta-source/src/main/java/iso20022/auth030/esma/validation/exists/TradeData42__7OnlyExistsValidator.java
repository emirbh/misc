package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.CommonTradeDataReport69__6;
import iso20022.auth030.esma.CounterpartySpecificData36__3;
import iso20022.auth030.esma.ModificationLevel1Code;
import iso20022.auth030.esma.TradeData42__7;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeData42__7OnlyExistsValidator implements ValidatorWithArg<TradeData42__7, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeData42__7> ValidationResult<TradeData42__7> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrPtySpcfcData", ExistenceChecker.isSet((CounterpartySpecificData36__3) o.getCtrPtySpcfcData()))
				.put("cmonTradData", ExistenceChecker.isSet((CommonTradeDataReport69__6) o.getCmonTradData()))
				.put("lvl", ExistenceChecker.isSet((ModificationLevel1Code) o.getLvl()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeData42__7", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData42__7", path, "");
		}
		return failure("TradeData42__7", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData42__7", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
