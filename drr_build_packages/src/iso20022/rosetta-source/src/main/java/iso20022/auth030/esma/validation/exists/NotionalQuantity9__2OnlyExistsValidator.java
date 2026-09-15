package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.NotionalQuantity9__2;
import iso20022.auth030.esma.QuantityOrTerm1Choice__1;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NotionalQuantity9__2OnlyExistsValidator implements ValidatorWithArg<NotionalQuantity9__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NotionalQuantity9__2> ValidationResult<NotionalQuantity9__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ttlQty", ExistenceChecker.isSet((BigDecimal) o.getTtlQty()))
				.put("dtls", ExistenceChecker.isSet((QuantityOrTerm1Choice__1) o.getDtls()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NotionalQuantity9__2", ValidationResult.ValidationType.ONLY_EXISTS, "NotionalQuantity9__2", path, "");
		}
		return failure("NotionalQuantity9__2", ValidationResult.ValidationType.ONLY_EXISTS, "NotionalQuantity9__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
