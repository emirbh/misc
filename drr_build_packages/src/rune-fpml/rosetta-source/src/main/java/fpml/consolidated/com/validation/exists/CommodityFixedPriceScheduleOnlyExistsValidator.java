package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import fpml.consolidated.com.CommoditySettlementPeriodsPriceSchedule;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFixedPriceScheduleOnlyExistsValidator implements ValidatorWithArg<CommodityFixedPriceSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFixedPriceSchedule> ValidationResult<CommodityFixedPriceSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedPriceStep", ExistenceChecker.isSet((List<? extends CommodityFixedPrice>) o.getFixedPriceStep()))
				.put("worldscaleRateStep", ExistenceChecker.isSet((List<BigDecimal>) o.getWorldscaleRateStep()))
				.put("contractRateStep", ExistenceChecker.isSet((List<? extends NonNegativeMoney>) o.getContractRateStep()))
				.put("settlementPeriodsPriceSchedule", ExistenceChecker.isSet((List<? extends CommoditySettlementPeriodsPriceSchedule>) o.getSettlementPeriodsPriceSchedule()))
				.put("calculationPeriodsReference", ExistenceChecker.isSet((CalculationPeriodsReference) o.getCalculationPeriodsReference()))
				.put("calculationPeriodsScheduleReference", ExistenceChecker.isSet((CalculationPeriodsScheduleReference) o.getCalculationPeriodsScheduleReference()))
				.put("calculationPeriodsDatesReference", ExistenceChecker.isSet((CalculationPeriodsDatesReference) o.getCalculationPeriodsDatesReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityFixedPriceSchedule", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityFixedPriceSchedule", path, "");
		}
		return failure("CommodityFixedPriceSchedule", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityFixedPriceSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
