package drr.regulation.cftc.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.functions.ChangeInNotionalAmountLeg2;
import drr.regulation.common.TransactionReportInstruction;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(DTCC_ChangeInNotionalAmount2Rule.DTCC_ChangeInNotionalAmount2RuleDefault.class)
public abstract class DTCC_ChangeInNotionalAmount2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ChangeInNotionalAmountLeg2 changeInNotionalAmountLeg2;

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

	public static class DTCC_ChangeInNotionalAmount2RuleDefault extends DTCC_ChangeInNotionalAmount2Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(changeInNotionalAmountLeg2.evaluate(item.get(), new BigDecimal("99999999999999999999.99999")))).get();
			
			return output;
		}
	}
}
