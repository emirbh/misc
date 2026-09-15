package iso20022.auth030.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.OptionMultipleBarrierLevels1__1;
import iso20022.auth030.hkma.tr.SecuritiesTransactionPrice23Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionMultipleBarrierLevels1__1OnlyExistsValidator implements ValidatorWithArg<OptionMultipleBarrierLevels1__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionMultipleBarrierLevels1__1> ValidationResult<OptionMultipleBarrierLevels1__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("lwrLvl", ExistenceChecker.isSet((SecuritiesTransactionPrice23Choice__1) o.getLwrLvl()))
				.put("upperLvl", ExistenceChecker.isSet((SecuritiesTransactionPrice23Choice__1) o.getUpperLvl()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionMultipleBarrierLevels1__1", ValidationResult.ValidationType.ONLY_EXISTS, "OptionMultipleBarrierLevels1__1", path, "");
		}
		return failure("OptionMultipleBarrierLevels1__1", ValidationResult.ValidationType.ONLY_EXISTS, "OptionMultipleBarrierLevels1__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
