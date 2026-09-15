package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.Tranche3__1;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class Tranche3__1OnlyExistsValidator implements ValidatorWithArg<Tranche3__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Tranche3__1> ValidationResult<Tranche3__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("attchmntPt", ExistenceChecker.isSet((BigDecimal) o.getAttchmntPt()))
				.put("dtchmntPt", ExistenceChecker.isSet((BigDecimal) o.getDtchmntPt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Tranche3__1", ValidationResult.ValidationType.ONLY_EXISTS, "Tranche3__1", path, "");
		}
		return failure("Tranche3__1", ValidationResult.ValidationType.ONLY_EXISTS, "Tranche3__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
