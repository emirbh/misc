package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.PrincipalExchangeAmount;
import fpml.consolidated.eq.shared.PrincipalExchangeDescriptions;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PrincipalExchangeDescriptionsOnlyExistsValidator implements ValidatorWithArg<PrincipalExchangeDescriptions, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PrincipalExchangeDescriptions> ValidationResult<PrincipalExchangeDescriptions> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("principalExchangeAmount", ExistenceChecker.isSet((PrincipalExchangeAmount) o.getPrincipalExchangeAmount()))
				.put("principalExchangeDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getPrincipalExchangeDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PrincipalExchangeDescriptions", ValidationResult.ValidationType.ONLY_EXISTS, "PrincipalExchangeDescriptions", path, "");
		}
		return failure("PrincipalExchangeDescriptions", ValidationResult.ValidationType.ONLY_EXISTS, "PrincipalExchangeDescriptions", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
