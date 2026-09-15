package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.ReportingSide;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.RegimeReportingSide;
import drr.regulation.common.SupervisoryBodyEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegimeReportingSideOnlyExistsValidator implements ValidatorWithArg<RegimeReportingSide, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegimeReportingSide> ValidationResult<RegimeReportingSide> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("regimeName", ExistenceChecker.isSet((RegimeNameEnum) o.getRegimeName()))
				.put("supervisoryBody", ExistenceChecker.isSet((SupervisoryBodyEnum) o.getSupervisoryBody()))
				.put("reportingSide", ExistenceChecker.isSet((ReportingSide) o.getReportingSide()))
				.put("delegatedReportingSide", ExistenceChecker.isSet((ReportingSide) o.getDelegatedReportingSide()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegimeReportingSide", ValidationResult.ValidationType.ONLY_EXISTS, "RegimeReportingSide", path, "");
		}
		return failure("RegimeReportingSide", ValidationResult.ValidationType.ONLY_EXISTS, "RegimeReportingSide", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
