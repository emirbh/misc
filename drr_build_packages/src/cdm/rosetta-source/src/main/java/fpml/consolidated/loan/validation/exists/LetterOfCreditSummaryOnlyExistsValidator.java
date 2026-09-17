package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ContractId;
import fpml.consolidated.doc.VersionedContractId;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LcType;
import fpml.consolidated.loan.LetterOfCreditSummary;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LetterOfCreditSummaryOnlyExistsValidator implements ValidatorWithArg<LetterOfCreditSummary, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LetterOfCreditSummary> ValidationResult<LetterOfCreditSummary> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("contractId", ExistenceChecker.isSet((List<? extends ContractId>) o.getContractId()))
				.put("versionedContractId", ExistenceChecker.isSet((List<? extends VersionedContractId>) o.getVersionedContractId()))
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.put("type", ExistenceChecker.isSet((LcType) o._getType()))
				.put("effectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveDate()))
				.put("borrowerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBorrowerPartyReference()))
				.put("issuingBankPartyReference", ExistenceChecker.isSet((PartyReference) o.getIssuingBankPartyReference()))
				.put("beneficiaryPartyReference", ExistenceChecker.isSet((PartyReference) o.getBeneficiaryPartyReference()))
				.put("amount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LetterOfCreditSummary", ValidationResult.ValidationType.ONLY_EXISTS, "LetterOfCreditSummary", path, "");
		}
		return failure("LetterOfCreditSummary", ValidationResult.ValidationType.ONLY_EXISTS, "LetterOfCreditSummary", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
