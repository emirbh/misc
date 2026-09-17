package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MoneyWithParticipantShareOnlyExistsValidator implements ValidatorWithArg<MoneyWithParticipantShare, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MoneyWithParticipantShare> ValidationResult<MoneyWithParticipantShare> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("amount", ExistenceChecker.isSet((BigDecimal) o.getAmount()))
				.put("shareAmount", ExistenceChecker.isSet((BigDecimal) o.getShareAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MoneyWithParticipantShare", ValidationResult.ValidationType.ONLY_EXISTS, "MoneyWithParticipantShare", path, "");
		}
		return failure("MoneyWithParticipantShare", ValidationResult.ValidationType.ONLY_EXISTS, "MoneyWithParticipantShare", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
