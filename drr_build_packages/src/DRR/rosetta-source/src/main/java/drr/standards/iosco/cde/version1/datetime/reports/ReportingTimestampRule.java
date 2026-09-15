package drr.standards.iosco.cde.version1.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version1.datetime.functions.ReportingTimestampFromReportableInformation;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ReportingTimestampRule.ReportingTimestampRuleDefault.class)
public abstract class ReportingTimestampRule implements ReportFunction<TransactionReportInstructionBase, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ReportingTimestampFromReportableInformation reportingTimestampFromReportableInformation;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(TransactionReportInstructionBase input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(TransactionReportInstructionBase input);

	public static class ReportingTimestampRuleDefault extends ReportingTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstructionBase input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(reportingTimestampFromReportableInformation.evaluate(item.<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).get()))).get();
			
			return output;
		}
	}
}
