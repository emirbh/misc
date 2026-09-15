package drr.regulation.cftc.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(DTCC_TradeParty2ReportingDestinationRule.DTCC_TradeParty2ReportingDestinationRuleDefault.class)
public abstract class DTCC_TradeParty2ReportingDestinationRule implements ReportFunction<TransactionReportInstruction, List<SupervisoryBodyEnum>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty2ReportingDestinationRule dTCC_TradeParty2ReportingDestinationRule;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<SupervisoryBodyEnum> evaluate(TransactionReportInstruction input) {
		List<SupervisoryBodyEnum> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<SupervisoryBodyEnum> doEvaluate(TransactionReportInstruction input);

	public static class DTCC_TradeParty2ReportingDestinationRuleDefault extends DTCC_TradeParty2ReportingDestinationRule {
		@Override
		protected List<SupervisoryBodyEnum> doEvaluate(TransactionReportInstruction input) {
			List<SupervisoryBodyEnum> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<SupervisoryBodyEnum> assignOutput(List<SupervisoryBodyEnum> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToList(item -> MapperC.<FieldWithMetaSupervisoryBodyEnum>of(dTCC_TradeParty2ReportingDestinationRule.evaluate(item.get()).stream()
					.<FieldWithMetaSupervisoryBodyEnum>map(supervisoryBodyEnum -> FieldWithMetaSupervisoryBodyEnum.builder().setValue(supervisoryBodyEnum).build())
					.collect(Collectors.toList())
				)).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum.getValue()).getMulti();
			
			return output;
		}
	}
}
