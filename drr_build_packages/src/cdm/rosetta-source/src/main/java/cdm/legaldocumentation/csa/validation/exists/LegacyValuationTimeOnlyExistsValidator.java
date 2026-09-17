package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.legaldocumentation.csa.LegacyValuationTime;
import cdm.legaldocumentation.csa.ValuationTimeDayEnum;
import cdm.legaldocumentation.csa.ValuationTimeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LegacyValuationTimeOnlyExistsValidator implements ValidatorWithArg<LegacyValuationTime, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LegacyValuationTime> ValidationResult<LegacyValuationTime> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("day", ExistenceChecker.isSet((ValuationTimeDayEnum) o.getDay()))
				.put("location", ExistenceChecker.isSet((List<BusinessCenterEnum>) o.getLocation()))
				.put("time", ExistenceChecker.isSet((ValuationTimeEnum) o.getTime()))
				.put("hourminutetime", ExistenceChecker.isSet((LocalTime) o.getHourminutetime()))
				.put("timezone", ExistenceChecker.isSet((BusinessCenterEnum) o.getTimezone()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegacyValuationTime", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyValuationTime", path, "");
		}
		return failure("LegacyValuationTime", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyValuationTime", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
