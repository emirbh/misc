package drr.regulation.common.functions;

import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestampQualificationEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.ReportableEvent;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetModificationTimestamp.GetModificationTimestampDefault.class)
public abstract class GetModificationTimestamp implements RosettaFunction {

	/**
	* @param reportableEvent 
	* @return modificationTime 
	*/
	public ZonedDateTime evaluate(ReportableEvent reportableEvent) {
		ZonedDateTime modificationTime = doEvaluate(reportableEvent);
		
		return modificationTime;
	}

	protected abstract ZonedDateTime doEvaluate(ReportableEvent reportableEvent);

	public static class GetModificationTimestampDefault extends GetModificationTimestamp {
		@Override
		protected ZonedDateTime doEvaluate(ReportableEvent reportableEvent) {
			ZonedDateTime modificationTime = null;
			return assignOutput(modificationTime, reportableEvent);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime modificationTime, ReportableEvent reportableEvent) {
			final MapperC<EventTimestamp> thenArg0 = MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).<EventTimestamp>mapC("getTimestamp", workflowStep -> workflowStep.getTimestamp())
				.filterItemNullSafe(item -> areEqual(item.<EventTimestampQualificationEnum>map("getQualification", eventTimestamp -> eventTimestamp.getQualification()), MapperS.of(EventTimestampQualificationEnum.EXECUTION_DATE_TIME), CardinalityOperator.All).get());
			final MapperC<ZonedDateTime> thenArg1 = thenArg0
				.mapItem(item -> item.<ZonedDateTime>map("getDateTime", eventTimestamp -> eventTimestamp.getDateTime()));
			modificationTime = thenArg1
				.max().get();
			
			return modificationTime;
		}
	}
}
