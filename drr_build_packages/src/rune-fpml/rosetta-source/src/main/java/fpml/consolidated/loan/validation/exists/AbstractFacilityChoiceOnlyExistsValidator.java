package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractFacilityChoice;
import fpml.consolidated.loan.FixedRateOption;
import fpml.consolidated.loan.LcOption;
import fpml.consolidated.loan.LegacyFloatingRateOption;
import fpml.consolidated.loan.LoanFloatingRateOption;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AbstractFacilityChoiceOnlyExistsValidator implements ValidatorWithArg<AbstractFacilityChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AbstractFacilityChoice> ValidationResult<AbstractFacilityChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedRateOption", ExistenceChecker.isSet((FixedRateOption) o.getFixedRateOption()))
				.put("floatingRateOption", ExistenceChecker.isSet((LoanFloatingRateOption) o.getFloatingRateOption()))
				.put("legacyFloatingRateOption", ExistenceChecker.isSet((LegacyFloatingRateOption) o.getLegacyFloatingRateOption()))
				.put("lcOption", ExistenceChecker.isSet((LcOption) o.getLcOption()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AbstractFacilityChoice", ValidationResult.ValidationType.ONLY_EXISTS, "AbstractFacilityChoice", path, "");
		}
		return failure("AbstractFacilityChoice", ValidationResult.ValidationType.ONLY_EXISTS, "AbstractFacilityChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
