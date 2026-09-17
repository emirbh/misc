package fpml.consolidated.doc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Allocation;
import fpml.consolidated.doc.Approvals;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Collateral;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AllocationOnlyExistsValidator implements ValidatorWithArg<Allocation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Allocation> ValidationResult<Allocation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("allocationTradeId", ExistenceChecker.isSet((List<? extends TradeIdentifier>) o.getAllocationTradeId()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("accountReference", ExistenceChecker.isSet((AccountReference) o.getAccountReference()))
				.put("allocatedFraction", ExistenceChecker.isSet((BigDecimal) o.getAllocatedFraction()))
				.put("allocatedNotional", ExistenceChecker.isSet((List<? extends Money>) o.getAllocatedNotional()))
				.put("collateral", ExistenceChecker.isSet((Collateral) o.getCollateral()))
				.put("creditChargeAmount", ExistenceChecker.isSet((Money) o.getCreditChargeAmount()))
				.put("approvals", ExistenceChecker.isSet((Approvals) o.getApprovals()))
				.put("masterConfirmationDate", ExistenceChecker.isSet((ZonedDateTime) o.getMasterConfirmationDate()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Allocation", ValidationResult.ValidationType.ONLY_EXISTS, "Allocation", path, "");
		}
		return failure("Allocation", ValidationResult.ValidationType.ONLY_EXISTS, "Allocation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
