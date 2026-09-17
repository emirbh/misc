package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.AdjustableDateOrRelativeDateSequence;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.fpmlenum.FPVFinalPriceElectionFallbackEnum;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.shared.BusinessCenterTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityValuationOnlyExistsValidator implements ValidatorWithArg<EquityValuation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityValuation> ValidationResult<EquityValuation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("valuationDate", ExistenceChecker.isSet((AdjustableDateOrRelativeDateSequence) o.getValuationDate()))
				.put("valuationDates", ExistenceChecker.isSet((AdjustableRelativeOrPeriodicDates) o.getValuationDates()))
				.put("valuationTimeType", ExistenceChecker.isSet((TimeTypeEnum) o.getValuationTimeType()))
				.put("valuationTime", ExistenceChecker.isSet((BusinessCenterTime) o.getValuationTime()))
				.put("futuresPriceValuation", ExistenceChecker.isSet((Boolean) o.getFuturesPriceValuation()))
				.put("optionsPriceValuation", ExistenceChecker.isSet((Boolean) o.getOptionsPriceValuation()))
				.put("numberOfValuationDates", ExistenceChecker.isSet((Integer) o.getNumberOfValuationDates()))
				.put("dividendValuationDates", ExistenceChecker.isSet((AdjustableRelativeOrPeriodicDates) o.getDividendValuationDates()))
				.put("fPVFinalPriceElectionFallback", ExistenceChecker.isSet((FPVFinalPriceElectionFallbackEnum) o.getFPVFinalPriceElectionFallback()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityValuation", ValidationResult.ValidationType.ONLY_EXISTS, "EquityValuation", path, "");
		}
		return failure("EquityValuation", ValidationResult.ValidationType.ONLY_EXISTS, "EquityValuation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
