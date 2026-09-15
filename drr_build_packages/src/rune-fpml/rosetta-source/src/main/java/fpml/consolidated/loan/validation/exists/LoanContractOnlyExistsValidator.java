package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ContractId;
import fpml.consolidated.doc.VersionedContractId;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.FixedRateAccrual;
import fpml.consolidated.loan.FxTerms;
import fpml.consolidated.loan.LegacyFloatingRateAccrual;
import fpml.consolidated.loan.LoanContract;
import fpml.consolidated.loan.LoanFloatingRateAccrual;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanContractOnlyExistsValidator implements ValidatorWithArg<LoanContract, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanContract> ValidationResult<LoanContract> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("contractId", ExistenceChecker.isSet((List<? extends ContractId>) o.getContractId()))
				.put("versionedContractId", ExistenceChecker.isSet((List<? extends VersionedContractId>) o.getVersionedContractId()))
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.put("effectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveDate()))
				.put("borrowerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBorrowerPartyReference()))
				.put("guarantorPartyReference", ExistenceChecker.isSet((PartyReference) o.getGuarantorPartyReference()))
				.put("amount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAmount()))
				.put("repricingDate", ExistenceChecker.isSet((ZonedDateTime) o.getRepricingDate()))
				.put("maturityDate", ExistenceChecker.isSet((ZonedDateTime) o.getMaturityDate()))
				.put("fixedRateAccrual", ExistenceChecker.isSet((FixedRateAccrual) o.getFixedRateAccrual()))
				.put("floatingRateAccrual", ExistenceChecker.isSet((LoanFloatingRateAccrual) o.getFloatingRateAccrual()))
				.put("legacyFloatingRateAccrual", ExistenceChecker.isSet((LegacyFloatingRateAccrual) o.getLegacyFloatingRateAccrual()))
				.put("facilityFxRate", ExistenceChecker.isSet((FxTerms) o.getFacilityFxRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanContract", ValidationResult.ValidationType.ONLY_EXISTS, "LoanContract", path, "");
		}
		return failure("LoanContract", ValidationResult.ValidationType.ONLY_EXISTS, "LoanContract", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
