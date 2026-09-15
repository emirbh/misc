package drr.standards.iosco.cde.version1.datetime.reports;

import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestampQualificationEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.ReportableInformationBase;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExecutionTimestampRule.ExecutionTimestampRuleDefault.class)
public abstract class ExecutionTimestampRule implements ReportFunction<ReportableEventBase, ZonedDateTime> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(ReportableEventBase input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(ReportableEventBase input);

	public static class ExecutionTimestampRuleDefault extends ExecutionTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(ReportableEventBase input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, ReportableEventBase input) {
			if (exists(MapperS.of(input).<ReportableInformationBase>map("getReportableInformation", reportableEventBase -> reportableEventBase.getReportableInformation()).<ZonedDateTime>map("getOriginalExecutionTimestamp", reportableInformationBase -> reportableInformationBase.getOriginalExecutionTimestamp())).getOrDefault(false)) {
				output = MapperS.of(input).<ReportableInformationBase>map("getReportableInformation", reportableEventBase -> reportableEventBase.getReportableInformation()).<ZonedDateTime>map("getOriginalExecutionTimestamp", reportableInformationBase -> reportableInformationBase.getOriginalExecutionTimestamp()).get();
			} else {
				final MapperC<EventTimestamp> thenArg0 = MapperS.of(input).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<EventTimestamp>mapC("getTimestamp", workflowStep -> workflowStep.getTimestamp())
					.filterItemNullSafe(item -> areEqual(item.<EventTimestampQualificationEnum>map("getQualification", eventTimestamp -> eventTimestamp.getQualification()), MapperS.of(EventTimestampQualificationEnum.EXECUTION_DATE_TIME), CardinalityOperator.All).get());
				final MapperC<ZonedDateTime> thenArg1 = thenArg0
					.mapItem(item -> item.<ZonedDateTime>map("getDateTime", eventTimestamp -> eventTimestamp.getDateTime()));
				output = MapperS.of(thenArg1.get()).get();
			}
			
			return output;
		}
	}
}
