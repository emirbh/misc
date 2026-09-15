package drr.regulation.common.valuation.datetime.reports;

import cdm.event.common.Valuation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import java.time.ZonedDateTime;


@ImplementedBy(ValuationTimestampRule.ValuationTimestampRuleDefault.class)
public abstract class ValuationTimestampRule implements ReportFunction<ValuationReportInstruction, ZonedDateTime> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(ValuationReportInstruction input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(ValuationReportInstruction input);

	public static class ValuationTimestampRuleDefault extends ValuationTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(ValuationReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<Valuation>map("getValuation", valuationDetails -> valuationDetails.getValuation()).<ZonedDateTime>map("getTimestamp", valuation -> valuation.getTimestamp())).get();
			
			return output;
		}
	}
}
