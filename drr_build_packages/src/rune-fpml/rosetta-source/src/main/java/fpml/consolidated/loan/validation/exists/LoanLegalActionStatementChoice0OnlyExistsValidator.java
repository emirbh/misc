package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractFacility;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.loan.LoanLegalActionStatementChoice0;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanLegalActionStatementChoice0OnlyExistsValidator implements ValidatorWithArg<LoanLegalActionStatementChoice0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanLegalActionStatementChoice0> ValidationResult<LoanLegalActionStatementChoice0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("facilityIdentifier", ExistenceChecker.isSet((FacilityIdentifier) o.getFacilityIdentifier()))
				.put("facilitySummary", ExistenceChecker.isSet((FacilitySummary) o.getFacilitySummary()))
				.put("facilityGroup", ExistenceChecker.isSet((AbstractFacility) o.getFacilityGroup()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanLegalActionStatementChoice0", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionStatementChoice0", path, "");
		}
		return failure("LoanLegalActionStatementChoice0", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionStatementChoice0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
