package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductDates;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingProductDatesOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingProductDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingProductDates> ValidationResult<RegulatoryReportingProductDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet((List<ZonedDateTime>) o.getEffectiveDate()))
				.put("contractExpirationDate", ExistenceChecker.isSet((List<ZonedDateTime>) o.getContractExpirationDate()))
				.put("finalContractualSettlementDate", ExistenceChecker.isSet((List<ZonedDateTime>) o.getFinalContractualSettlementDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingProductDates", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductDates", path, "");
		}
		return failure("RegulatoryReportingProductDates", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
