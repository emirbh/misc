package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CommitmentSchedule;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.FacilityCommitment;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.loan.FxTerms;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilitySummaryOnlyExistsValidator implements ValidatorWithArg<FacilitySummary, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilitySummary> ValidationResult<FacilitySummary> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("dealReference", ExistenceChecker.isSet((DealReference) o.getDealReference()))
				.put("borrowerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBorrowerPartyReference()))
				.put("coBorrowerPartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getCoBorrowerPartyReference()))
				.put("agentPartyReference", ExistenceChecker.isSet((PartyReference) o.getAgentPartyReference()))
				.put("lcIssuingBankPartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getLcIssuingBankPartyReference()))
				.put("guarantorPartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getGuarantorPartyReference()))
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("expiryDate", ExistenceChecker.isSet((ZonedDateTime) o.getExpiryDate()))
				.put("maturityDate", ExistenceChecker.isSet((ZonedDateTime) o.getMaturityDate()))
				.put("currentCommitment", ExistenceChecker.isSet((FacilityCommitment) o.getCurrentCommitment()))
				.put("originalCommitment", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getOriginalCommitment()))
				.put("commitmentSchedule", ExistenceChecker.isSet((CommitmentSchedule) o.getCommitmentSchedule()))
				.put("dealFxRate", ExistenceChecker.isSet((FxTerms) o.getDealFxRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilitySummary", ValidationResult.ValidationType.ONLY_EXISTS, "FacilitySummary", path, "");
		}
		return failure("FacilitySummary", ValidationResult.ValidationType.ONLY_EXISTS, "FacilitySummary", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
