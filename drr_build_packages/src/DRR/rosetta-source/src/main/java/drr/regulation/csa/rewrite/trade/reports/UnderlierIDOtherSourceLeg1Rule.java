package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.IsCSALeg1Aligned;
import drr.standards.iosco.cde.version3.underlier.reports.UnderlierIDOtherSourceLeg2Rule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlierIDOtherSourceLeg1Rule.UnderlierIDOtherSourceLeg1RuleDefault.class)
public abstract class UnderlierIDOtherSourceLeg1Rule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCSALeg1Aligned isCSALeg1Aligned;
	@Inject protected drr.standards.iosco.cde.version3.underlier.reports.UnderlierIDOtherSourceLeg1Rule underlierIDOtherSourceLeg1Rule;
	@Inject protected UnderlierIDOtherSourceLeg2Rule underlierIDOtherSourceLeg2Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class UnderlierIDOtherSourceLeg1RuleDefault extends UnderlierIDOtherSourceLeg1Rule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final MapperS<TransactionReportInstructionBase> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<String> ifThenElseResult;
			if (areEqual(MapperS.of(isCSALeg1Aligned.evaluate(thenArg.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(underlierIDOtherSourceLeg1Rule.evaluate(thenArg.get()));
			} else {
				ifThenElseResult = MapperS.of(underlierIDOtherSourceLeg2Rule.evaluate(thenArg.get()));
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
