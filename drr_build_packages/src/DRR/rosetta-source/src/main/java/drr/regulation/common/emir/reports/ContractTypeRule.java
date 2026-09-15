package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(ContractTypeRule.ContractTypeRuleDefault.class)
public abstract class ContractTypeRule implements ReportFunction<TransactionReportInstruction, CommonContractType> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.contract.reports.ContractTypeRule contractTypeRule;
	@Inject protected IsAllowableAction isAllowableAction;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CommonContractType evaluate(TransactionReportInstruction input) {
		CommonContractType output = doEvaluate(input);
		
		return output;
	}

	protected abstract CommonContractType doEvaluate(TransactionReportInstruction input);

	public static class ContractTypeRuleDefault extends ContractTypeRule {
		@Override
		protected CommonContractType doEvaluate(TransactionReportInstruction input) {
			CommonContractType output = null;
			return assignOutput(output, input);
		}
		
		protected CommonContractType assignOutput(CommonContractType output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(contractTypeRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
