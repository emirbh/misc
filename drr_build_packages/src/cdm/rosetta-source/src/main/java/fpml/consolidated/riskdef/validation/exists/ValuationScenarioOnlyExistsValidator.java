package fpml.consolidated.riskdef.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.MarketReference;
import fpml.consolidated.riskdef.PricingInputReplacement;
import fpml.consolidated.riskdef.PricingParameterShift;
import fpml.consolidated.riskdef.ValuationScenario;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ValuationScenarioOnlyExistsValidator implements ValidatorWithArg<ValuationScenario, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ValuationScenario> ValidationResult<ValuationScenario> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("valuationDate", ExistenceChecker.isSet((IdentifiedDate) o.getValuationDate()))
				.put("marketReference", ExistenceChecker.isSet((MarketReference) o.getMarketReference()))
				.put("shift", ExistenceChecker.isSet((List<? extends PricingParameterShift>) o.getShift()))
				.put("replacement", ExistenceChecker.isSet((List<? extends PricingInputReplacement>) o.getReplacement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ValuationScenario", ValidationResult.ValidationType.ONLY_EXISTS, "ValuationScenario", path, "");
		}
		return failure("ValuationScenario", ValidationResult.ValidationType.ONLY_EXISTS, "ValuationScenario", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
