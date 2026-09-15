package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetUnderlyingIdentificationType;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import javax.inject.Inject;


@ImplementedBy(UnderlyingIdentificationTypeRule.UnderlyingIdentificationTypeRuleDefault.class)
public abstract class UnderlyingIdentificationTypeRule implements ReportFunction<TransactionReportInstruction, UnderlyingIdentificationTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUnderlyingIdentificationType getUnderlyingIdentificationType;
	@Inject protected IsAllowableAction isAllowableAction;

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
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = MapperS.of(getUnderlyingIdentificationType.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
