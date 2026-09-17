package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.CsaTypeEnum;
import fpml.consolidated.ird.MidMarketValuationMethod;
import fpml.consolidated.shared.BenchmarkRate;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MidMarketValuationMethodOnlyExistsValidator implements ValidatorWithArg<MidMarketValuationMethod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MidMarketValuationMethod> ValidationResult<MidMarketValuationMethod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cashSettlementCurrency", ExistenceChecker.isSet((List<? extends Currency>) o.getCashSettlementCurrency()))
				.put("applicableCsa", ExistenceChecker.isSet((CsaTypeEnum) o.getApplicableCsa()))
				.put("cashSettlementReferenceBanks", ExistenceChecker.isSet((CashSettlementReferenceBanks) o.getCashSettlementReferenceBanks()))
				.put("cashCollateralCurrency", ExistenceChecker.isSet((Currency) o.getCashCollateralCurrency()))
				.put("cashCollateralInterestRate", ExistenceChecker.isSet((BenchmarkRate) o.getCashCollateralInterestRate()))
				.put("agreedDiscountRate", ExistenceChecker.isSet((BenchmarkRate) o.getAgreedDiscountRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MidMarketValuationMethod", ValidationResult.ValidationType.ONLY_EXISTS, "MidMarketValuationMethod", path, "");
		}
		return failure("MidMarketValuationMethod", ValidationResult.ValidationType.ONLY_EXISTS, "MidMarketValuationMethod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
