package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeVALU;
import drr.regulation.common.TransactionReportInstruction;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(DeltaRule.DeltaRuleDefault.class)
public abstract class DeltaRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.quantity.reports.DeltaRule deltaRule;
	@Inject protected IsActionTypeVALU isActionTypeVALU;

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

	public static class DeltaRuleDefault extends DeltaRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isActionTypeVALU.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(deltaRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
