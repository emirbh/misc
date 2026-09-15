package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.DividendPayout;
import fpml.consolidated.asset.PendingPayment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DividendPayoutOnlyExistsValidator implements ValidatorWithArg<DividendPayout, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DividendPayout> ValidationResult<DividendPayout> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dividendPayoutRatio", ExistenceChecker.isSet((BigDecimal) o.getDividendPayoutRatio()))
				.put("dividendPayoutRatioCash", ExistenceChecker.isSet((BigDecimal) o.getDividendPayoutRatioCash()))
				.put("dividendPayoutRatioNonCash", ExistenceChecker.isSet((BigDecimal) o.getDividendPayoutRatioNonCash()))
				.put("dividendPayoutConditions", ExistenceChecker.isSet((String) o.getDividendPayoutConditions()))
				.put("dividendPayment", ExistenceChecker.isSet((List<? extends PendingPayment>) o.getDividendPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DividendPayout", ValidationResult.ValidationType.ONLY_EXISTS, "DividendPayout", path, "");
		}
		return failure("DividendPayout", ValidationResult.ValidationType.ONLY_EXISTS, "DividendPayout", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
