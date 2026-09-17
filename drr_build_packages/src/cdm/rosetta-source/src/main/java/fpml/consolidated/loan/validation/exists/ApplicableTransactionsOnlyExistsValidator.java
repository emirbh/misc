package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.LoanAllTransactionsEnum;
import fpml.consolidated.loan.ApplicableTransactionType;
import fpml.consolidated.loan.ApplicableTransactions;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ApplicableTransactionsOnlyExistsValidator implements ValidatorWithArg<ApplicableTransactions, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ApplicableTransactions> ValidationResult<ApplicableTransactions> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("applicableTransactionType", ExistenceChecker.isSet((List<? extends ApplicableTransactionType>) o.getApplicableTransactionType()))
				.put("allTransactions", ExistenceChecker.isSet((LoanAllTransactionsEnum) o.getAllTransactions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ApplicableTransactions", ValidationResult.ValidationType.ONLY_EXISTS, "ApplicableTransactions", path, "");
		}
		return failure("ApplicableTransactions", ValidationResult.ValidationType.ONLY_EXISTS, "ApplicableTransactions", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
