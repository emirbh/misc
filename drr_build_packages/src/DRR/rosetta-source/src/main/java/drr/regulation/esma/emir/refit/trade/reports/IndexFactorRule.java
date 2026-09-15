package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.functions.FormatToBaseOneRate;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(IndexFactorRule.IndexFactorRuleDefault.class)
public abstract class IndexFactorRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToBaseOneRate formatToBaseOneRate;
	@Inject protected drr.regulation.common.trade.index.reports.IndexFactorRule indexFactorRule;
	@Inject protected IsAllowableAction isAllowableAction;

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

	public static class IndexFactorRuleDefault extends IndexFactorRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperC<BigDecimal> thenArg1 = thenArg0
				.mapSingleToList(item -> MapperC.<BigDecimal>of(indexFactorRule.evaluate(item.get())));
			output = MapperS.of(formatToBaseOneRate.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
