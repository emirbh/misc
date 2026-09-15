package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.ReportableCollateral;
import drr.regulation.common.ReportableInformation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportableCollateralOnlyExistsValidator implements ValidatorWithArg<ReportableCollateral, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportableCollateral> ValidationResult<ReportableCollateral> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("collateralDetails", ExistenceChecker.isSet((CollateralDetails) o.getCollateralDetails()))
				.put("reportableInformation", ExistenceChecker.isSet((ReportableInformation) o.getReportableInformation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportableCollateral", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableCollateral", path, "");
		}
		return failure("ReportableCollateral", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableCollateral", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
