package drr.regulation.common.valuation.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;
import javax.inject.Inject;


@ImplementedBy(EventDateRule.EventDateRuleDefault.class)
public abstract class EventDateRule implements ReportFunction<ValuationReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ValuationTimestampRule valuationTimestampRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(ValuationReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(ValuationReportInstruction input);

	public static class EventDateRuleDefault extends EventDateRule {
		@Override
		protected Date doEvaluate(ValuationReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(valuationTimestampRule.evaluate(item.get())).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate()))).get();
			
			return output;
		}
	}
}
