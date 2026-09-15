package drr.regulation.hkma.rewrite.trade.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.hkma.rewrite.trade.NotionalQuantityScheduleLeg1Report;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NotionalQuantityScheduleLeg1ReportOnlyExistsValidator implements ValidatorWithArg<NotionalQuantityScheduleLeg1Report, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NotionalQuantityScheduleLeg1Report> ValidationResult<NotionalQuantityScheduleLeg1Report> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("endDate", ExistenceChecker.isSet((Date) o.getEndDate()))
				.put("quantity", ExistenceChecker.isSet((BigDecimal) o.getQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NotionalQuantityScheduleLeg1Report", ValidationResult.ValidationType.ONLY_EXISTS, "NotionalQuantityScheduleLeg1Report", path, "");
		}
		return failure("NotionalQuantityScheduleLeg1Report", ValidationResult.ValidationType.ONLY_EXISTS, "NotionalQuantityScheduleLeg1Report", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
