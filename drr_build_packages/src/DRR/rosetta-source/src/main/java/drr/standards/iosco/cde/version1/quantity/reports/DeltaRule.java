package drr.standards.iosco.cde.version1.quantity.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.valuation.functions.GetValuation;
import drr.standards.iosco.cde.version1.quantity.functions.DeltaFromValuation;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(DeltaRule.DeltaRuleDefault.class)
public abstract class DeltaRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DeltaFromValuation deltaFromValuation;
	@Inject protected GetValuation getValuation;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstructionBase input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstructionBase input);

	public static class DeltaRuleDefault extends DeltaRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(deltaFromValuation.evaluate(getValuation.evaluate(item.get())))).get();
			
			return output;
		}
	}
}
