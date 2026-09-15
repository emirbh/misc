package drr.standards.iosco.cde.version1.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.valuation.functions.GetValuation;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ValuationTimestampRule.ValuationTimestampRuleDefault.class)
public abstract class ValuationTimestampRule implements ReportFunction<TransactionReportInstructionBase, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetValuation getValuation;

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

	public static class ValuationTimestampRuleDefault extends ValuationTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstructionBase input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(getValuation.evaluate(item.get())).<ZonedDateTime>map("getTimestamp", valuation -> valuation.getTimestamp())).get();
			
			return output;
		}
	}
}
