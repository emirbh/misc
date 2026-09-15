package iso20022.auth030.mas.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.CommonTradeDataReport71__2;
import iso20022.auth030.mas.CounterpartySpecificData36__1;
import iso20022.auth030.mas.TechnicalAttributes5__1;
import iso20022.auth030.mas.TradeData43__2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeData43__2OnlyExistsValidator implements ValidatorWithArg<TradeData43__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeData43__2> ValidationResult<TradeData43__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrPtySpcfcData", ExistenceChecker.isSet((CounterpartySpecificData36__1) o.getCtrPtySpcfcData()))
				.put("cmonTradData", ExistenceChecker.isSet((CommonTradeDataReport71__2) o.getCmonTradData()))
				.put("techAttrbts", ExistenceChecker.isSet((TechnicalAttributes5__1) o.getTechAttrbts()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeData43__2", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData43__2", path, "");
		}
		return failure("TradeData43__2", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData43__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
