package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.CrossRate;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CrossRateOnlyExistsValidator implements ValidatorWithArg<CrossRate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CrossRate> ValidationResult<CrossRate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("currency1", ExistenceChecker.isSet((Currency) o.getCurrency1()))
				.put("currency2", ExistenceChecker.isSet((Currency) o.getCurrency2()))
				.put("quoteBasis", ExistenceChecker.isSet((QuoteBasisEnum) o.getQuoteBasis()))
				.put("rate", ExistenceChecker.isSet((BigDecimal) o.getRate()))
				.put("spotRate", ExistenceChecker.isSet((BigDecimal) o.getSpotRate()))
				.put("forwardPoints", ExistenceChecker.isSet((BigDecimal) o.getForwardPoints()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CrossRate", ValidationResult.ValidationType.ONLY_EXISTS, "CrossRate", path, "");
		}
		return failure("CrossRate", ValidationResult.ValidationType.ONLY_EXISTS, "CrossRate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
