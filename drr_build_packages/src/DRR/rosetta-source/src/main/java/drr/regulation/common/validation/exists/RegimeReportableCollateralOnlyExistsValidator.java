package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.RegimeReportableCollateral;
import drr.regulation.common.RegimeReportingSide;
import drr.regulation.common.ReportableInformation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegimeReportableCollateralOnlyExistsValidator implements ValidatorWithArg<RegimeReportableCollateral, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegimeReportableCollateral> ValidationResult<RegimeReportableCollateral> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("collateralDetails", ExistenceChecker.isSet((CollateralDetails) o.getCollateralDetails()))
				.put("reportableInformation", ExistenceChecker.isSet((ReportableInformation) o.getReportableInformation()))
				.put("regimeReportingSide", ExistenceChecker.isSet((List<? extends RegimeReportingSide>) o.getRegimeReportingSide()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegimeReportableCollateral", ValidationResult.ValidationType.ONLY_EXISTS, "RegimeReportableCollateral", path, "");
		}
		return failure("RegimeReportableCollateral", ValidationResult.ValidationType.ONLY_EXISTS, "RegimeReportableCollateral", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
