package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductNonCDEFxDetails;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingProductNonCDEFxDetailsOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingProductNonCDEFxDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingProductNonCDEFxDetails> ValidationResult<RegulatoryReportingProductNonCDEFxDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxType", ExistenceChecker.isSet((String) o.getFxType()))
				.put("deliveryCurrency", ExistenceChecker.isSet((Currency) o.getDeliveryCurrency()))
				.put("deliveryCurrency2", ExistenceChecker.isSet((Currency) o.getDeliveryCurrency2()))
				.put("forwardExchangeRate", ExistenceChecker.isSet((BigDecimal) o.getForwardExchangeRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingProductNonCDEFxDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductNonCDEFxDetails", path, "");
		}
		return failure("RegulatoryReportingProductNonCDEFxDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductNonCDEFxDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
