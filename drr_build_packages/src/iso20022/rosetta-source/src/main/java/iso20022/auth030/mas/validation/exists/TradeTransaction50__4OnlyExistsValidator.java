package iso20022.auth030.mas.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.DerivativeEvent6__1;
import iso20022.auth030.mas.OtherPayment5__1;
import iso20022.auth030.mas.TradeTransaction50__4;
import iso20022.auth030.mas.UniqueTransactionIdentifier2Choice__1;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeTransaction50__4OnlyExistsValidator implements ValidatorWithArg<TradeTransaction50__4, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeTransaction50__4> ValidationResult<TradeTransaction50__4> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("txId", ExistenceChecker.isSet((UniqueTransactionIdentifier2Choice__1) o.getTxId()))
				.put("exctnTmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getExctnTmStmp()))
				.put("derivEvt", ExistenceChecker.isSet((DerivativeEvent6__1) o.getDerivEvt()))
				.put("othrPmt", ExistenceChecker.isSet((List<? extends OtherPayment5__1>) o.getOthrPmt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeTransaction50__4", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction50__4", path, "");
		}
		return failure("TradeTransaction50__4", ValidationResult.ValidationType.ONLY_EXISTS, "TradeTransaction50__4", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
