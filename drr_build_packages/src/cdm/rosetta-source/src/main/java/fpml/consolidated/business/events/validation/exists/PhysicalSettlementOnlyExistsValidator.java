package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.PhysicalSettlement;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Product;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PhysicalSettlementOnlyExistsValidator implements ValidatorWithArg<PhysicalSettlement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PhysicalSettlement> ValidationResult<PhysicalSettlement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("resultingTradeIdentifier", ExistenceChecker.isSet((PartyTradeIdentifier) o.getResultingTradeIdentifier()))
				.put("resultingTrade", ExistenceChecker.isSet((Trade) o.getResultingTrade()))
				.put("product", ExistenceChecker.isSet((Product) o.getProduct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PhysicalSettlement", ValidationResult.ValidationType.ONLY_EXISTS, "PhysicalSettlement", path, "");
		}
		return failure("PhysicalSettlement", ValidationResult.ValidationType.ONLY_EXISTS, "PhysicalSettlement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
