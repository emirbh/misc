package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.AccountingStandardEnum;
import fpml.consolidated.fpmlenum.InventoryAccountingMethodEnum;
import fpml.consolidated.loan.LoanCovenantObligationAccountingDetails;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanCovenantObligationAccountingDetailsOnlyExistsValidator implements ValidatorWithArg<LoanCovenantObligationAccountingDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanCovenantObligationAccountingDetails> ValidationResult<LoanCovenantObligationAccountingDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("accountingStandard", ExistenceChecker.isSet((AccountingStandardEnum) o.getAccountingStandard()))
				.put("inventoryMethod", ExistenceChecker.isSet((InventoryAccountingMethodEnum) o.getInventoryMethod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanCovenantObligationAccountingDetails", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationAccountingDetails", path, "");
		}
		return failure("LoanCovenantObligationAccountingDetails", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationAccountingDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
