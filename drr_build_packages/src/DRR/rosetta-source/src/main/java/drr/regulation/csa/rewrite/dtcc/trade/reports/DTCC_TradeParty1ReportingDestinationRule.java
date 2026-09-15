package drr.regulation.csa.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(DTCC_TradeParty1ReportingDestinationRule.DTCC_TradeParty1ReportingDestinationRuleDefault.class)
public abstract class DTCC_TradeParty1ReportingDestinationRule implements ReportFunction<TransactionReportInstruction, List<SupervisoryBodyEnum>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty1ReportingDestinationRule dTCC_TradeParty1ReportingDestinationRule;

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

	public static class DTCC_TradeParty1ReportingDestinationRuleDefault extends DTCC_TradeParty1ReportingDestinationRule {
		@Override
		protected List<SupervisoryBodyEnum> doEvaluate(TransactionReportInstruction input) {
			List<SupervisoryBodyEnum> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<SupervisoryBodyEnum> assignOutput(List<SupervisoryBodyEnum> output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToList(item -> MapperC.<FieldWithMetaSupervisoryBodyEnum>of(dTCC_TradeParty1ReportingDestinationRule.evaluate(item.get()).stream()
					.<FieldWithMetaSupervisoryBodyEnum>map(supervisoryBodyEnum -> FieldWithMetaSupervisoryBodyEnum.builder().setValue(supervisoryBodyEnum).build())
					.collect(Collectors.toList())
				)).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum.getValue()).getMulti();
			
			return output;
		}
	}
}
