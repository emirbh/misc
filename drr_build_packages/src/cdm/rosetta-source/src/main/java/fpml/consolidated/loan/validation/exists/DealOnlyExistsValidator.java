package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.Deal;
import fpml.consolidated.loan.DealSequence;
import fpml.consolidated.loan.LoanCovenantObligation;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.loan.ProRataFacilities;
import fpml.consolidated.loan.TransferFeeDefinition;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DealOnlyExistsValidator implements ValidatorWithArg<Deal, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Deal> ValidationResult<Deal> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("issuerPartyReference", ExistenceChecker.isSet((PartyReference) o.getIssuerPartyReference()))
				.put("guarantorPartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getGuarantorPartyReference()))
				.put("agentPartyReference", ExistenceChecker.isSet((PartyReference) o.getAgentPartyReference()))
				.put("syndicationLeadPartyReference", ExistenceChecker.isSet((PartyReference) o.getSyndicationLeadPartyReference()))
				.put("syndicationCoLeadPartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getSyndicationCoLeadPartyReference()))
				.put("creditAgreementDate", ExistenceChecker.isSet((ZonedDateTime) o.getCreditAgreementDate()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("issuedAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getIssuedAmount()))
				.put("currentDealAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getCurrentDealAmount()))
				.put("transferFee", ExistenceChecker.isSet((TransferFeeDefinition) o.getTransferFee()))
				.put("proRataFacilities", ExistenceChecker.isSet((List<? extends ProRataFacilities>) o.getProRataFacilities()))
				.put("covenant", ExistenceChecker.isSet((List<? extends LoanCovenantObligation>) o.getCovenant()))
				.put("dealSequence", ExistenceChecker.isSet((List<? extends DealSequence>) o.getDealSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Deal", ValidationResult.ValidationType.ONLY_EXISTS, "Deal", path, "");
		}
		return failure("Deal", ValidationResult.ValidationType.ONLY_EXISTS, "Deal", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
