package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityPayRelativeToEvent;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.fpmlenum.CommodityPayRelativeToEnum;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateOffset;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityRelativePaymentDatesOnlyExistsValidator implements ValidatorWithArg<CommodityRelativePaymentDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityRelativePaymentDates> ValidationResult<CommodityRelativePaymentDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payRelativeTo", ExistenceChecker.isSet((CommodityPayRelativeToEnum) o.getPayRelativeTo()))
				.put("payRelativeToEvent", ExistenceChecker.isSet((CommodityPayRelativeToEvent) o.getPayRelativeToEvent()))
				.put("calculationPeriodsReference", ExistenceChecker.isSet((CalculationPeriodsReference) o.getCalculationPeriodsReference()))
				.put("calculationPeriodsScheduleReference", ExistenceChecker.isSet((CalculationPeriodsScheduleReference) o.getCalculationPeriodsScheduleReference()))
				.put("calculationPeriodsDatesReference", ExistenceChecker.isSet((CalculationPeriodsDatesReference) o.getCalculationPeriodsDatesReference()))
				.put("paymentDaysOffset", ExistenceChecker.isSet((DateOffset) o.getPaymentDaysOffset()))
				.put("businessCentersReference", ExistenceChecker.isSet((BusinessCentersReference) o.getBusinessCentersReference()))
				.put("businessCenters", ExistenceChecker.isSet((BusinessCenters) o.getBusinessCenters()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityRelativePaymentDates", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityRelativePaymentDates", path, "");
		}
		return failure("CommodityRelativePaymentDates", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityRelativePaymentDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
