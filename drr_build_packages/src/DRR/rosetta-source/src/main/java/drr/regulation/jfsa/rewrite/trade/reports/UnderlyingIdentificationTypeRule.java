package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetUnderlyingIdentificationType;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingIdentificationTypeRule.UnderlyingIdentificationTypeRuleDefault.class)
public abstract class UnderlyingIdentificationTypeRule implements ReportFunction<TransactionReportInstruction, UnderlyingIdentificationTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUnderlyingIdentificationType getUnderlyingIdentificationType;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public UnderlyingIdentificationTypeEnum evaluate(TransactionReportInstruction input) {
		UnderlyingIdentificationTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract UnderlyingIdentificationTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class UnderlyingIdentificationTypeRuleDefault extends UnderlyingIdentificationTypeRule {
		@Override
		protected UnderlyingIdentificationTypeEnum doEvaluate(TransactionReportInstruction input) {
			UnderlyingIdentificationTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected UnderlyingIdentificationTypeEnum assignOutput(UnderlyingIdentificationTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final MapperS<UnderlyingIdentificationTypeEnum> ifThenElseResult;
			if (exists(MapperS.of(getUnderlyingIdentificationType.evaluate(thenArg.get()))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(getUnderlyingIdentificationType.evaluate(thenArg.get()));
			} else {
				ifThenElseResult = MapperS.<UnderlyingIdentificationTypeEnum>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
