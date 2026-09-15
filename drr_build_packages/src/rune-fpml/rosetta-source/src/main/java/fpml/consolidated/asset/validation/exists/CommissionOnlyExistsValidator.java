package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Commission;
import fpml.consolidated.fpmlenum.CommissionDenominationEnum;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxRate;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommissionOnlyExistsValidator implements ValidatorWithArg<Commission, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Commission> ValidationResult<Commission> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commissionDenomination", ExistenceChecker.isSet((CommissionDenominationEnum) o.getCommissionDenomination()))
				.put("commissionAmount", ExistenceChecker.isSet((BigDecimal) o.getCommissionAmount()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("commissionPerTrade", ExistenceChecker.isSet((BigDecimal) o.getCommissionPerTrade()))
				.put("fxRate", ExistenceChecker.isSet((List<? extends FxRate>) o.getFxRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Commission", ValidationResult.ValidationType.ONLY_EXISTS, "Commission", path, "");
		}
		return failure("Commission", ValidationResult.ValidationType.ONLY_EXISTS, "Commission", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
