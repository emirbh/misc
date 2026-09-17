package fpml.consolidated.option.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.CreditEventNotice;
import fpml.consolidated.option.shared.NotifyingParty;
import fpml.consolidated.option.shared.PubliclyAvailableInformation;
import fpml.consolidated.shared.BusinessCenter;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditEventNoticeOnlyExistsValidator implements ValidatorWithArg<CreditEventNotice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditEventNotice> ValidationResult<CreditEventNotice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notifyingParty", ExistenceChecker.isSet((NotifyingParty) o.getNotifyingParty()))
				.put("businessCenter", ExistenceChecker.isSet((BusinessCenter) o.getBusinessCenter()))
				.put("publiclyAvailableInformation", ExistenceChecker.isSet((PubliclyAvailableInformation) o.getPubliclyAvailableInformation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditEventNotice", ValidationResult.ValidationType.ONLY_EXISTS, "CreditEventNotice", path, "");
		}
		return failure("CreditEventNotice", ValidationResult.ValidationType.ONLY_EXISTS, "CreditEventNotice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
