package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.loan.ApplicableAssets;
import fpml.consolidated.loan.ApplicableCommunicationDetails;
import fpml.consolidated.loan.ApplicableSettlementInstructionDetails;
import fpml.consolidated.loan.ApplicableTransactions;
import fpml.consolidated.loan.AssociationToAssetIdentifier;
import fpml.consolidated.loan.PartyProfileChoice;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class PartyProfileChoiceDeepPathUtil {
	public AssociationToAssetIdentifier chooseIdentifier(PartyProfileChoice partyProfileChoice) {
		final MapperS<ApplicableCommunicationDetails> communicationDetails = MapperS.of(partyProfileChoice).<ApplicableCommunicationDetails>map("getCommunicationDetails", _partyProfileChoice -> _partyProfileChoice.getCommunicationDetails());
		if (exists(communicationDetails).getOrDefault(false)) {
			return communicationDetails.<AssociationToAssetIdentifier>map("getIdentifier", applicableCommunicationDetails -> applicableCommunicationDetails.getIdentifier()).get();
		}
		final MapperS<ApplicableSettlementInstructionDetails> settlementInstructionDetails = MapperS.of(partyProfileChoice).<ApplicableSettlementInstructionDetails>map("getSettlementInstructionDetails", _partyProfileChoice -> _partyProfileChoice.getSettlementInstructionDetails());
		if (exists(settlementInstructionDetails).getOrDefault(false)) {
			return settlementInstructionDetails.<AssociationToAssetIdentifier>map("getIdentifier", applicableSettlementInstructionDetails -> applicableSettlementInstructionDetails.getIdentifier()).get();
		}
		return null;
	}
	
	public ApplicableAssets chooseApplicableAssets(PartyProfileChoice partyProfileChoice) {
		final MapperS<ApplicableCommunicationDetails> communicationDetails = MapperS.of(partyProfileChoice).<ApplicableCommunicationDetails>map("getCommunicationDetails", _partyProfileChoice -> _partyProfileChoice.getCommunicationDetails());
		if (exists(communicationDetails).getOrDefault(false)) {
			return communicationDetails.<ApplicableAssets>map("getApplicableAssets", applicableCommunicationDetails -> applicableCommunicationDetails.getApplicableAssets()).get();
		}
		final MapperS<ApplicableSettlementInstructionDetails> settlementInstructionDetails = MapperS.of(partyProfileChoice).<ApplicableSettlementInstructionDetails>map("getSettlementInstructionDetails", _partyProfileChoice -> _partyProfileChoice.getSettlementInstructionDetails());
		if (exists(settlementInstructionDetails).getOrDefault(false)) {
			return settlementInstructionDetails.<ApplicableAssets>map("getApplicableAssets", applicableSettlementInstructionDetails -> applicableSettlementInstructionDetails.getApplicableAssets()).get();
		}
		return null;
	}
	
	public ApplicableTransactions chooseApplicableTransactions(PartyProfileChoice partyProfileChoice) {
		final MapperS<ApplicableCommunicationDetails> communicationDetails = MapperS.of(partyProfileChoice).<ApplicableCommunicationDetails>map("getCommunicationDetails", _partyProfileChoice -> _partyProfileChoice.getCommunicationDetails());
		if (exists(communicationDetails).getOrDefault(false)) {
			return communicationDetails.<ApplicableTransactions>map("getApplicableTransactions", applicableCommunicationDetails -> applicableCommunicationDetails.getApplicableTransactions()).get();
		}
		final MapperS<ApplicableSettlementInstructionDetails> settlementInstructionDetails = MapperS.of(partyProfileChoice).<ApplicableSettlementInstructionDetails>map("getSettlementInstructionDetails", _partyProfileChoice -> _partyProfileChoice.getSettlementInstructionDetails());
		if (exists(settlementInstructionDetails).getOrDefault(false)) {
			return settlementInstructionDetails.<ApplicableTransactions>map("getApplicableTransactions", applicableSettlementInstructionDetails -> applicableSettlementInstructionDetails.getApplicableTransactions()).get();
		}
		return null;
	}
	
}
