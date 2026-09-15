package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPhysicalQuantitySchedule;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductSizes;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingProductSizesOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingProductSizes, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingProductSizes> ValidationResult<RegulatoryReportingProductSizes> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notional", ExistenceChecker.isSet((List<? extends NonNegativeMoney>) o.getNotional()))
				.put("callAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getCallAmount()))
				.put("putAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getPutAmount()))
				.put("notionalSchedule", ExistenceChecker.isSet((List<? extends NonNegativeAmountSchedule>) o.getNotionalSchedule()))
				.put("quantity", ExistenceChecker.isSet((List<BigDecimal>) o.getQuantity()))
				.put("quantityFrequency", ExistenceChecker.isSet((List<BigDecimal>) o.getQuantityFrequency()))
				.put("quantitySchedule", ExistenceChecker.isSet((CommodityPhysicalQuantitySchedule) o.getQuantitySchedule()))
				.put("totalNotionalQuantity", ExistenceChecker.isSet((List<BigDecimal>) o.getTotalNotionalQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingProductSizes", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductSizes", path, "");
		}
		return failure("RegulatoryReportingProductSizes", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductSizes", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
