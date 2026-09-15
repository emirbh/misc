package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductSettlementDetails;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.Currency;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingProductSettlementDetailsOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingProductSettlementDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingProductSettlementDetails> ValidationResult<RegulatoryReportingProductSettlementDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementMethod", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementMethod()))
				.put("settlementCurrency", ExistenceChecker.isSet((Currency) o.getSettlementCurrency()))
				.put("settlementLocation", ExistenceChecker.isSet((BusinessCenter) o.getSettlementLocation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingProductSettlementDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductSettlementDetails", path, "");
		}
		return failure("RegulatoryReportingProductSettlementDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductSettlementDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
