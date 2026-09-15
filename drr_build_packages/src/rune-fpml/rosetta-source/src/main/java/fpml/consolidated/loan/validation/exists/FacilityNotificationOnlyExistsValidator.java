package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.AbstractFacilityEvent;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.EventPayment;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.FacilityNotification;
import fpml.consolidated.loan.FacilityNotificationChoice0;
import fpml.consolidated.loan.FacilityNotificationChoice1;
import fpml.consolidated.loan.FacilityPosition;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilityNotificationOnlyExistsValidator implements ValidatorWithArg<FacilityNotification, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilityNotification> ValidationResult<FacilityNotification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validation", ExistenceChecker.isSet((List<? extends Validation>) o.getValidation()))
				.put("isCorrection", ExistenceChecker.isSet((Boolean) o.getIsCorrection()))
				.put("parentCorrelationId", ExistenceChecker.isSet((CorrelationId) o.getParentCorrelationId()))
				.put("correlationId", ExistenceChecker.isSet((List<? extends CorrelationId>) o.getCorrelationId()))
				.put("sequenceNumber", ExistenceChecker.isSet((Integer) o.getSequenceNumber()))
				.put("onBehalfOf", ExistenceChecker.isSet((List<? extends OnBehalfOf>) o.getOnBehalfOf()))
				.put("noticeDate", ExistenceChecker.isSet((ZonedDateTime) o.getNoticeDate()))
				.put("isGlobalOnly", ExistenceChecker.isSet((Boolean) o.getIsGlobalOnly()))
				.put("eventPayment", ExistenceChecker.isSet((List<? extends EventPayment>) o.getEventPayment()))
				.put("facilityPosition", ExistenceChecker.isSet((FacilityPosition) o.getFacilityPosition()))
				.put("facilityEventGroup", ExistenceChecker.isSet((AbstractFacilityEvent) o.getFacilityEventGroup()))
				.put("dealIdentifier", ExistenceChecker.isSet((DealIdentifier) o.getDealIdentifier()))
				.put("dealSummary", ExistenceChecker.isSet((DealSummary) o.getDealSummary()))
				.put("facilityIdentifier", ExistenceChecker.isSet((FacilityIdentifier) o.getFacilityIdentifier()))
				.put("facilitySummary", ExistenceChecker.isSet((FacilitySummary) o.getFacilitySummary()))
				.put("facilityNotificationChoice0", ExistenceChecker.isSet((List<? extends FacilityNotificationChoice0>) o.getFacilityNotificationChoice0()))
				.put("facilityNotificationChoice1", ExistenceChecker.isSet((List<? extends FacilityNotificationChoice1>) o.getFacilityNotificationChoice1()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilityNotification", ValidationResult.ValidationType.ONLY_EXISTS, "FacilityNotification", path, "");
		}
		return failure("FacilityNotification", ValidationResult.ValidationType.ONLY_EXISTS, "FacilityNotification", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
