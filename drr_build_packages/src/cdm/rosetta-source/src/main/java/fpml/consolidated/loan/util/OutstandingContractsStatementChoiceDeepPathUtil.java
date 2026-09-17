package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.ContractId;
import fpml.consolidated.doc.VersionedContractId;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.FxTerms;
import fpml.consolidated.loan.LetterOfCredit;
import fpml.consolidated.loan.LoanContract;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.loan.OutstandingContractsStatementChoice;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class OutstandingContractsStatementChoiceDeepPathUtil {
	public MoneyWithParticipantShare chooseAmount(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
		final MapperS<LoanContract> loanContract = MapperS.of(outstandingContractsStatementChoice).<LoanContract>map("getLoanContract", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<MoneyWithParticipantShare>map("getAmount", _loanContract -> _loanContract.getAmount()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(outstandingContractsStatementChoice).<LetterOfCredit>map("getLetterOfCredit", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<MoneyWithParticipantShare>map("getAmount", _letterOfCredit -> _letterOfCredit.getAmount()).get();
		}
		return null;
	}
	
	public FacilityReference chooseFacilityReference(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
		final MapperS<LoanContract> loanContract = MapperS.of(outstandingContractsStatementChoice).<LoanContract>map("getLoanContract", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<FacilityReference>map("getFacilityReference", _loanContract -> _loanContract.getFacilityReference()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(outstandingContractsStatementChoice).<LetterOfCredit>map("getLetterOfCredit", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<FacilityReference>map("getFacilityReference", _letterOfCredit -> _letterOfCredit.getFacilityReference()).get();
		}
		return null;
	}
	
	public PartyReference chooseBorrowerPartyReference(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
		final MapperS<LoanContract> loanContract = MapperS.of(outstandingContractsStatementChoice).<LoanContract>map("getLoanContract", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<PartyReference>map("getBorrowerPartyReference", _loanContract -> _loanContract.getBorrowerPartyReference()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(outstandingContractsStatementChoice).<LetterOfCredit>map("getLetterOfCredit", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<PartyReference>map("getBorrowerPartyReference", _letterOfCredit -> _letterOfCredit.getBorrowerPartyReference()).get();
		}
		return null;
	}
	
	public FxTerms chooseFacilityFxRate(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
		final MapperS<LoanContract> loanContract = MapperS.of(outstandingContractsStatementChoice).<LoanContract>map("getLoanContract", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<FxTerms>map("getFacilityFxRate", _loanContract -> _loanContract.getFacilityFxRate()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(outstandingContractsStatementChoice).<LetterOfCredit>map("getLetterOfCredit", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<FxTerms>map("getFacilityFxRate", _letterOfCredit -> _letterOfCredit.getFacilityFxRate()).get();
		}
		return null;
	}
	
	public List<ContractId> chooseContractId(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
		final MapperS<LoanContract> loanContract = MapperS.of(outstandingContractsStatementChoice).<LoanContract>map("getLoanContract", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<ContractId>mapC("getContractId", _loanContract -> _loanContract.getContractId()).getMulti();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(outstandingContractsStatementChoice).<LetterOfCredit>map("getLetterOfCredit", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<ContractId>mapC("getContractId", _letterOfCredit -> _letterOfCredit.getContractId()).getMulti();
		}
		return Collections.<ContractId>emptyList();
	}
	
	public PartyReference choosePartyReference(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
		final MapperS<LoanContract> loanContract = MapperS.of(outstandingContractsStatementChoice).<LoanContract>map("getLoanContract", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<PartyReference>map("getPartyReference", _loanContract -> _loanContract.getPartyReference()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(outstandingContractsStatementChoice).<LetterOfCredit>map("getLetterOfCredit", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<PartyReference>map("getPartyReference", _letterOfCredit -> _letterOfCredit.getPartyReference()).get();
		}
		return null;
	}
	
	public String chooseId(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
		final MapperS<LoanContract> loanContract = MapperS.of(outstandingContractsStatementChoice).<LoanContract>map("getLoanContract", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<String>map("getId", _loanContract -> _loanContract.getId()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(outstandingContractsStatementChoice).<LetterOfCredit>map("getLetterOfCredit", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<String>map("getId", _letterOfCredit -> _letterOfCredit.getId()).get();
		}
		return null;
	}
	
	public ZonedDateTime chooseEffectiveDate(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
		final MapperS<LoanContract> loanContract = MapperS.of(outstandingContractsStatementChoice).<LoanContract>map("getLoanContract", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<ZonedDateTime>map("getEffectiveDate", _loanContract -> _loanContract.getEffectiveDate()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(outstandingContractsStatementChoice).<LetterOfCredit>map("getLetterOfCredit", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<ZonedDateTime>map("getEffectiveDate", _letterOfCredit -> _letterOfCredit.getEffectiveDate()).get();
		}
		return null;
	}
	
	public List<VersionedContractId> chooseVersionedContractId(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
		final MapperS<LoanContract> loanContract = MapperS.of(outstandingContractsStatementChoice).<LoanContract>map("getLoanContract", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<VersionedContractId>mapC("getVersionedContractId", _loanContract -> _loanContract.getVersionedContractId()).getMulti();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(outstandingContractsStatementChoice).<LetterOfCredit>map("getLetterOfCredit", _outstandingContractsStatementChoice -> _outstandingContractsStatementChoice.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<VersionedContractId>mapC("getVersionedContractId", _letterOfCredit -> _letterOfCredit.getVersionedContractId()).getMulti();
		}
		return Collections.<VersionedContractId>emptyList();
	}
	
}
