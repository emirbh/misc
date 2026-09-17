package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.DatedAsOfDate;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DatedAsOfDateOnlyExistsValidator implements ValidatorWithArg<DatedAsOfDate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DatedAsOfDate> ValidationResult<DatedAsOfDate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("csaDatedAsOfDate", ExistenceChecker.isSet((Date) o.getCsaDatedAsOfDate()))
				.put("masterAgreementDatedAsOfDate", ExistenceChecker.isSet((Date) o.getMasterAgreementDatedAsOfDate()))
				.put("csaMadeOn", ExistenceChecker.isSet((Date) o.getCsaMadeOn()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DatedAsOfDate", ValidationResult.ValidationType.ONLY_EXISTS, "DatedAsOfDate", path, "");
		}
		return failure("DatedAsOfDate", ValidationResult.ValidationType.ONLY_EXISTS, "DatedAsOfDate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
