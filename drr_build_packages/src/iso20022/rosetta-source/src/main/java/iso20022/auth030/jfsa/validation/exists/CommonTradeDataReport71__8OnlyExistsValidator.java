package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.CommonTradeDataReport71__8;
import iso20022.auth030.jfsa.ContractType15__1;
import iso20022.auth030.jfsa.TradeTransaction50__8;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommonTradeDataReport71__8OnlyExistsValidator implements ValidatorWithArg<CommonTradeDataReport71__8, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommonTradeDataReport71__8> ValidationResult<CommonTradeDataReport71__8> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctrctData", ExistenceChecker.isSet((ContractType15__1) o.getCtrctData()))
				.put("txData", ExistenceChecker.isSet((TradeTransaction50__8) o.getTxData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommonTradeDataReport71__8", ValidationResult.ValidationType.ONLY_EXISTS, "CommonTradeDataReport71__8", path, "");
		}
		return failure("CommonTradeDataReport71__8", ValidationResult.ValidationType.ONLY_EXISTS, "CommonTradeDataReport71__8", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
