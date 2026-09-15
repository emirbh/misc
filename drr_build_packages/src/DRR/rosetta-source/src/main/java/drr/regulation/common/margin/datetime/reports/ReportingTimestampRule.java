package drr.regulation.common.margin.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportableInformationBase;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iosco.cde.version1.datetime.functions.ReportingTimestampFromReportableInformation;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ReportingTimestampRule.ReportingTimestampRuleDefault.class)
public abstract class ReportingTimestampRule implements ReportFunction<CollateralReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ReportingTimestampFromReportableInformation reportingTimestampFromReportableInformation;

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

	public static class ReportingTimestampRuleDefault extends ReportingTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(CollateralReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(reportingTimestampFromReportableInformation.evaluate(item.<ReportableInformationBase>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get()))).get();
			
			return output;
		}
	}
}
