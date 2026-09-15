package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ExtendibleProvision;
import fpml.consolidated.ird.ExtendibleProvisionAdjustedDates;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExtendibleProvisionOnlyExistsValidator implements ValidatorWithArg<ExtendibleProvision, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExtendibleProvision> ValidationResult<ExtendibleProvision> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("buyerAccountReference", ExistenceChecker.isSet((AccountReference) o.getBuyerAccountReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("sellerAccountReference", ExistenceChecker.isSet((AccountReference) o.getSellerAccountReference()))
				.put("exercise", ExistenceChecker.isSet((Exercise) o.getExercise()))
				.put("exerciseNotice", ExistenceChecker.isSet((ExerciseNotice) o.getExerciseNotice()))
				.put("followUpConfirmation", ExistenceChecker.isSet((Boolean) o.getFollowUpConfirmation()))
				.put("extendibleProvisionAdjustedDates", ExistenceChecker.isSet((ExtendibleProvisionAdjustedDates) o.getExtendibleProvisionAdjustedDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExtendibleProvision", ValidationResult.ValidationType.ONLY_EXISTS, "ExtendibleProvision", path, "");
		}
		return failure("ExtendibleProvision", ValidationResult.ValidationType.ONLY_EXISTS, "ExtendibleProvision", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
