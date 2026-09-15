package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.emir.contract.functions.EMIRClearingObligation;
import drr.standards.iso.ClearingObligationEnum;
import javax.inject.Inject;


@ImplementedBy(ClearingObligationRule.ClearingObligationRuleDefault.class)
public abstract class ClearingObligationRule implements ReportFunction<TransactionReportInstruction, ClearingObligationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EMIRClearingObligation eMIRClearingObligation;
	@Inject protected IsAllowableAction isAllowableAction;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ClearingObligationEnum evaluate(TransactionReportInstruction input) {
		ClearingObligationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ClearingObligationEnum doEvaluate(TransactionReportInstruction input);

	public static class ClearingObligationRuleDefault extends ClearingObligationRule {
		@Override
		protected ClearingObligationEnum doEvaluate(TransactionReportInstruction input) {
			ClearingObligationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ClearingObligationEnum assignOutput(ClearingObligationEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(eMIRClearingObligation.evaluate(item.get(), RegimeNameEnum.EMIR, SupervisoryBodyEnum.ESMA))).get();
			
			return output;
		}
	}
}
