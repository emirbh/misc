package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealStatementChoice2;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.FacilitySummary;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DealStatementChoice2OnlyExistsValidator implements ValidatorWithArg<DealStatementChoice2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DealStatementChoice2> ValidationResult<DealStatementChoice2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("facilityIdentifier", ExistenceChecker.isSet((FacilityIdentifier) o.getFacilityIdentifier()))
				.put("facilitySummary", ExistenceChecker.isSet((FacilitySummary) o.getFacilitySummary()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DealStatementChoice2", ValidationResult.ValidationType.ONLY_EXISTS, "DealStatementChoice2", path, "");
		}
		return failure("DealStatementChoice2", ValidationResult.ValidationType.ONLY_EXISTS, "DealStatementChoice2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
