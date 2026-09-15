package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.functions.TotalNotionalQuantityLeg2;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(TotalNotionalQuantityLeg2Rule.TotalNotionalQuantityLeg2RuleDefault.class)
public abstract class TotalNotionalQuantityLeg2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected TotalNotionalQuantityLeg2 totalNotionalQuantityLeg2;

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

	public static class TotalNotionalQuantityLeg2RuleDefault extends TotalNotionalQuantityLeg2Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = MapperS.of(totalNotionalQuantityLeg2.evaluate(thenArg.get(), null)).get();
			
			return output;
		}
	}
}
