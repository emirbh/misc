package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.PostTradeRiskReductionIdentifier1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PostTradeRiskReductionIdentifier1OnlyExistsValidator implements ValidatorWithArg<PostTradeRiskReductionIdentifier1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PostTradeRiskReductionIdentifier1> ValidationResult<PostTradeRiskReductionIdentifier1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("strr", ExistenceChecker.isSet((String) o.getStrr()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PostTradeRiskReductionIdentifier1", ValidationResult.ValidationType.ONLY_EXISTS, "PostTradeRiskReductionIdentifier1", path, "");
		}
		return failure("PostTradeRiskReductionIdentifier1", ValidationResult.ValidationType.ONLY_EXISTS, "PostTradeRiskReductionIdentifier1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
