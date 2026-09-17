package fpml.consolidated.doc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.LinkId;
import fpml.consolidated.doc.LinkType;
import fpml.consolidated.doc.LinkedTrade;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LinkedTradeOnlyExistsValidator implements ValidatorWithArg<LinkedTrade, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LinkedTrade> ValidationResult<LinkedTrade> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("linkType", ExistenceChecker.isSet((LinkType) o.getLinkType()))
				.put("linkId", ExistenceChecker.isSet((LinkId) o.getLinkId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LinkedTrade", ValidationResult.ValidationType.ONLY_EXISTS, "LinkedTrade", path, "");
		}
		return failure("LinkedTrade", ValidationResult.ValidationType.ONLY_EXISTS, "LinkedTrade", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
