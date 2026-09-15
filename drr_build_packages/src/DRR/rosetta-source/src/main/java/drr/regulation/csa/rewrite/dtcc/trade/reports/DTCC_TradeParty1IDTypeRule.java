package drr.regulation.csa.rewrite.dtcc.trade.reports;

import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.party.reports.Counterparty1Rule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_TradeParty1IDTypeRule.DTCC_TradeParty1IDTypeRuleDefault.class)
public abstract class DTCC_TradeParty1IDTypeRule implements ReportFunction<TransactionReportInstruction, PartyIdentifierTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Counterparty1Rule counterparty1Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PartyIdentifierTypeEnum evaluate(TransactionReportInstruction input) {
		PartyIdentifierTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PartyIdentifierTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class DTCC_TradeParty1IDTypeRuleDefault extends DTCC_TradeParty1IDTypeRule {
		@Override
		protected PartyIdentifierTypeEnum doEvaluate(TransactionReportInstruction input) {
			PartyIdentifierTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierTypeEnum assignOutput(PartyIdentifierTypeEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(counterparty1Rule.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(PartyIdentifierTypeEnum.LEI);
					}
					return MapperS.<PartyIdentifierTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
