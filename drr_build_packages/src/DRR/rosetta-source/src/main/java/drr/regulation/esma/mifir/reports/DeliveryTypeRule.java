package drr.regulation.esma.mifir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;


@ImplementedBy(DeliveryTypeRule.DeliveryTypeRuleDefault.class)
public abstract class DeliveryTypeRule implements ReportFunction<TransactionReportInstruction, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class DeliveryTypeRuleDefault extends DeliveryTypeRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of("Not Modelled")).get();
			
			return output;
		}
	}
}
