package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.StrikeQuoteBasisEnum;
import fpml.consolidated.fx.FxAsianFeature;
import fpml.consolidated.fx.FxAverageRateObservation;
import fpml.consolidated.fx.FxAverageRateObservationSchedule;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAsianFeatureOnlyExistsValidator implements ValidatorWithArg<FxAsianFeature, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAsianFeature> ValidationResult<FxAsianFeature> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("primaryRateSource", ExistenceChecker.isSet((InformationSource) o.getPrimaryRateSource()))
				.put("secondaryRateSource", ExistenceChecker.isSet((InformationSource) o.getSecondaryRateSource()))
				.put("fixingTime", ExistenceChecker.isSet((BusinessCenterTime) o.getFixingTime()))
				.put("observationSchedule", ExistenceChecker.isSet((FxAverageRateObservationSchedule) o.getObservationSchedule()))
				.put("rateObservation", ExistenceChecker.isSet((List<? extends FxAverageRateObservation>) o.getRateObservation()))
				.put("rateObservationQuoteBasis", ExistenceChecker.isSet((StrikeQuoteBasisEnum) o.getRateObservationQuoteBasis()))
				.put("payoutFormula", ExistenceChecker.isSet((String) o.getPayoutFormula()))
				.put("precision", ExistenceChecker.isSet((Integer) o.getPrecision()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAsianFeature", ValidationResult.ValidationType.ONLY_EXISTS, "FxAsianFeature", path, "");
		}
		return failure("FxAsianFeature", ValidationResult.ValidationType.ONLY_EXISTS, "FxAsianFeature", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
