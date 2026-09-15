package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.FacilityExecutionExceptionDeclaration;
import fpml.consolidated.recordkeeping.processes.RegulatoryTradingObligation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryTradingObligationOnlyExistsValidator implements ValidatorWithArg<RegulatoryTradingObligation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryTradingObligation> ValidationResult<RegulatoryTradingObligation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradedOnVenue", ExistenceChecker.isSet((Boolean) o.getTradedOnVenue()))
				.put("exception", ExistenceChecker.isSet((Boolean) o.getException()))
				.put("exceptionDeclaration", ExistenceChecker.isSet((FacilityExecutionExceptionDeclaration) o.getExceptionDeclaration()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryTradingObligation", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryTradingObligation", path, "");
		}
		return failure("RegulatoryTradingObligation", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryTradingObligation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
