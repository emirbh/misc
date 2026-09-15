package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityPositionStatementChoice;
import fpml.consolidated.loan.LoanContract;
import fpml.consolidated.loan.LoanContractIdentifier;
import fpml.consolidated.loan.LoanContractSummary;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilityPositionStatementChoiceOnlyExistsValidator implements ValidatorWithArg<FacilityPositionStatementChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilityPositionStatementChoice> ValidationResult<FacilityPositionStatementChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("contractIdentifier", ExistenceChecker.isSet((LoanContractIdentifier) o.getContractIdentifier()))
				.put("contractSummary", ExistenceChecker.isSet((LoanContractSummary) o.getContractSummary()))
				.put("contract", ExistenceChecker.isSet((LoanContract) o.getContract()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilityPositionStatementChoice", ValidationResult.ValidationType.ONLY_EXISTS, "FacilityPositionStatementChoice", path, "");
		}
		return failure("FacilityPositionStatementChoice", ValidationResult.ValidationType.ONLY_EXISTS, "FacilityPositionStatementChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
