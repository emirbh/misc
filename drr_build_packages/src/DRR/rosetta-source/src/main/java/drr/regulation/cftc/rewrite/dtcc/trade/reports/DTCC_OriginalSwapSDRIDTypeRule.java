package drr.regulation.cftc.rewrite.dtcc.trade.reports;

import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.link.reports.OriginalSwapSDRIdentifierRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_OriginalSwapSDRIDTypeRule.DTCC_OriginalSwapSDRIDTypeRuleDefault.class)
public abstract class DTCC_OriginalSwapSDRIDTypeRule implements ReportFunction<TransactionReportInstruction, PartyIdentifierTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected OriginalSwapSDRIdentifierRule originalSwapSDRIdentifierRule;

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

	public static class DTCC_OriginalSwapSDRIDTypeRuleDefault extends DTCC_OriginalSwapSDRIDTypeRule {
		@Override
		protected PartyIdentifierTypeEnum doEvaluate(TransactionReportInstruction input) {
			PartyIdentifierTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierTypeEnum assignOutput(PartyIdentifierTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(originalSwapSDRIdentifierRule.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(PartyIdentifierTypeEnum.LEI);
					}
					return MapperS.<PartyIdentifierTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
