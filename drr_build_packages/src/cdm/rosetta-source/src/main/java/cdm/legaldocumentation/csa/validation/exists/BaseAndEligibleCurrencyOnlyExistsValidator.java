package cdm.legaldocumentation.csa.validation.exists;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.legaldocumentation.csa.BaseAndEligibleCurrency;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BaseAndEligibleCurrencyOnlyExistsValidator implements ValidatorWithArg<BaseAndEligibleCurrency, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BaseAndEligibleCurrency> ValidationResult<BaseAndEligibleCurrency> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("baseCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getBaseCurrency()))
				.put("baseCurrencyTerminationCurrency", ExistenceChecker.isSet((Boolean) o.getBaseCurrencyTerminationCurrency()))
				.put("baseCurrencyOther", ExistenceChecker.isSet((FieldWithMetaString) o.getBaseCurrencyOther()))
				.put("eligibleCurrency", ExistenceChecker.isSet((List<ISOCurrencyCodeEnum>) o.getEligibleCurrency()))
				.put("eligibleCurrencyInclBaseCurrency", ExistenceChecker.isSet((Boolean) o.getEligibleCurrencyInclBaseCurrency()))
				.put("eligibleCurrencyOther", ExistenceChecker.isSet((FieldWithMetaString) o.getEligibleCurrencyOther()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BaseAndEligibleCurrency", ValidationResult.ValidationType.ONLY_EXISTS, "BaseAndEligibleCurrency", path, "");
		}
		return failure("BaseAndEligibleCurrency", ValidationResult.ValidationType.ONLY_EXISTS, "BaseAndEligibleCurrency", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
