package fpml.consolidated.reg.fpmlreporting.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.reg.fpmlreporting.shared.PublicDissemination;
import fpml.consolidated.reg.fpmlreporting.shared.RegulationName;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatorReportingStatusCode;
import fpml.consolidated.reg.fpmlreporting.shared.ReportingStatus;
import fpml.consolidated.shared.ReportingRegimeName;
import fpml.consolidated.shared.SupervisoryBody;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportingStatusOnlyExistsValidator implements ValidatorWithArg<ReportingStatus, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportingStatus> ValidationResult<ReportingStatus> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("regimeName", ExistenceChecker.isSet((ReportingRegimeName) o.getRegimeName()))
				.put("supervisoryBody", ExistenceChecker.isSet((SupervisoryBody) o.getSupervisoryBody()))
				.put("regulation", ExistenceChecker.isSet((RegulationName) o.getRegulation()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("reportingPurpose", ExistenceChecker.isSet((List<? extends ReportingPurpose>) o.getReportingPurpose()))
				.put("status", ExistenceChecker.isSet((RegulatorReportingStatusCode) o.getStatus()))
				.put("publicDissemination", ExistenceChecker.isSet((List<? extends PublicDissemination>) o.getPublicDissemination()))
				.put("reason", ExistenceChecker.isSet((List<? extends Reason>) o.getReason()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportingStatus", ValidationResult.ValidationType.ONLY_EXISTS, "ReportingStatus", path, "");
		}
		return failure("ReportingStatus", ValidationResult.ValidationType.ONLY_EXISTS, "ReportingStatus", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
