package drr.regulation.common.valuation.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ValuationReportInstruction;
import drr.standards.iosco.cde.version1.datetime.functions.ReportingTimestampFromReportableInformation;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ReportingTimestampRule.ReportingTimestampRuleDefault.class)
public abstract class ReportingTimestampRule implements ReportFunction<ValuationReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ReportingTimestampFromReportableInformation reportingTimestampFromReportableInformation;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(ValuationReportInstruction input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(ValuationReportInstruction input);

	public static class ReportingTimestampRuleDefault extends ReportingTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(ValuationReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(reportingTimestampFromReportableInformation.evaluate(item.<ReportableInformation>map("getReportableInformation", valuationReportInstruction -> valuationReportInstruction.getReportableInformation()).get()))).get();
			
			return output;
		}
	}
}
