package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ReportingLevel;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationSFTR_2019;
import fpml.consolidated.shared.ActionType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryClassificationSFTR_2019OnlyExistsValidator implements ValidatorWithArg<RegulatoryClassificationSFTR_2019, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryClassificationSFTR_2019> ValidationResult<RegulatoryClassificationSFTR_2019> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("reportingPurpose", ExistenceChecker.isSet((List<? extends ReportingPurpose>) o.getReportingPurpose()))
				.put("reportingLevel", ExistenceChecker.isSet((ReportingLevel) o.getReportingLevel()))
				.put("actionType", ExistenceChecker.isSet((ActionType) o.getActionType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryClassificationSFTR_2019", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationSFTR_2019", path, "");
		}
		return failure("RegulatoryClassificationSFTR_2019", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationSFTR_2019", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
