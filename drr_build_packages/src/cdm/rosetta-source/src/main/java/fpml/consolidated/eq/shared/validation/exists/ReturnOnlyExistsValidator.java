package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.DividendConditions;
import fpml.consolidated.eq.shared.Return;
import fpml.consolidated.fpmlenum.ReturnTypeEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReturnOnlyExistsValidator implements ValidatorWithArg<Return, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Return> ValidationResult<Return> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("returnType", ExistenceChecker.isSet((ReturnTypeEnum) o.getReturnType()))
				.put("dividendConditions", ExistenceChecker.isSet((DividendConditions) o.getDividendConditions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Return", ValidationResult.ValidationType.ONLY_EXISTS, "Return", path, "");
		}
		return failure("Return", ValidationResult.ValidationType.ONLY_EXISTS, "Return", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
