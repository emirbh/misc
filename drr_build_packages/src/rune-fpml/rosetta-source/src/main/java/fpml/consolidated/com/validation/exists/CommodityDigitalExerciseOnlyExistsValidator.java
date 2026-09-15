package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityAmericanExercise;
import fpml.consolidated.com.CommodityDigitalExercise;
import fpml.consolidated.com.CommodityEuropeanExercise;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityDigitalExerciseOnlyExistsValidator implements ValidatorWithArg<CommodityDigitalExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityDigitalExercise> ValidationResult<CommodityDigitalExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("americanExercise", ExistenceChecker.isSet((CommodityAmericanExercise) o.getAmericanExercise()))
				.put("europeanExercise", ExistenceChecker.isSet((CommodityEuropeanExercise) o.getEuropeanExercise()))
				.put("automaticExercise", ExistenceChecker.isSet((Boolean) o.getAutomaticExercise()))
				.put("writtenConfirmation", ExistenceChecker.isSet((Boolean) o.getWrittenConfirmation()))
				.put("relativePaymentDates", ExistenceChecker.isSet((CommodityRelativePaymentDates) o.getRelativePaymentDates()))
				.put("paymentDates", ExistenceChecker.isSet((AdjustableDatesOrRelativeDateOffset) o.getPaymentDates()))
				.put("masterAgreementPaymentDates", ExistenceChecker.isSet((Boolean) o.getMasterAgreementPaymentDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityDigitalExercise", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityDigitalExercise", path, "");
		}
		return failure("CommodityDigitalExercise", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityDigitalExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
