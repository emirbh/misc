package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityFrequencyType;
import fpml.consolidated.com.CommodityFx;
import fpml.consolidated.com.CommodityFxType;
import fpml.consolidated.com.Lag;
import fpml.consolidated.com.LagReference;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.BusinessDayConventionEnum;
import fpml.consolidated.fpmlenum.CommodityDayTypeEnum;
import fpml.consolidated.fpmlenum.DayOfWeekEnum;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFxOnlyExistsValidator implements ValidatorWithArg<CommodityFx, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFx> ValidationResult<CommodityFx> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("primaryRateSource", ExistenceChecker.isSet((InformationSource) o.getPrimaryRateSource()))
				.put("secondaryRateSource", ExistenceChecker.isSet((InformationSource) o.getSecondaryRateSource()))
				.put("fxType", ExistenceChecker.isSet((CommodityFxType) o.getFxType()))
				.put("averagingMethod", ExistenceChecker.isSet((AveragingMethodEnum) o.getAveragingMethod()))
				.put("fixingTime", ExistenceChecker.isSet((BusinessCenterTime) o.getFixingTime()))
				.put("fxObservationDates", ExistenceChecker.isSet((List<? extends AdjustableDates>) o.getFxObservationDates()))
				.put("dayType", ExistenceChecker.isSet((CommodityDayTypeEnum) o.getDayType()))
				.put("dayDistribution", ExistenceChecker.isSet((CommodityFrequencyType) o.getDayDistribution()))
				.put("dayCount", ExistenceChecker.isSet((Integer) o.getDayCount()))
				.put("dayOfWeek", ExistenceChecker.isSet((List<DayOfWeekEnum>) o.getDayOfWeek()))
				.put("dayNumber", ExistenceChecker.isSet((Integer) o.getDayNumber()))
				.put("businessDayConvention", ExistenceChecker.isSet((BusinessDayConventionEnum) o.getBusinessDayConvention()))
				.put("lag", ExistenceChecker.isSet((Lag) o.getLag()))
				.put("lagReference", ExistenceChecker.isSet((LagReference) o.getLagReference()))
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
			return success("CommodityFx", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityFx", path, "");
		}
		return failure("CommodityFx", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityFx", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
