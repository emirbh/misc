package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.CashOrPhysicalSettlementEnum;
import fpml.consolidated.business.events.CreditChangeEventBase;
import fpml.consolidated.business.events.CreditEventType;
import fpml.consolidated.shared.Resource;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditChangeEventBaseOnlyExistsValidator implements ValidatorWithArg<CreditChangeEventBase, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditChangeEventBase> ValidationResult<CreditChangeEventBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("creditEventType", ExistenceChecker.isSet((CreditEventType) o.getCreditEventType()))
				.put("eventDeterminationDate", ExistenceChecker.isSet((ZonedDateTime) o.getEventDeterminationDate()))
				.put("auctionDate", ExistenceChecker.isSet((ZonedDateTime) o.getAuctionDate()))
				.put("settlementMethod", ExistenceChecker.isSet((CashOrPhysicalSettlementEnum) o.getSettlementMethod()))
				.put("settlementDate", ExistenceChecker.isSet((ZonedDateTime) o.getSettlementDate()))
				.put("finalPrice", ExistenceChecker.isSet((BigDecimal) o.getFinalPrice()))
				.put("recoveryPercent", ExistenceChecker.isSet((BigDecimal) o.getRecoveryPercent()))
				.put("publiclyAvailableInformation", ExistenceChecker.isSet((List<? extends Resource>) o.getPubliclyAvailableInformation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditChangeEventBase", ValidationResult.ValidationType.ONLY_EXISTS, "CreditChangeEventBase", path, "");
		}
		return failure("CreditChangeEventBase", ValidationResult.ValidationType.ONLY_EXISTS, "CreditChangeEventBase", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
