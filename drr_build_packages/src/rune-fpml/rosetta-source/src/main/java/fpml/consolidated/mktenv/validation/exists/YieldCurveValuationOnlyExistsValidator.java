package fpml.consolidated.mktenv.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.mktenv.ForwardRateCurve;
import fpml.consolidated.mktenv.TermCurve;
import fpml.consolidated.mktenv.YieldCurveValuation;
import fpml.consolidated.mktenv.ZeroRateCurve;
import fpml.consolidated.riskdef.QuotedAssetSet;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class YieldCurveValuationOnlyExistsValidator implements ValidatorWithArg<YieldCurveValuation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends YieldCurveValuation> ValidationResult<YieldCurveValuation> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("inputs", ExistenceChecker.isSet((QuotedAssetSet) o.getInputs()))
				.put("zeroCurve", ExistenceChecker.isSet((ZeroRateCurve) o.getZeroCurve()))
				.put("forwardCurve", ExistenceChecker.isSet((List<? extends ForwardRateCurve>) o.getForwardCurve()))
				.put("discountFactorCurve", ExistenceChecker.isSet((TermCurve) o.getDiscountFactorCurve()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("YieldCurveValuation", ValidationResult.ValidationType.ONLY_EXISTS, "YieldCurveValuation", path, "");
		}
		return failure("YieldCurveValuation", ValidationResult.ValidationType.ONLY_EXISTS, "YieldCurveValuation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
