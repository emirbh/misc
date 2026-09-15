package drr.regulation.common.trade.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetExpirationDate;
import javax.inject.Inject;


@ImplementedBy(ExpirationDateRule.ExpirationDateRuleDefault.class)
public abstract class ExpirationDateRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetExpirationDate getExpirationDate;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstruction input);

	public static class ExpirationDateRuleDefault extends ExpirationDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(getExpirationDate.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
