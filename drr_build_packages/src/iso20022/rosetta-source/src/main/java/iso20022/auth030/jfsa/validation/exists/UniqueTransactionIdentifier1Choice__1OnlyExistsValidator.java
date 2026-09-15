package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.GenericIdentification179__1;
import iso20022.auth030.jfsa.UniqueTransactionIdentifier1Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class UniqueTransactionIdentifier1Choice__1OnlyExistsValidator implements ValidatorWithArg<UniqueTransactionIdentifier1Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends UniqueTransactionIdentifier1Choice__1> ValidationResult<UniqueTransactionIdentifier1Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("unqTxIdr", ExistenceChecker.isSet((String) o.getUnqTxIdr()))
				.put("prtry", ExistenceChecker.isSet((GenericIdentification179__1) o.getPrtry()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("UniqueTransactionIdentifier1Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "UniqueTransactionIdentifier1Choice__1", path, "");
		}
		return failure("UniqueTransactionIdentifier1Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "UniqueTransactionIdentifier1Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
