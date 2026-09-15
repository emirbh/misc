package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsActionTypePRTO;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(EventTimestampRule.EventTimestampRuleDefault.class)
public abstract class EventTimestampRule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.datetime.reports.EventTimestampRule eventTimestampRule;
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsActionTypePRTO isActionTypePRTO;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(TransactionReportInstruction input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(TransactionReportInstruction input);

	public static class EventTimestampRuleDefault extends EventTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForASIC.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeEROR.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePRTO.evaluate(item.get())))).get());
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(eventTimestampRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
