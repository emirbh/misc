package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.ActualPrice;
import fpml.consolidated.asset.Commission;
import fpml.consolidated.asset.FxConversion;
import fpml.consolidated.asset.Price;
import fpml.consolidated.asset.QuotationCharacteristics;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.DeterminationMethod;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PriceOnlyExistsValidator implements ValidatorWithArg<Price, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Price> ValidationResult<Price> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commission", ExistenceChecker.isSet((Commission) o.getCommission()))
				.put("determinationMethod", ExistenceChecker.isSet((DeterminationMethod) o.getDeterminationMethod()))
				.put("grossPrice", ExistenceChecker.isSet((ActualPrice) o.getGrossPrice()))
				.put("netPrice", ExistenceChecker.isSet((ActualPrice) o.getNetPrice()))
				.put("accruedInterestPrice", ExistenceChecker.isSet((BigDecimal) o.getAccruedInterestPrice()))
				.put("fxConversion", ExistenceChecker.isSet((FxConversion) o.getFxConversion()))
				.put("amountRelativeTo", ExistenceChecker.isSet((AmountReference) o.getAmountRelativeTo()))
				.put("cleanNetPrice", ExistenceChecker.isSet((BigDecimal) o.getCleanNetPrice()))
				.put("quotationCharacteristics", ExistenceChecker.isSet((QuotationCharacteristics) o.getQuotationCharacteristics()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Price", ValidationResult.ValidationType.ONLY_EXISTS, "Price", path, "");
		}
		return failure("Price", ValidationResult.ValidationType.ONLY_EXISTS, "Price", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
