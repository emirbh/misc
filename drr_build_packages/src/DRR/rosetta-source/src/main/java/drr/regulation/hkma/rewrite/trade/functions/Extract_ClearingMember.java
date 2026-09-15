package drr.regulation.hkma.rewrite.trade.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.functions.IsCleared;
import drr.base.trade.PartyInformation;
import drr.base.util.party.functions.ExtractPartyFromRelatedPartyByRole;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Extract_ClearingMember.Extract_ClearingMemberDefault.class)
public abstract class Extract_ClearingMember implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyFromRelatedPartyByRole extractPartyFromRelatedPartyByRole;
	@Inject protected IsCleared isCleared;

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

	public static class Extract_ClearingMemberDefault extends Extract_ClearingMember {
		@Override
		protected Party.PartyBuilder doEvaluate(TransactionReportInstruction transactionReportInstruction) {
			Party.PartyBuilder party = Party.builder();
			return assignOutput(party, transactionReportInstruction);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder party, TransactionReportInstruction transactionReportInstruction) {
			final Boolean _boolean = isCleared.evaluate(MapperS.of(transactionReportInstruction).<WorkflowStep>map("getOriginatingWorkflowStep", _transactionReportInstruction -> _transactionReportInstruction.getOriginatingWorkflowStep()).get());
			if ((_boolean == null ? false : _boolean)) {
				party = toBuilder(extractPartyFromRelatedPartyByRole.evaluate(MapperS.of(transactionReportInstruction).<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.CLEARING_FIRM));
			} else {
				party = null;
			}
			
			return Optional.ofNullable(party)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
