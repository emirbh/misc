package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CommonPartiesReport;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommonPartiesReportOnlyExistsValidator implements ValidatorWithArg<CommonPartiesReport, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommonPartiesReport> ValidationResult<CommonPartiesReport> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("reportingTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getReportingTimestamp()))
				.put("entityResponsibleForReporting", ExistenceChecker.isSet((String) o.getEntityResponsibleForReporting()))
				.put("counterparty1", ExistenceChecker.isSet((String) o.getCounterparty1()))
				.put("counterparty2IdentifierType", ExistenceChecker.isSet((Boolean) o.getCounterparty2IdentifierType()))
				.put("counterparty2", ExistenceChecker.isSet((String) o.getCounterparty2()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommonPartiesReport", ValidationResult.ValidationType.ONLY_EXISTS, "CommonPartiesReport", path, "");
		}
		return failure("CommonPartiesReport", ValidationResult.ValidationType.ONLY_EXISTS, "CommonPartiesReport", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
