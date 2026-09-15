package drr.regulation.hkma.rewrite.trade.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PartyInformation;
import drr.base.util.party.functions.ExtractPartyFromRelatedPartyByRole;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Extract_BrokerId.Extract_BrokerIdDefault.class)
public abstract class Extract_BrokerId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyFromRelatedPartyByRole extractPartyFromRelatedPartyByRole;

	/**
	* @param transactionReportInstruction 
	* @return party 
	*/
	public Party evaluate(TransactionReportInstruction transactionReportInstruction) {
		Party.PartyBuilder partyBuilder = doEvaluate(transactionReportInstruction);
		
		final Party party;
		if (partyBuilder == null) {
			party = null;
		} else {
			party = partyBuilder.build();
			objectValidator.validate(Party.class, party);
		}
		
		return party;
	}

	protected abstract Party.PartyBuilder doEvaluate(TransactionReportInstruction transactionReportInstruction);

	public static class Extract_BrokerIdDefault extends Extract_BrokerId {
		@Override
		protected Party.PartyBuilder doEvaluate(TransactionReportInstruction transactionReportInstruction) {
			Party.PartyBuilder party = Party.builder();
			return assignOutput(party, transactionReportInstruction);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder party, TransactionReportInstruction transactionReportInstruction) {
			party = toBuilder(extractPartyFromRelatedPartyByRole.evaluate(MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.ARRANGING_BROKER));
			
			return Optional.ofNullable(party)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
