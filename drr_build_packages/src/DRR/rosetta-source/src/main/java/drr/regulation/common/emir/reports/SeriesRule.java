package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(SeriesRule.SeriesRuleDefault.class)
public abstract class SeriesRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected drr.regulation.common.trade.index.reports.SeriesRule seriesRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstruction input);

	public static class SeriesRuleDefault extends SeriesRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(seriesRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
