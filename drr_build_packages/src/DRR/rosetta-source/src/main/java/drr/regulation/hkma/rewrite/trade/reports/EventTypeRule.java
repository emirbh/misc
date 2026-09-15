package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.EventTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EventTypeRule.EventTypeRuleDefault.class)
public abstract class EventTypeRule implements ReportFunction<TransactionReportInstruction, EventTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.event.reports.EventTypeRule eventTypeRule;

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
			if (notEqual(MapperS.of(eventTypeRule.evaluate(input)), MapperS.of(EventTypeEnum.INCP), CardinalityOperator.Any).getOrDefault(false)) {
				output = MapperS.of(input)
					.mapSingleToItem(item -> MapperS.of(eventTypeRule.evaluate(item.get()))).get();
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
