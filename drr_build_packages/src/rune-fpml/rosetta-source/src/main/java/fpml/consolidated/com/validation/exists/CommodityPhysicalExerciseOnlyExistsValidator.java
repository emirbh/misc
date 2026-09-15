package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPhysicalAmericanExercise;
import fpml.consolidated.com.CommodityPhysicalEuropeanExercise;
import fpml.consolidated.com.CommodityPhysicalExercise;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPhysicalExerciseOnlyExistsValidator implements ValidatorWithArg<CommodityPhysicalExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPhysicalExercise> ValidationResult<CommodityPhysicalExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("americanExercise", ExistenceChecker.isSet((CommodityPhysicalAmericanExercise) o.getAmericanExercise()))
				.put("europeanExercise", ExistenceChecker.isSet((CommodityPhysicalEuropeanExercise) o.getEuropeanExercise()))
				.put("automaticExercise", ExistenceChecker.isSet((Boolean) o.getAutomaticExercise()))
				.put("writtenConfirmation", ExistenceChecker.isSet((Boolean) o.getWrittenConfirmation()))
				.put("clearingInstructions", ExistenceChecker.isSet((SwaptionPhysicalSettlement) o.getClearingInstructions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPhysicalExercise", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityPhysicalExercise", path, "");
		}
		return failure("CommodityPhysicalExercise", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityPhysicalExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
