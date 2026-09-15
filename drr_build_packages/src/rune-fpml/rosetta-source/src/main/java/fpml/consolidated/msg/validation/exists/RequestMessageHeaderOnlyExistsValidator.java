package fpml.consolidated.msg.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignatureType;
import fpml.consolidated.msg.ImplementationSpecification;
import fpml.consolidated.msg.MessageAddress;
import fpml.consolidated.msg.MessageId;
import fpml.consolidated.msg.PartyMessageInformation;
import fpml.consolidated.msg.RequestMessageHeader;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RequestMessageHeaderOnlyExistsValidator implements ValidatorWithArg<RequestMessageHeader, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RequestMessageHeader> ValidationResult<RequestMessageHeader> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("messageId", ExistenceChecker.isSet((MessageId) o.getMessageId()))
				.put("sentBy", ExistenceChecker.isSet((MessageAddress) o.getSentBy()))
				.put("sendTo", ExistenceChecker.isSet((List<? extends MessageAddress>) o.getSendTo()))
				.put("copyTo", ExistenceChecker.isSet((List<? extends MessageAddress>) o.getCopyTo()))
				.put("creationTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getCreationTimestamp()))
				.put("expiryTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getExpiryTimestamp()))
				.put("implementationSpecification", ExistenceChecker.isSet((ImplementationSpecification) o.getImplementationSpecification()))
				.put("partyMessageInformation", ExistenceChecker.isSet((List<? extends PartyMessageInformation>) o.getPartyMessageInformation()))
				.put("signature", ExistenceChecker.isSet((List<? extends SignatureType>) o.getSignature()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RequestMessageHeader", ValidationResult.ValidationType.ONLY_EXISTS, "RequestMessageHeader", path, "");
		}
		return failure("RequestMessageHeader", ValidationResult.ValidationType.ONLY_EXISTS, "RequestMessageHeader", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
