package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractTradingAccrual;
import fpml.consolidated.loan.AccrualPeriod;
import fpml.consolidated.shared.Money;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AbstractTradingAccrualOnlyExistsValidator implements ValidatorWithArg<AbstractTradingAccrual, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AbstractTradingAccrual> ValidationResult<AbstractTradingAccrual> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amount", ExistenceChecker.isSet((Money) o.getAmount()))
				.put("accrualPeriod", ExistenceChecker.isSet((List<? extends AccrualPeriod>) o.getAccrualPeriod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AbstractTradingAccrual", ValidationResult.ValidationType.ONLY_EXISTS, "AbstractTradingAccrual", path, "");
		}
		return failure("AbstractTradingAccrual", ValidationResult.ValidationType.ONLY_EXISTS, "AbstractTradingAccrual", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
