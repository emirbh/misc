package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.emir.contract.functions.ExecutionVenue;
import javax.inject.Inject;


@ImplementedBy(VenueOfExecutionRule.VenueOfExecutionRuleDefault.class)
public abstract class VenueOfExecutionRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExecutionVenue executionVenue;
	@Inject protected IsAllowableAction isAllowableAction;

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

	public static class VenueOfExecutionRuleDefault extends VenueOfExecutionRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(executionVenue.evaluate(item.get(), RegimeNameEnum.EMIR))).get();
			
			return output;
		}
	}
}
