package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.CounterpartiesForEvent;
import drr.base.util.party.functions.PartyLeiAndPersonByRoles;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.standards.iosco.cde.version3.party.functions.ReceiverParty;
import javax.inject.Inject;


@ImplementedBy(ReceiverIdentifierLeg1Rule.ReceiverIdentifierLeg1RuleDefault.class)
public abstract class ReceiverIdentifierLeg1Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CounterpartiesForEvent counterpartiesForEvent;
	@Inject protected PartyLeiAndPersonByRoles partyLeiAndPersonByRoles;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected ReceiverParty receiverParty;

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

	public static class ReceiverIdentifierLeg1RuleDefault extends ReceiverIdentifierLeg1Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperS.of(partyLeiAndPersonByRoles.evaluate(receiverParty.evaluate(payoutLeg1Rule.evaluate(item.get()), counterpartiesForEvent.evaluate(item.get())), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
				}).get();
			
			return output;
		}
	}
}
