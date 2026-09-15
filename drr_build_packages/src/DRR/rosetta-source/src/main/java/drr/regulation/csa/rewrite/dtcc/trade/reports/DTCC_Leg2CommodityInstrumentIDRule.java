package drr.regulation.csa.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.dtcc.trade.reports.DTCC_Leg1CommodityInstrumentIDRule;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.IsCSALeg2Aligned;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_Leg2CommodityInstrumentIDRule.DTCC_Leg2CommodityInstrumentIDRuleDefault.class)
public abstract class DTCC_Leg2CommodityInstrumentIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DTCC_Leg1CommodityInstrumentIDRule dTCC_Leg1CommodityInstrumentIDRule;
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_Leg2CommodityInstrumentIDRule dTCC_Leg2CommodityInstrumentIDRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCSALeg2Aligned isCSALeg2Aligned;

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

	public static class DTCC_Leg2CommodityInstrumentIDRuleDefault extends DTCC_Leg2CommodityInstrumentIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<FieldWithMetaString> ifThenElseResult;
			if (areEqual(MapperS.of(isCSALeg2Aligned.evaluate(thenArg.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				final String string0 = dTCC_Leg2CommodityInstrumentIDRule.evaluate(thenArg.get());
				ifThenElseResult = string0 == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string0).build());
			} else {
				final String string1 = dTCC_Leg1CommodityInstrumentIDRule.evaluate(thenArg.get());
				ifThenElseResult = string1 == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string1).build());
			}
			final FieldWithMetaString fieldWithMetaString = ifThenElseResult.get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
