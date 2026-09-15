package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.DerivativeEvent6__6;
import iso20022.auth030.hkma.tr.TradeTransaction50__7;
import iso20022.auth030.hkma.tr.UniqueTransactionIdentifier2Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeTransaction50__7OnlyExistsValidator implements ValidatorWithArg<TradeTransaction50__7, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeTransaction50__7> ValidationResult<TradeTransaction50__7> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("txId", ExistenceChecker.isSet((UniqueTransactionIdentifier2Choice__1) o.getTxId()))
				.put("derivEvt", ExistenceChecker.isSet((DerivativeEvent6__6) o.getDerivEvt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeTransaction50__7", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction50__7", path, "");
		}
		return failure("TradeTransaction50__7", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction50__7", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
