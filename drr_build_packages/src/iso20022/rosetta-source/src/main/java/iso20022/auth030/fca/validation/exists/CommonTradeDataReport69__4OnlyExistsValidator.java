package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.CommonTradeDataReport69__4;
import iso20022.auth030.fca.TradeTransaction49__4;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommonTradeDataReport69__4OnlyExistsValidator implements ValidatorWithArg<CommonTradeDataReport69__4, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommonTradeDataReport69__4> ValidationResult<CommonTradeDataReport69__4> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("txData", ExistenceChecker.isSet((TradeTransaction49__4) o.getTxData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommonTradeDataReport69__4", ValidationResult.ValidationType.ONLY_EXISTS, "CommonTradeDataReport69__4", path, "");
		}
		return failure("CommonTradeDataReport69__4", ValidationResult.ValidationType.ONLY_EXISTS, "CommonTradeDataReport69__4", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
