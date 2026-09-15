package drr.base.trade.price.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.price.PriceFormat;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PriceFormatOnlyExistsValidator implements ValidatorWithArg<PriceFormat, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PriceFormat> ValidationResult<PriceFormat> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("monetary", ExistenceChecker.isSet((BigDecimal) o.getMonetary()))
				.put("decimal", ExistenceChecker.isSet((BigDecimal) o.getDecimal()))
				.put("percentage", ExistenceChecker.isSet((BigDecimal) o.getPercentage()))
				.put("basis", ExistenceChecker.isSet((BigDecimal) o.getBasis()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PriceFormat", ValidationResult.ValidationType.ONLY_EXISTS, "PriceFormat", path, "");
		}
		return failure("PriceFormat", ValidationResult.ValidationType.ONLY_EXISTS, "PriceFormat", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
