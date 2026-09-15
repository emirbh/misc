package drr.regulation.csa.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.dtcc.trade.reports.DTCC_Leg2FloatingRateIndexRule;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.IsCSALeg1Aligned;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_Leg1FloatingRateIndexRule.DTCC_Leg1FloatingRateIndexRuleDefault.class)
public abstract class DTCC_Leg1FloatingRateIndexRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_Leg1FloatingRateIndexRule dTCC_Leg1FloatingRateIndexRule;
	@Inject protected DTCC_Leg2FloatingRateIndexRule dTCC_Leg2FloatingRateIndexRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCSALeg1Aligned isCSALeg1Aligned;

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

	public static class DTCC_Leg1FloatingRateIndexRuleDefault extends DTCC_Leg1FloatingRateIndexRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(isCSALeg1Aligned.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(dTCC_Leg1FloatingRateIndexRule.evaluate(item.get()));
					}
					return MapperS.of(dTCC_Leg2FloatingRateIndexRule.evaluate(item.get()));
				}).get();
			
			return output;
		}
	}
}
