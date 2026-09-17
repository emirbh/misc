package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountId;
import fpml.consolidated.shared.AccountName;
import fpml.consolidated.shared.AccountType;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AccountOnlyExistsValidator implements ValidatorWithArg<Account, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Account> ValidationResult<Account> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("accountId", ExistenceChecker.isSet((List<? extends AccountId>) o.getAccountId()))
				.put("accountName", ExistenceChecker.isSet((AccountName) o.getAccountName()))
				.put("accountType", ExistenceChecker.isSet((AccountType) o.getAccountType()))
				.put("accountBeneficiary", ExistenceChecker.isSet((PartyReference) o.getAccountBeneficiary()))
				.put("servicingParty", ExistenceChecker.isSet((PartyReference) o.getServicingParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Account", ValidationResult.ValidationType.ONLY_EXISTS, "Account", path, "");
		}
		return failure("Account", ValidationResult.ValidationType.ONLY_EXISTS, "Account", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
