package drr.standards.iosco.cde.version1.datetime.functions;

import cdm.base.datetime.functions.Now;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.ReportableInformationBase;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ReportingTimestampFromReportableInformation.ReportingTimestampFromReportableInformationDefault.class)
public abstract class ReportingTimestampFromReportableInformation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Now now;

	/**
	* @param reportableInformation 
	* @return reportingTimestamp 
	*/
	public ZonedDateTime evaluate(ReportableInformationBase reportableInformation) {
		ZonedDateTime reportingTimestamp = doEvaluate(reportableInformation);
		
		return reportingTimestamp;
	}

	protected abstract ZonedDateTime doEvaluate(ReportableInformationBase reportableInformation);

	public static class ReportingTimestampFromReportableInformationDefault extends ReportingTimestampFromReportableInformation {
		@Override
		protected ZonedDateTime doEvaluate(ReportableInformationBase reportableInformation) {
			ZonedDateTime reportingTimestamp = null;
			return assignOutput(reportingTimestamp, reportableInformation);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime reportingTimestamp, ReportableInformationBase reportableInformation) {
			reportingTimestamp = now.evaluate();
			
			return reportingTimestamp;
		}
	}
}
