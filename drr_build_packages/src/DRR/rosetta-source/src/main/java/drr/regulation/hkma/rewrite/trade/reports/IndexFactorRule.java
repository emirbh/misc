package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(IndexFactorRule.IndexFactorRuleDefault.class)
public abstract class IndexFactorRule implements ReportFunction<TransactionReportInstruction, List<BigDecimal>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.index.reports.IndexFactorRule indexFactorRule;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<BigDecimal> evaluate(TransactionReportInstruction input) {
		List<BigDecimal> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<BigDecimal> doEvaluate(TransactionReportInstruction input);

	public static class IndexFactorRuleDefault extends IndexFactorRule {
		@Override
		protected List<BigDecimal> doEvaluate(TransactionReportInstruction input) {
			List<BigDecimal> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<BigDecimal> assignOutput(List<BigDecimal> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = thenArg
				.mapSingleToList(item -> MapperC.<BigDecimal>of(indexFactorRule.evaluate(item.get()))).getMulti();
			
			return output;
		}
	}
}
