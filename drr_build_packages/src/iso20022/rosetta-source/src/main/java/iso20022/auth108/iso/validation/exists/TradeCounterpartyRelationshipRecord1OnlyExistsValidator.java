package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.TradeCounterpartyRelationship1Choice;
import iso20022.auth108.iso.TradeCounterpartyRelationshipRecord1;
import iso20022.auth108.iso.TradeCounterpartyType1Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeCounterpartyRelationshipRecord1OnlyExistsValidator implements ValidatorWithArg<TradeCounterpartyRelationshipRecord1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeCounterpartyRelationshipRecord1> ValidationResult<TradeCounterpartyRelationshipRecord1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("startRltshPty", ExistenceChecker.isSet((TradeCounterpartyType1Code) o.getStartRltshPty()))
				.put("endRltshPty", ExistenceChecker.isSet((TradeCounterpartyType1Code) o.getEndRltshPty()))
				.put("rltshTp", ExistenceChecker.isSet((TradeCounterpartyRelationship1Choice) o.getRltshTp()))
				.put("desc", ExistenceChecker.isSet((String) o.getDesc()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeCounterpartyRelationshipRecord1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeCounterpartyRelationshipRecord1", path, "");
		}
		return failure("TradeCounterpartyRelationshipRecord1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeCounterpartyRelationshipRecord1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
