package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CovenantObligationId;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LoanCovenantObligation;
import fpml.consolidated.loan.LoanCovenantObligationAccountingDetails;
import fpml.consolidated.loan.LoanCovenantObligationCategoryType;
import fpml.consolidated.loan.LoanCovenantObligationChoice;
import fpml.consolidated.loan.LoanCovenantObligationReference;
import fpml.consolidated.loan.LoanCovenantObligationTriggerCriteriaDetails;
import fpml.consolidated.loan.LoanCovenantObligationType;
import fpml.consolidated.loan.VersionedCovenantObligationId;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanCovenantObligationOnlyExistsValidator implements ValidatorWithArg<LoanCovenantObligation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanCovenantObligation> ValidationResult<LoanCovenantObligation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("covenantObligationId", ExistenceChecker.isSet((List<? extends CovenantObligationId>) o.getCovenantObligationId()))
				.put("versionedCovenantObligationId", ExistenceChecker.isSet((List<? extends VersionedCovenantObligationId>) o.getVersionedCovenantObligationId()))
				.put("effectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveDate()))
				.put("obligatedParty", ExistenceChecker.isSet((PartyReference) o.getObligatedParty()))
				.put("dealReference", ExistenceChecker.isSet((DealReference) o.getDealReference()))
				.put("facilityReference", ExistenceChecker.isSet((List<? extends FacilityReference>) o.getFacilityReference()))
				.put("deemedCovenantReference", ExistenceChecker.isSet((LoanCovenantObligationReference) o.getDeemedCovenantReference()))
				.put("category", ExistenceChecker.isSet((LoanCovenantObligationCategoryType) o.getCategory()))
				.put("type", ExistenceChecker.isSet((LoanCovenantObligationType) o._getType()))
				.put("loanCovenantObligationChoice", ExistenceChecker.isSet((List<? extends LoanCovenantObligationChoice>) o.getLoanCovenantObligationChoice()))
				.put("triggerCriteria", ExistenceChecker.isSet((LoanCovenantObligationTriggerCriteriaDetails) o.getTriggerCriteria()))
				.put("accountingDetails", ExistenceChecker.isSet((LoanCovenantObligationAccountingDetails) o.getAccountingDetails()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanCovenantObligation", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligation", path, "");
		}
		return failure("LoanCovenantObligation", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
