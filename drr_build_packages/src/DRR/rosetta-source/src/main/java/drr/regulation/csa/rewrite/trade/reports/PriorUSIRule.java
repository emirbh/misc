package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsActionTypePRTO;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriorUSIRule.PriorUSIRuleDefault.class)
public abstract class PriorUSIRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsActionTypePRTO isActionTypePRTO;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected drr.regulation.common.trade.link.reports.PriorUSIRule priorUSIRule;

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

	public static class PriorUSIRuleDefault extends PriorUSIRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForCSA.evaluate(item.get()))).andNullSafe(areEqual(MapperS.of(isActionTypeTERM.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isActionTypeEROR.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(isActionTypePRTO.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All))).get());
			final String string = priorUSIRule.evaluate(thenArg.get());
			final FieldWithMetaString fieldWithMetaString = (string == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string).build())).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
