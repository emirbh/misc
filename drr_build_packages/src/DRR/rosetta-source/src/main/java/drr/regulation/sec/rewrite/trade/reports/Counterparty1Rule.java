package drr.regulation.sec.rewrite.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.PartyLeiAndPersonByRoles;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(Counterparty1Rule.Counterparty1RuleDefault.class)
public abstract class Counterparty1Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PartyLeiAndPersonByRoles partyLeiAndPersonByRoles;

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

	public static class Counterparty1RuleDefault extends Counterparty1Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperS.of(partyLeiAndPersonByRoles.evaluate((referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), null));
				}).get();
			
			return output;
		}
	}
}
