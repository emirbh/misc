package drr.regulation.common.margin.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.CollateralReportInstruction;
import java.time.ZonedDateTime;


@ImplementedBy(EventTimestampRule.EventTimestampRuleDefault.class)
public abstract class EventTimestampRule implements ReportFunction<CollateralReportInstruction, ZonedDateTime> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(CollateralReportInstruction input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(CollateralReportInstruction input);

	public static class EventTimestampRuleDefault extends EventTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(CollateralReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, CollateralReportInstruction input) {
			output = MapperS.of(input).<CollateralDetails>map("getCollateralDetails", collateralReportInstruction -> collateralReportInstruction.getCollateralDetails()).<ZonedDateTime>map("getCollateralTimestamp", collateralDetails -> collateralDetails.getCollateralTimestamp()).get();
			
			return output;
		}
	}
}
