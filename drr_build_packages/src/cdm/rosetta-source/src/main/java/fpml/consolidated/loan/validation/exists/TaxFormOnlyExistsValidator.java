package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.TaxForm;
import fpml.consolidated.loan.TaxFormType;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TaxFormOnlyExistsValidator implements ValidatorWithArg<TaxForm, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TaxForm> ValidationResult<TaxForm> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("taxFormType", ExistenceChecker.isSet((TaxFormType) o.getTaxFormType()))
				.put("taxFormExpiryDate", ExistenceChecker.isSet((ZonedDateTime) o.getTaxFormExpiryDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TaxForm", ValidationResult.ValidationType.ONLY_EXISTS, "TaxForm", path, "");
		}
		return failure("TaxForm", ValidationResult.ValidationType.ONLY_EXISTS, "TaxForm", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
