package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import javax.inject.Inject;


@ImplementedBy(MasterAgreementTypeRule.MasterAgreementTypeRuleDefault.class)
public abstract class MasterAgreementTypeRule implements ReportFunction<TransactionReportInstruction, MasterAgreementEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected drr.regulation.common.trade.contract.reports.MasterAgreementTypeRule masterAgreementTypeRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public MasterAgreementEnum evaluate(TransactionReportInstruction input) {
		MasterAgreementEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract MasterAgreementEnum doEvaluate(TransactionReportInstruction input);

	public static class MasterAgreementTypeRuleDefault extends MasterAgreementTypeRule {
		@Override
		protected MasterAgreementEnum doEvaluate(TransactionReportInstruction input) {
			MasterAgreementEnum output = null;
			return assignOutput(output, input);
		}
		
		protected MasterAgreementEnum assignOutput(MasterAgreementEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = MapperS.of(masterAgreementTypeRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
