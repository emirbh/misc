package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductPriceTerms;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Schedule;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingProductPriceTermsOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingProductPriceTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingProductPriceTerms> ValidationResult<RegulatoryReportingProductPriceTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedRate", ExistenceChecker.isSet((List<BigDecimal>) o.getFixedRate()))
				.put("fixedRateNotation", ExistenceChecker.isSet((List<String>) o.getFixedRateNotation()))
				.put("fixedRateSchedule", ExistenceChecker.isSet((List<? extends Schedule>) o.getFixedRateSchedule()))
				.put("spread", ExistenceChecker.isSet((List<BigDecimal>) o.getSpread()))
				.put("spreadCurrency", ExistenceChecker.isSet((List<? extends Currency>) o.getSpreadCurrency()))
				.put("spreadNotation", ExistenceChecker.isSet((List<String>) o.getSpreadNotation()))
				.put("strikePrice", ExistenceChecker.isSet((List<BigDecimal>) o.getStrikePrice()))
				.put("strikePriceNotation", ExistenceChecker.isSet((List<String>) o.getStrikePriceNotation()))
				.put("strikePriceSchedule", ExistenceChecker.isSet((List<? extends Schedule>) o.getStrikePriceSchedule()))
				.put("exchangeRate", ExistenceChecker.isSet((List<? extends ExchangeRate>) o.getExchangeRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingProductPriceTerms", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductPriceTerms", path, "");
		}
		return failure("RegulatoryReportingProductPriceTerms", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductPriceTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
