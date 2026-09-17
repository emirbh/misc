package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalAttributeDecimal;
import fpml.consolidated.com.CoalAttributePercentage;
import fpml.consolidated.com.CoalStandardQuality;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CoalStandardQualityOnlyExistsValidator implements ValidatorWithArg<CoalStandardQuality, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CoalStandardQuality> ValidationResult<CoalStandardQuality> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("moisture", ExistenceChecker.isSet((CoalAttributePercentage) o.getMoisture()))
				.put("ash", ExistenceChecker.isSet((CoalAttributePercentage) o.getAsh()))
				.put("sulfur", ExistenceChecker.isSet((CoalAttributePercentage) o.getSulfur()))
				.put("sO2", ExistenceChecker.isSet((CoalAttributePercentage) o.getSO2()))
				.put("volatile", ExistenceChecker.isSet((CoalAttributePercentage) o.getVolatile()))
				.put("btUperLB", ExistenceChecker.isSet((CoalAttributeDecimal) o.getBtUperLB()))
				.put("topSize", ExistenceChecker.isSet((CoalAttributeDecimal) o.getTopSize()))
				.put("finesPassingScreen", ExistenceChecker.isSet((CoalAttributeDecimal) o.getFinesPassingScreen()))
				.put("grindability", ExistenceChecker.isSet((CoalAttributeDecimal) o.getGrindability()))
				.put("ashFusionTemperature", ExistenceChecker.isSet((CoalAttributeDecimal) o.getAshFusionTemperature()))
				.put("initialDeformation", ExistenceChecker.isSet((CoalAttributeDecimal) o.getInitialDeformation()))
				.put("softeningHeightWidth", ExistenceChecker.isSet((CoalAttributeDecimal) o.getSofteningHeightWidth()))
				.put("softeningHeightHalfWidth", ExistenceChecker.isSet((CoalAttributeDecimal) o.getSofteningHeightHalfWidth()))
				.put("fluid", ExistenceChecker.isSet((CoalAttributeDecimal) o.getFluid()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CoalStandardQuality", ValidationResult.ValidationType.ONLY_EXISTS, "CoalStandardQuality", path, "");
		}
		return failure("CoalStandardQuality", ValidationResult.ValidationType.ONLY_EXISTS, "CoalStandardQuality", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
