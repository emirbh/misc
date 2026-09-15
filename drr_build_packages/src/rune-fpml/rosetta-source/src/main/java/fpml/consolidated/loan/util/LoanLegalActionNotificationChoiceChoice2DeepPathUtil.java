package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.ContractId;
import fpml.consolidated.doc.VersionedContractId;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LetterOfCredit;
import fpml.consolidated.loan.LetterOfCreditSummary;
import fpml.consolidated.loan.LoanContractIdentifier;
import fpml.consolidated.loan.LoanLegalActionNotificationChoiceChoice2;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class LoanLegalActionNotificationChoiceChoice2DeepPathUtil {
	public FacilityReference chooseFacilityReference(LoanLegalActionNotificationChoiceChoice2 loanLegalActionNotificationChoiceChoice2) {
		final MapperS<LoanContractIdentifier> letterOfCreditIdentifier = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LoanContractIdentifier>map("getLetterOfCreditIdentifier", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCreditIdentifier());
		if (exists(letterOfCreditIdentifier).getOrDefault(false)) {
			return letterOfCreditIdentifier.<FacilityReference>map("getFacilityReference", loanContractIdentifier -> loanContractIdentifier.getFacilityReference()).get();
		}
		final MapperS<LetterOfCreditSummary> letterOfCreditSummary = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LetterOfCreditSummary>map("getLetterOfCreditSummary", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCreditSummary());
		if (exists(letterOfCreditSummary).getOrDefault(false)) {
			return letterOfCreditSummary.<FacilityReference>map("getFacilityReference", _letterOfCreditSummary -> _letterOfCreditSummary.getFacilityReference()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LetterOfCredit>map("getLetterOfCredit", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<FacilityReference>map("getFacilityReference", _letterOfCredit -> _letterOfCredit.getFacilityReference()).get();
		}
		return null;
	}
	
	public List<ContractId> chooseContractId(LoanLegalActionNotificationChoiceChoice2 loanLegalActionNotificationChoiceChoice2) {
		final MapperS<LoanContractIdentifier> letterOfCreditIdentifier = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LoanContractIdentifier>map("getLetterOfCreditIdentifier", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCreditIdentifier());
		if (exists(letterOfCreditIdentifier).getOrDefault(false)) {
			return letterOfCreditIdentifier.<ContractId>mapC("getContractId", loanContractIdentifier -> loanContractIdentifier.getContractId()).getMulti();
		}
		final MapperS<LetterOfCreditSummary> letterOfCreditSummary = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LetterOfCreditSummary>map("getLetterOfCreditSummary", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCreditSummary());
		if (exists(letterOfCreditSummary).getOrDefault(false)) {
			return letterOfCreditSummary.<ContractId>mapC("getContractId", _letterOfCreditSummary -> _letterOfCreditSummary.getContractId()).getMulti();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LetterOfCredit>map("getLetterOfCredit", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<ContractId>mapC("getContractId", _letterOfCredit -> _letterOfCredit.getContractId()).getMulti();
		}
		return Collections.<ContractId>emptyList();
	}
	
	public String chooseId(LoanLegalActionNotificationChoiceChoice2 loanLegalActionNotificationChoiceChoice2) {
		final MapperS<LoanContractIdentifier> letterOfCreditIdentifier = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LoanContractIdentifier>map("getLetterOfCreditIdentifier", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCreditIdentifier());
		if (exists(letterOfCreditIdentifier).getOrDefault(false)) {
			return letterOfCreditIdentifier.<String>map("getId", loanContractIdentifier -> loanContractIdentifier.getId()).get();
		}
		final MapperS<LetterOfCreditSummary> letterOfCreditSummary = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LetterOfCreditSummary>map("getLetterOfCreditSummary", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCreditSummary());
		if (exists(letterOfCreditSummary).getOrDefault(false)) {
			return letterOfCreditSummary.<String>map("getId", _letterOfCreditSummary -> _letterOfCreditSummary.getId()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LetterOfCredit>map("getLetterOfCredit", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<String>map("getId", _letterOfCredit -> _letterOfCredit.getId()).get();
		}
		return null;
	}
	
	public PartyReference choosePartyReference(LoanLegalActionNotificationChoiceChoice2 loanLegalActionNotificationChoiceChoice2) {
		final MapperS<LoanContractIdentifier> letterOfCreditIdentifier = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LoanContractIdentifier>map("getLetterOfCreditIdentifier", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCreditIdentifier());
		if (exists(letterOfCreditIdentifier).getOrDefault(false)) {
			return letterOfCreditIdentifier.<PartyReference>map("getPartyReference", loanContractIdentifier -> loanContractIdentifier.getPartyReference()).get();
		}
		final MapperS<LetterOfCreditSummary> letterOfCreditSummary = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LetterOfCreditSummary>map("getLetterOfCreditSummary", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCreditSummary());
		if (exists(letterOfCreditSummary).getOrDefault(false)) {
			return letterOfCreditSummary.<PartyReference>map("getPartyReference", _letterOfCreditSummary -> _letterOfCreditSummary.getPartyReference()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LetterOfCredit>map("getLetterOfCredit", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<PartyReference>map("getPartyReference", _letterOfCredit -> _letterOfCredit.getPartyReference()).get();
		}
		return null;
	}
	
	public List<VersionedContractId> chooseVersionedContractId(LoanLegalActionNotificationChoiceChoice2 loanLegalActionNotificationChoiceChoice2) {
		final MapperS<LoanContractIdentifier> letterOfCreditIdentifier = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LoanContractIdentifier>map("getLetterOfCreditIdentifier", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCreditIdentifier());
		if (exists(letterOfCreditIdentifier).getOrDefault(false)) {
			return letterOfCreditIdentifier.<VersionedContractId>mapC("getVersionedContractId", loanContractIdentifier -> loanContractIdentifier.getVersionedContractId()).getMulti();
		}
		final MapperS<LetterOfCreditSummary> letterOfCreditSummary = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LetterOfCreditSummary>map("getLetterOfCreditSummary", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCreditSummary());
		if (exists(letterOfCreditSummary).getOrDefault(false)) {
			return letterOfCreditSummary.<VersionedContractId>mapC("getVersionedContractId", _letterOfCreditSummary -> _letterOfCreditSummary.getVersionedContractId()).getMulti();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(loanLegalActionNotificationChoiceChoice2).<LetterOfCredit>map("getLetterOfCredit", _loanLegalActionNotificationChoiceChoice2 -> _loanLegalActionNotificationChoiceChoice2.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<VersionedContractId>mapC("getVersionedContractId", _letterOfCredit -> _letterOfCredit.getVersionedContractId()).getMulti();
		}
		return Collections.<VersionedContractId>emptyList();
	}
	
}
