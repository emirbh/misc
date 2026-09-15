package drr.regulation.cftc.rewrite.trade.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.base.util.party.functions.PartyIdentifierFormat;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(Counterparty1FormatRule.Counterparty1FormatRuleDefault.class)
public abstract class Counterparty1FormatRule implements ReportFunction<TransactionReportInstruction, PartyIdentifierFormatEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PartyIdentifierFormat partyIdentifierFormat;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PartyIdentifierFormatEnum evaluate(TransactionReportInstruction input) {
		PartyIdentifierFormatEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PartyIdentifierFormatEnum doEvaluate(TransactionReportInstruction input);

	public static class Counterparty1FormatRuleDefault extends Counterparty1FormatRule {
		@Override
		protected PartyIdentifierFormatEnum doEvaluate(TransactionReportInstruction input) {
			PartyIdentifierFormatEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierFormatEnum assignOutput(PartyIdentifierFormatEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperS.of(partyIdentifierFormat.evaluate((referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
				}).get();
			
			return output;
		}
	}
}
