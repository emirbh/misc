package iso20022.dtcc.rds.harmonized.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.CdePriceSchedule;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CdePriceScheduleOnlyExistsValidator implements ValidatorWithArg<CdePriceSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CdePriceSchedule> ValidationResult<CdePriceSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cdeUnadjustedEffectiveDateOfPrice", ExistenceChecker.isSet((Date) o.getCdeUnadjustedEffectiveDateOfPrice()))
				.put("cdeUnadjustedEndDateOfPrice", ExistenceChecker.isSet((Date) o.getCdeUnadjustedEndDateOfPrice()))
				.put("cdePrice", ExistenceChecker.isSet((BigDecimal) o.getCdePrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CdePriceSchedule", ValidationResult.ValidationType.ONLY_EXISTS, "CdePriceSchedule", path, "");
		}
		return failure("CdePriceSchedule", ValidationResult.ValidationType.ONLY_EXISTS, "CdePriceSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
