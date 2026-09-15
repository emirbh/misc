package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationASIC_2013;
import fpml.consolidated.shared.ActionType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryClassificationASIC_2013OnlyExistsValidator implements ValidatorWithArg<RegulatoryClassificationASIC_2013, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryClassificationASIC_2013> ValidationResult<RegulatoryClassificationASIC_2013> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("supervisoryBody", ExistenceChecker.isSet((List<String>) o.getSupervisoryBody()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("reportingPurpose", ExistenceChecker.isSet((List<? extends ReportingPurpose>) o.getReportingPurpose()))
				.put("interAffiliate", ExistenceChecker.isSet((Boolean) o.getInterAffiliate()))
				.put("actionType", ExistenceChecker.isSet((ActionType) o.getActionType()))
				.put("isAccountingHedge", ExistenceChecker.isSet((Boolean) o.getIsAccountingHedge()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryClassificationASIC_2013", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationASIC_2013", path, "");
		}
		return failure("RegulatoryClassificationASIC_2013", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryClassificationASIC_2013", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
