package iso20022.dtcc.rds.harmonized.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.CdeSchedule1;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CdeSchedule1OnlyExistsValidator implements ValidatorWithArg<CdeSchedule1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CdeSchedule1> ValidationResult<CdeSchedule1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cdeEffectiveDateOfTheNotionalAmountLeg1", ExistenceChecker.isSet((Date) o.getCdeEffectiveDateOfTheNotionalAmountLeg1()))
				.put("cdeEndDateOfTheNotionalAmountLeg1", ExistenceChecker.isSet((Date) o.getCdeEndDateOfTheNotionalAmountLeg1()))
				.put("cdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1", ExistenceChecker.isSet((BigDecimal) o.getCdeNotionalAmountInEffectOnAssociatedEffectiveDateLeg1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CdeSchedule1", ValidationResult.ValidationType.ONLY_EXISTS, "CdeSchedule1", path, "");
		}
		return failure("CdeSchedule1", ValidationResult.ValidationType.ONLY_EXISTS, "CdeSchedule1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
