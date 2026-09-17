package fpml.consolidated.riskdef.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.riskdef.AssetOrTermPointOrPricingStructureReference;
import fpml.consolidated.riskdef.DerivativeCalculationProcedure;
import fpml.consolidated.riskdef.PricingParameterDerivative;
import fpml.consolidated.riskdef.TermPointReference;
import fpml.consolidated.riskdef.ValuationReference;
import fpml.consolidated.shared.PricingStructureReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PricingParameterDerivativeOnlyExistsValidator implements ValidatorWithArg<PricingParameterDerivative, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PricingParameterDerivative> ValidationResult<PricingParameterDerivative> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("parameterReference", ExistenceChecker.isSet((AssetOrTermPointOrPricingStructureReference) o.getParameterReference()))
				.put("assetReference", ExistenceChecker.isSet((AssetReference) o.getAssetReference()))
				.put("termPointReference", ExistenceChecker.isSet((TermPointReference) o.getTermPointReference()))
				.put("pricingStructureReference", ExistenceChecker.isSet((PricingStructureReference) o.getPricingStructureReference()))
				.put("inputDateReference", ExistenceChecker.isSet((List<? extends ValuationReference>) o.getInputDateReference()))
				.put("calculationProcedure", ExistenceChecker.isSet((DerivativeCalculationProcedure) o.getCalculationProcedure()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PricingParameterDerivative", ValidationResult.ValidationType.ONLY_EXISTS, "PricingParameterDerivative", path, "");
		}
		return failure("PricingParameterDerivative", ValidationResult.ValidationType.ONLY_EXISTS, "PricingParameterDerivative", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
