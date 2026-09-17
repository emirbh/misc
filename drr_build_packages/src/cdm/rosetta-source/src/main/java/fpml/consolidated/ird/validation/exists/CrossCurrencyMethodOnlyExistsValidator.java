package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.ird.CrossCurrencyMethod;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CrossCurrencyMethodOnlyExistsValidator implements ValidatorWithArg<CrossCurrencyMethod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CrossCurrencyMethod> ValidationResult<CrossCurrencyMethod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cashSettlementReferenceBanks", ExistenceChecker.isSet((CashSettlementReferenceBanks) o.getCashSettlementReferenceBanks()))
				.put("cashSettlementCurrency", ExistenceChecker.isSet((List<? extends Currency>) o.getCashSettlementCurrency()))
				.put("quotationRateType", ExistenceChecker.isSet((QuotationRateTypeEnum) o.getQuotationRateType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CrossCurrencyMethod", ValidationResult.ValidationType.ONLY_EXISTS, "CrossCurrencyMethod", path, "");
		}
		return failure("CrossCurrencyMethod", ValidationResult.ValidationType.ONLY_EXISTS, "CrossCurrencyMethod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
