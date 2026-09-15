package drr.standards.iosco.cde.version1.party.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.TradeForEvent;
import drr.base.util.party.functions.PartyLeiAndPersonByRoles;
import drr.standards.iosco.cde.version1.party.functions.Direction1BuyerParty;
import javax.inject.Inject;


@ImplementedBy(Direction1BuyerIdentifierRule.Direction1BuyerIdentifierRuleDefault.class)
public abstract class Direction1BuyerIdentifierRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Direction1BuyerParty direction1BuyerParty;
	@Inject protected PartyLeiAndPersonByRoles partyLeiAndPersonByRoles;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class Direction1BuyerIdentifierRuleDefault extends Direction1BuyerIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstructionBase -> transactionReportInstructionBase.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperS.of(partyLeiAndPersonByRoles.evaluate(direction1BuyerParty.evaluate(tradeForEvent.evaluate(item.get())), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
				}).get();
			
			return output;
		}
	}
}
