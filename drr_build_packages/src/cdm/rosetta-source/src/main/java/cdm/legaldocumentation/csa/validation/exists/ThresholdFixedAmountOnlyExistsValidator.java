package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.ThresholdFixedAmount;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ThresholdFixedAmountOnlyExistsValidator implements ValidatorWithArg<ThresholdFixedAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ThresholdFixedAmount> ValidationResult<ThresholdFixedAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((CounterpartyRoleEnum) o.getParty()))
				.put("amount", ExistenceChecker.isSet((Integer) o.getAmount()))
				.put("currency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getCurrency()))
				.put("amountIsInfinity", ExistenceChecker.isSet((Boolean) o.getAmountIsInfinity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ThresholdFixedAmount", ValidationResult.ValidationType.ONLY_EXISTS, "ThresholdFixedAmount", path, "");
		}
		return failure("ThresholdFixedAmount", ValidationResult.ValidationType.ONLY_EXISTS, "ThresholdFixedAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
