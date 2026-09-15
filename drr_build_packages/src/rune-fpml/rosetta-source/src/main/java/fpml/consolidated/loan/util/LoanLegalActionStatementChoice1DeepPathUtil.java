package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.ContractId;
import fpml.consolidated.doc.VersionedContractId;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.LoanContract;
import fpml.consolidated.loan.LoanContractIdentifier;
import fpml.consolidated.loan.LoanContractSummary;
import fpml.consolidated.loan.LoanLegalActionStatementChoice1;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class LoanLegalActionStatementChoice1DeepPathUtil {
	public FacilityReference chooseFacilityReference(LoanLegalActionStatementChoice1 loanLegalActionStatementChoice1) {
		final MapperS<LoanContractIdentifier> contractIdentifier = MapperS.of(loanLegalActionStatementChoice1).<LoanContractIdentifier>map("getContractIdentifier", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContractIdentifier());
		if (exists(contractIdentifier).getOrDefault(false)) {
			return contractIdentifier.<FacilityReference>map("getFacilityReference", loanContractIdentifier -> loanContractIdentifier.getFacilityReference()).get();
		}
		final MapperS<LoanContractSummary> contractSummary = MapperS.of(loanLegalActionStatementChoice1).<LoanContractSummary>map("getContractSummary", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContractSummary());
		if (exists(contractSummary).getOrDefault(false)) {
			return contractSummary.<FacilityReference>map("getFacilityReference", loanContractSummary -> loanContractSummary.getFacilityReference()).get();
		}
		final MapperS<LoanContract> contract = MapperS.of(loanLegalActionStatementChoice1).<LoanContract>map("getContract", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContract());
		if (exists(contract).getOrDefault(false)) {
			return contract.<FacilityReference>map("getFacilityReference", loanContract -> loanContract.getFacilityReference()).get();
		}
		return null;
	}
	
	public List<ContractId> chooseContractId(LoanLegalActionStatementChoice1 loanLegalActionStatementChoice1) {
		final MapperS<LoanContractIdentifier> contractIdentifier = MapperS.of(loanLegalActionStatementChoice1).<LoanContractIdentifier>map("getContractIdentifier", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContractIdentifier());
		if (exists(contractIdentifier).getOrDefault(false)) {
			return contractIdentifier.<ContractId>mapC("getContractId", loanContractIdentifier -> loanContractIdentifier.getContractId()).getMulti();
		}
		final MapperS<LoanContractSummary> contractSummary = MapperS.of(loanLegalActionStatementChoice1).<LoanContractSummary>map("getContractSummary", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContractSummary());
		if (exists(contractSummary).getOrDefault(false)) {
			return contractSummary.<ContractId>mapC("getContractId", loanContractSummary -> loanContractSummary.getContractId()).getMulti();
		}
		final MapperS<LoanContract> contract = MapperS.of(loanLegalActionStatementChoice1).<LoanContract>map("getContract", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContract());
		if (exists(contract).getOrDefault(false)) {
			return contract.<ContractId>mapC("getContractId", loanContract -> loanContract.getContractId()).getMulti();
		}
		return Collections.<ContractId>emptyList();
	}
	
	public String chooseId(LoanLegalActionStatementChoice1 loanLegalActionStatementChoice1) {
		final MapperS<LoanContractIdentifier> contractIdentifier = MapperS.of(loanLegalActionStatementChoice1).<LoanContractIdentifier>map("getContractIdentifier", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContractIdentifier());
		if (exists(contractIdentifier).getOrDefault(false)) {
			return contractIdentifier.<String>map("getId", loanContractIdentifier -> loanContractIdentifier.getId()).get();
		}
		final MapperS<LoanContractSummary> contractSummary = MapperS.of(loanLegalActionStatementChoice1).<LoanContractSummary>map("getContractSummary", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContractSummary());
		if (exists(contractSummary).getOrDefault(false)) {
			return contractSummary.<String>map("getId", loanContractSummary -> loanContractSummary.getId()).get();
		}
		final MapperS<LoanContract> contract = MapperS.of(loanLegalActionStatementChoice1).<LoanContract>map("getContract", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContract());
		if (exists(contract).getOrDefault(false)) {
			return contract.<String>map("getId", loanContract -> loanContract.getId()).get();
		}
		return null;
	}
	
	public PartyReference choosePartyReference(LoanLegalActionStatementChoice1 loanLegalActionStatementChoice1) {
		final MapperS<LoanContractIdentifier> contractIdentifier = MapperS.of(loanLegalActionStatementChoice1).<LoanContractIdentifier>map("getContractIdentifier", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContractIdentifier());
		if (exists(contractIdentifier).getOrDefault(false)) {
			return contractIdentifier.<PartyReference>map("getPartyReference", loanContractIdentifier -> loanContractIdentifier.getPartyReference()).get();
		}
		final MapperS<LoanContractSummary> contractSummary = MapperS.of(loanLegalActionStatementChoice1).<LoanContractSummary>map("getContractSummary", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContractSummary());
		if (exists(contractSummary).getOrDefault(false)) {
			return contractSummary.<PartyReference>map("getPartyReference", loanContractSummary -> loanContractSummary.getPartyReference()).get();
		}
		final MapperS<LoanContract> contract = MapperS.of(loanLegalActionStatementChoice1).<LoanContract>map("getContract", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContract());
		if (exists(contract).getOrDefault(false)) {
			return contract.<PartyReference>map("getPartyReference", loanContract -> loanContract.getPartyReference()).get();
		}
		return null;
	}
	
	public List<VersionedContractId> chooseVersionedContractId(LoanLegalActionStatementChoice1 loanLegalActionStatementChoice1) {
		final MapperS<LoanContractIdentifier> contractIdentifier = MapperS.of(loanLegalActionStatementChoice1).<LoanContractIdentifier>map("getContractIdentifier", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContractIdentifier());
		if (exists(contractIdentifier).getOrDefault(false)) {
			return contractIdentifier.<VersionedContractId>mapC("getVersionedContractId", loanContractIdentifier -> loanContractIdentifier.getVersionedContractId()).getMulti();
		}
		final MapperS<LoanContractSummary> contractSummary = MapperS.of(loanLegalActionStatementChoice1).<LoanContractSummary>map("getContractSummary", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContractSummary());
		if (exists(contractSummary).getOrDefault(false)) {
			return contractSummary.<VersionedContractId>mapC("getVersionedContractId", loanContractSummary -> loanContractSummary.getVersionedContractId()).getMulti();
		}
		final MapperS<LoanContract> contract = MapperS.of(loanLegalActionStatementChoice1).<LoanContract>map("getContract", _loanLegalActionStatementChoice1 -> _loanLegalActionStatementChoice1.getContract());
		if (exists(contract).getOrDefault(false)) {
			return contract.<VersionedContractId>mapC("getVersionedContractId", loanContract -> loanContract.getVersionedContractId()).getMulti();
		}
		return Collections.<VersionedContractId>emptyList();
	}
	
}
