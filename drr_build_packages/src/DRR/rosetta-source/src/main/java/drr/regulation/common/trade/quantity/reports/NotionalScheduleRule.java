package drr.regulation.common.trade.quantity.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.IsNotionalScheduleCustom;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import javax.inject.Inject;


@ImplementedBy(NotionalScheduleRule.NotionalScheduleRuleDefault.class)
public abstract class NotionalScheduleRule implements ReportFunction<TransactionReportInstruction, AnnaDsbNotionalScheduleEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsNotionalScheduleCustom isNotionalScheduleCustom;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AnnaDsbNotionalScheduleEnum evaluate(TransactionReportInstruction input) {
		AnnaDsbNotionalScheduleEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract AnnaDsbNotionalScheduleEnum doEvaluate(TransactionReportInstruction input);

	public static class NotionalScheduleRuleDefault extends NotionalScheduleRule {
		@Override
		protected AnnaDsbNotionalScheduleEnum doEvaluate(TransactionReportInstruction input) {
			AnnaDsbNotionalScheduleEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AnnaDsbNotionalScheduleEnum assignOutput(AnnaDsbNotionalScheduleEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(isNotionalScheduleCustom.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
