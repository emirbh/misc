package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LegalActionId;
import fpml.consolidated.loan.LoanLegalActionDetails;
import fpml.consolidated.loan.LoanLegalActionSummary;
import fpml.consolidated.loan.VersionedLegalActionId;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanLegalActionSummaryOnlyExistsValidator implements ValidatorWithArg<LoanLegalActionSummary, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanLegalActionSummary> ValidationResult<LoanLegalActionSummary> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("legalActionId", ExistenceChecker.isSet((List<? extends LegalActionId>) o.getLegalActionId()))
				.put("versionedLegalActionId", ExistenceChecker.isSet((List<? extends VersionedLegalActionId>) o.getVersionedLegalActionId()))
				.put("actionDetails", ExistenceChecker.isSet((LoanLegalActionDetails) o.getActionDetails()))
				.put("dealReference", ExistenceChecker.isSet((DealReference) o.getDealReference()))
				.put("facilityReference", ExistenceChecker.isSet((List<? extends FacilityReference>) o.getFacilityReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanLegalActionSummary", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionSummary", path, "");
		}
		return failure("LoanLegalActionSummary", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionSummary", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
