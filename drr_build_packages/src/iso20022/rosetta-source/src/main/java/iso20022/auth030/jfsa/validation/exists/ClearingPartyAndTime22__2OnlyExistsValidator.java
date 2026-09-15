package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.ClearingAccountType4Code;
import iso20022.auth030.jfsa.ClearingPartyAndTime22__2;
import iso20022.auth030.jfsa.OrganisationIdentification15Choice__1;
import iso20022.auth030.jfsa.UniqueTransactionIdentifier2Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ClearingPartyAndTime22__2OnlyExistsValidator implements ValidatorWithArg<ClearingPartyAndTime22__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ClearingPartyAndTime22__2> ValidationResult<ClearingPartyAndTime22__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ccp", ExistenceChecker.isSet((OrganisationIdentification15Choice__1) o.getCcp()))
				.put("orgnlIdr", ExistenceChecker.isSet((UniqueTransactionIdentifier2Choice__1) o.getOrgnlIdr()))
				.put("orgnlTradRpstryIdr", ExistenceChecker.isSet((OrganisationIdentification15Choice__1) o.getOrgnlTradRpstryIdr()))
				.put("clrAcctOrgn", ExistenceChecker.isSet((ClearingAccountType4Code) o.getClrAcctOrgn()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ClearingPartyAndTime22__2", ValidationResult.ValidationType.ONLY_EXISTS, "ClearingPartyAndTime22__2", path, "");
		}
		return failure("ClearingPartyAndTime22__2", ValidationResult.ValidationType.ONLY_EXISTS, "ClearingPartyAndTime22__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
