package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ClearingException;
import drr.regulation.common.ClearingExceptionDeclaration;
import drr.regulation.common.ClearingExceptionReasonEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ClearingExceptionOnlyExistsValidator implements ValidatorWithArg<ClearingException, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ClearingException> ValidationResult<ClearingException> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("clearingException", ExistenceChecker.isSet((Boolean) o.getClearingException()))
				.put("clearingExceptionReason", ExistenceChecker.isSet((List<ClearingExceptionReasonEnum>) o.getClearingExceptionReason()))
				.put("clearingExceptionDeclaration", ExistenceChecker.isSet((ClearingExceptionDeclaration) o.getClearingExceptionDeclaration()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ClearingException", ValidationResult.ValidationType.ONLY_EXISTS, "ClearingException", path, "");
		}
		return failure("ClearingException", ValidationResult.ValidationType.ONLY_EXISTS, "ClearingException", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
