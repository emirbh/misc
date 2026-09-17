package fpml.consolidated.mktenv.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.mktenv.DefaultProbabilityCurve;
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

public class DefaultProbabilityCurveOnlyExistsValidator implements ValidatorWithArg<DefaultProbabilityCurve, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DefaultProbabilityCurve> ValidationResult<DefaultProbabilityCurve> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("baseYieldCurve", ExistenceChecker.isSet((PricingStructureReference) o.getBaseYieldCurve()))
				.put("defaultProbabilities", ExistenceChecker.isSet((TermCurve) o.getDefaultProbabilities()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DefaultProbabilityCurve", ValidationResult.ValidationType.ONLY_EXISTS, "DefaultProbabilityCurve", path, "");
		}
		return failure("DefaultProbabilityCurve", ValidationResult.ValidationType.ONLY_EXISTS, "DefaultProbabilityCurve", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
