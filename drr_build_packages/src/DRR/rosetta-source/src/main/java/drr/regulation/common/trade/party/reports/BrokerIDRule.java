package drr.regulation.common.trade.party.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PartyInformation;
import drr.base.util.party.functions.ExtractPartyFromRelatedPartyByRole;
import drr.base.util.party.functions.PartyLei;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(BrokerIDRule.BrokerIDRuleDefault.class)
public abstract class BrokerIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyFromRelatedPartyByRole extractPartyFromRelatedPartyByRole;
	@Inject protected PartyLei partyLei;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class BrokerIDRuleDefault extends BrokerIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<Party> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.ARRANGING_BROKER)));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(partyLei.evaluate(item.<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti()))).get();
			
			return output;
		}
	}
}
