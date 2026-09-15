package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.IsReturnorPayoutTriggerCFD;
import javax.inject.Inject;


@ImplementedBy(ReturnorPayoutTriggerRule.ReturnorPayoutTriggerRuleDefault.class)
public abstract class ReturnorPayoutTriggerRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsReturnorPayoutTriggerCFD isReturnorPayoutTriggerCFD;

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

	public static class ReturnorPayoutTriggerRuleDefault extends ReturnorPayoutTriggerRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final Boolean _boolean = isReturnorPayoutTriggerCFD.evaluate(item.get());
					if ((_boolean == null ? false : _boolean)) {
						return MapperS.of("Contract_for_Difference_CFD_");
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
