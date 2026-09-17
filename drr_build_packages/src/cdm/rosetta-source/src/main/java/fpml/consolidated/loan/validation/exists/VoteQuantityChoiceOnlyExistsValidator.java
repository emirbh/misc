package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.VoteQuantityChoice;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VoteQuantityChoiceOnlyExistsValidator implements ValidatorWithArg<VoteQuantityChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends VoteQuantityChoice> ValidationResult<VoteQuantityChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("voteCount", ExistenceChecker.isSet((Integer) o.getVoteCount()))
				.put("votePercent", ExistenceChecker.isSet((BigDecimal) o.getVotePercent()))
				.put("voteAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getVoteAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("VoteQuantityChoice", ValidationResult.ValidationType.ONLY_EXISTS, "VoteQuantityChoice", path, "");
		}
		return failure("VoteQuantityChoice", ValidationResult.ValidationType.ONLY_EXISTS, "VoteQuantityChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
