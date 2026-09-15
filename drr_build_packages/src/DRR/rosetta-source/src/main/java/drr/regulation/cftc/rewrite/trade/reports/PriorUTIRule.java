package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsActionTypePRTO;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.link.functions.GetPriorTransactionIdentifier;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriorUTIRule.PriorUTIRuleDefault.class)
public abstract class PriorUTIRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetPriorTransactionIdentifier getPriorTransactionIdentifier;
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsActionTypePRTO isActionTypePRTO;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

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

	public static class PriorUTIRuleDefault extends PriorUTIRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForCFTC.evaluate(item.get()))).andNullSafe(areEqual(MapperS.of(isActionTypeTERM.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isActionTypeEROR.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(isActionTypePRTO.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All))).get());
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(getPriorTransactionIdentifier.evaluate(item.get(), RegimeNameEnum.DODD_FRANK_ACT))).get();
			
			return output;
		}
	}
}
