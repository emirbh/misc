package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.CommonTradeDataReport71__5;
import iso20022.auth030.hkma.tr.CounterpartySpecificData36__3;
import iso20022.auth030.hkma.tr.SupplementaryData1;
import iso20022.auth030.hkma.tr.TechnicalAttributes5__1;
import iso20022.auth030.hkma.tr.TradeData43__5;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeData43__5OnlyExistsValidator implements ValidatorWithArg<TradeData43__5, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeData43__5> ValidationResult<TradeData43__5> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrPtySpcfcData", ExistenceChecker.isSet((CounterpartySpecificData36__3) o.getCtrPtySpcfcData()))
				.put("cmonTradData", ExistenceChecker.isSet((CommonTradeDataReport71__5) o.getCmonTradData()))
				.put("techAttrbts", ExistenceChecker.isSet((TechnicalAttributes5__1) o.getTechAttrbts()))
				.put("splmtryData", ExistenceChecker.isSet((SupplementaryData1) o.getSplmtryData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeData43__5", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData43__5", path, "");
		}
		return failure("TradeData43__5", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData43__5", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
