package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AmountAndDirection106__2;
import iso20022.auth030.fca.NotionalAmount6__1;
import iso20022.auth030.fca.Schedule11__1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NotionalAmount6__1OnlyExistsValidator implements ValidatorWithArg<NotionalAmount6__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NotionalAmount6__1> ValidationResult<NotionalAmount6__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amt", ExistenceChecker.isSet((AmountAndDirection106__2) o.getAmt()))
				.put("schdlPrd", ExistenceChecker.isSet((List<? extends Schedule11__1>) o.getSchdlPrd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NotionalAmount6__1", ValidationResult.ValidationType.ONLY_EXISTS, "NotionalAmount6__1", path, "");
		}
		return failure("NotionalAmount6__1", ValidationResult.ValidationType.ONLY_EXISTS, "NotionalAmount6__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
