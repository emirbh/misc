package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegReportingPackageInfo;
import fpml.consolidated.shared.IssuerTradeId;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegReportingPackageInfoOnlyExistsValidator implements ValidatorWithArg<RegReportingPackageInfo, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegReportingPackageInfo> ValidationResult<RegReportingPackageInfo> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("packageIdentifier", ExistenceChecker.isSet((IssuerTradeId) o.getPackageIdentifier()))
				.put("pacakageWithNonReportableComponent", ExistenceChecker.isSet((Boolean) o.getPacakageWithNonReportableComponent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegReportingPackageInfo", ValidationResult.ValidationType.ONLY_EXISTS, "RegReportingPackageInfo", path, "");
		}
		return failure("RegReportingPackageInfo", ValidationResult.ValidationType.ONLY_EXISTS, "RegReportingPackageInfo", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
