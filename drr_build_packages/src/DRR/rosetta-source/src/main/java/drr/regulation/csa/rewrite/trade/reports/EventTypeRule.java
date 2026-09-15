package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.standards.iso.EventTypeEnum;
import javax.inject.Inject;


@ImplementedBy(EventTypeRule.EventTypeRuleDefault.class)
public abstract class EventTypeRule implements ReportFunction<TransactionReportInstruction, EventTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.event.reports.EventTypeRule eventTypeRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public EventTypeEnum evaluate(TransactionReportInstruction input) {
		EventTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract EventTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class EventTypeRuleDefault extends EventTypeRule {
		@Override
		protected EventTypeEnum doEvaluate(TransactionReportInstruction input) {
			EventTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected EventTypeEnum assignOutput(EventTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = MapperS.of(eventTypeRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
