package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsActionTypePRTO;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(AmendmentIndicatorRule.AmendmentIndicatorRuleDefault.class)
public abstract class AmendmentIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.event.reports.AmendmentIndicatorRule amendmentIndicatorRule;
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsActionTypePRTO isActionTypePRTO;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class AmendmentIndicatorRuleDefault extends AmendmentIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForCSA.evaluate(item.get()))).andNullSafe(areEqual(MapperS.of(isActionTypeTERM.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isActionTypeEROR.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(isActionTypePRTO.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All))).get());
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(amendmentIndicatorRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
