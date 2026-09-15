package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.CommonTradeDataReport71__7;
import iso20022.auth030.hkma.tr.CounterpartySpecificData36__2;
import iso20022.auth030.hkma.tr.SupplementaryData1;
import iso20022.auth030.hkma.tr.TechnicalAttributes5__1;
import iso20022.auth030.hkma.tr.TradeData43__7;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeData43__7OnlyExistsValidator implements ValidatorWithArg<TradeData43__7, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeData43__7> ValidationResult<TradeData43__7> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrPtySpcfcData", ExistenceChecker.isSet((CounterpartySpecificData36__2) o.getCtrPtySpcfcData()))
				.put("cmonTradData", ExistenceChecker.isSet((CommonTradeDataReport71__7) o.getCmonTradData()))
				.put("techAttrbts", ExistenceChecker.isSet((TechnicalAttributes5__1) o.getTechAttrbts()))
				.put("splmtryData", ExistenceChecker.isSet((SupplementaryData1) o.getSplmtryData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeData43__7", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData43__7", path, "");
		}
		return failure("TradeData43__7", ValidationResult.ValidationType.ONLY_EXISTS, "TradeData43__7", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
