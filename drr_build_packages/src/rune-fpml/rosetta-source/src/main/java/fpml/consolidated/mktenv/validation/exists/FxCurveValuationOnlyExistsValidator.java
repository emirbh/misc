package fpml.consolidated.mktenv.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.mktenv.FxCurveValuation;
import fpml.consolidated.mktenv.FxRateSet;
import fpml.consolidated.mktenv.TermCurve;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.PricingStructureReference;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxCurveValuationOnlyExistsValidator implements ValidatorWithArg<FxCurveValuation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxCurveValuation> ValidationResult<FxCurveValuation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("definitionRef", ExistenceChecker.isSet((String) o.getDefinitionRef()))
				.put("objectReference", ExistenceChecker.isSet((AnyAssetReference) o.getObjectReference()))
				.put("valuationScenarioReference", ExistenceChecker.isSet((ValuationScenarioReference) o.getValuationScenarioReference()))
				.put("baseDate", ExistenceChecker.isSet((IdentifiedDate) o.getBaseDate()))
				.put("spotDate", ExistenceChecker.isSet((IdentifiedDate) o.getSpotDate()))
				.put("inputDataDate", ExistenceChecker.isSet((IdentifiedDate) o.getInputDataDate()))
				.put("endDate", ExistenceChecker.isSet((IdentifiedDate) o.getEndDate()))
				.put("buildDateTime", ExistenceChecker.isSet((ZonedDateTime) o.getBuildDateTime()))
				.put("settlementCurrencyYieldCurve", ExistenceChecker.isSet((PricingStructureReference) o.getSettlementCurrencyYieldCurve()))
				.put("forecastCurrencyYieldCurve", ExistenceChecker.isSet((PricingStructureReference) o.getForecastCurrencyYieldCurve()))
				.put("spotRate", ExistenceChecker.isSet((FxRateSet) o.getSpotRate()))
				.put("fxForwardCurve", ExistenceChecker.isSet((TermCurve) o.getFxForwardCurve()))
				.put("fxForwardPointsCurve", ExistenceChecker.isSet((TermCurve) o.getFxForwardPointsCurve()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxCurveValuation", ValidationResult.ValidationType.ONLY_EXISTS, "FxCurveValuation", path, "");
		}
		return failure("FxCurveValuation", ValidationResult.ValidationType.ONLY_EXISTS, "FxCurveValuation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
