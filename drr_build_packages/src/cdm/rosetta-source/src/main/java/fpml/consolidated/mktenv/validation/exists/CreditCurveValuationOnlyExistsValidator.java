package fpml.consolidated.mktenv.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.mktenv.CreditCurveValuation;
import fpml.consolidated.mktenv.DefaultProbabilityCurve;
import fpml.consolidated.mktenv.TermCurve;
import fpml.consolidated.riskdef.QuotedAssetSet;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.IdentifiedDate;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditCurveValuationOnlyExistsValidator implements ValidatorWithArg<CreditCurveValuation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditCurveValuation> ValidationResult<CreditCurveValuation> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("defaultProbabilityCurve", ExistenceChecker.isSet((DefaultProbabilityCurve) o.getDefaultProbabilityCurve()))
				.put("recoveryRate", ExistenceChecker.isSet((BigDecimal) o.getRecoveryRate()))
				.put("recoveryRateCurve", ExistenceChecker.isSet((TermCurve) o.getRecoveryRateCurve()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditCurveValuation", ValidationResult.ValidationType.ONLY_EXISTS, "CreditCurveValuation", path, "");
		}
		return failure("CreditCurveValuation", ValidationResult.ValidationType.ONLY_EXISTS, "CreditCurveValuation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
