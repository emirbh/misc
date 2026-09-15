package iso20022.auth108.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.fca.TradeCounterpartyRelationship1Choice__1;
import iso20022.auth108.fca.TradeCounterpartyRelationshipRecord1__1;
import iso20022.auth108.fca.TradeCounterpartyType1Code__1;
import iso20022.auth108.fca.TradeCounterpartyType1Code__2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeCounterpartyRelationshipRecord1__1OnlyExistsValidator implements ValidatorWithArg<TradeCounterpartyRelationshipRecord1__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeCounterpartyRelationshipRecord1__1> ValidationResult<TradeCounterpartyRelationshipRecord1__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("startRltshPty", ExistenceChecker.isSet((TradeCounterpartyType1Code__1) o.getStartRltshPty()))
				.put("endRltshPty", ExistenceChecker.isSet((TradeCounterpartyType1Code__2) o.getEndRltshPty()))
				.put("rltshTp", ExistenceChecker.isSet((TradeCounterpartyRelationship1Choice__1) o.getRltshTp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeCounterpartyRelationshipRecord1__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeCounterpartyRelationshipRecord1__1", path, "");
		}
		return failure("TradeCounterpartyRelationshipRecord1__1", ValidationResult.ValidationType.ONLY_EXISTS, "TradeCounterpartyRelationshipRecord1__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
