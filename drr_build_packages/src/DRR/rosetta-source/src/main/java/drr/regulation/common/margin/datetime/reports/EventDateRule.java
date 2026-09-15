package drr.regulation.common.margin.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.CollateralReportInstruction;
import java.time.ZonedDateTime;


@ImplementedBy(EventDateRule.EventDateRuleDefault.class)
public abstract class EventDateRule implements ReportFunction<CollateralReportInstruction, Date> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(CollateralReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(CollateralReportInstruction input);

	public static class EventDateRuleDefault extends EventDateRule {
		@Override
		protected Date doEvaluate(CollateralReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, CollateralReportInstruction input) {
			output = MapperS.of(input).<CollateralDetails>map("getCollateralDetails", collateralReportInstruction -> collateralReportInstruction.getCollateralDetails()).<ZonedDateTime>map("getCollateralTimestamp", collateralDetails -> collateralDetails.getCollateralTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get();
			
			return output;
		}
	}
}
