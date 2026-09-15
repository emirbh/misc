package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;


@ImplementedBy(MasterAgreementTypeRule.MasterAgreementTypeRuleDefault.class)
public abstract class MasterAgreementTypeRule implements ReportFunction<TransactionReportInstruction, MasterAgreementEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
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
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(masterAgreementTypeRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
