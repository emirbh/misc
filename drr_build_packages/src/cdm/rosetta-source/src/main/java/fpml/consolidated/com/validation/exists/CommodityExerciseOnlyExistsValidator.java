package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityAmericanExercise;
import fpml.consolidated.com.CommodityEuropeanExercise;
import fpml.consolidated.com.CommodityExercise;
import fpml.consolidated.com.CommodityFx;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.IdentifiedCurrency;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityExerciseOnlyExistsValidator implements ValidatorWithArg<CommodityExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityExercise> ValidationResult<CommodityExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("americanExercise", ExistenceChecker.isSet((CommodityAmericanExercise) o.getAmericanExercise()))
				.put("europeanExercise", ExistenceChecker.isSet((CommodityEuropeanExercise) o.getEuropeanExercise()))
				.put("automaticExercise", ExistenceChecker.isSet((Boolean) o.getAutomaticExercise()))
				.put("writtenConfirmation", ExistenceChecker.isSet((Boolean) o.getWrittenConfirmation()))
				.put("settlementCurrency", ExistenceChecker.isSet((IdentifiedCurrency) o.getSettlementCurrency()))
				.put("fx", ExistenceChecker.isSet((CommodityFx) o.getFx()))
				.put("conversionFactor", ExistenceChecker.isSet((BigDecimal) o.getConversionFactor()))
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
			return success("CommodityExercise", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityExercise", path, "");
		}
		return failure("CommodityExercise", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
