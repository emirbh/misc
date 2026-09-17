package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.LegacyValuationDate;
import cdm.legaldocumentation.csa.ValuationDateDateEnum;
import cdm.legaldocumentation.csa.ValuationDateDayEnum;
import cdm.legaldocumentation.csa.ValuationDateFrequencyEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LegacyValuationDateOnlyExistsValidator implements ValidatorWithArg<LegacyValuationDate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LegacyValuationDate> ValidationResult<LegacyValuationDate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("date", ExistenceChecker.isSet((ValuationDateDateEnum) o.getDate()))
				.put("day", ExistenceChecker.isSet((ValuationDateDayEnum) o.getDay()))
				.put("calendarDay", ExistenceChecker.isSet((BigDecimal) o.getCalendarDay()))
				.put("frequency", ExistenceChecker.isSet((ValuationDateFrequencyEnum) o.getFrequency()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegacyValuationDate", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyValuationDate", path, "");
		}
		return failure("LegacyValuationDate", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyValuationDate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
