package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanContractReference;
import fpml.consolidated.loan.LoanContractsReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanContractsReferenceOnlyExistsValidator implements ValidatorWithArg<LoanContractsReference, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanContractsReference> ValidationResult<LoanContractsReference> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("loanContractReference", ExistenceChecker.isSet((List<? extends LoanContractReference>) o.getLoanContractReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanContractsReference", ValidationResult.ValidationType.ONLY_EXISTS, "LoanContractsReference", path, "");
		}
		return failure("LoanContractsReference", ValidationResult.ValidationType.ONLY_EXISTS, "LoanContractsReference", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
