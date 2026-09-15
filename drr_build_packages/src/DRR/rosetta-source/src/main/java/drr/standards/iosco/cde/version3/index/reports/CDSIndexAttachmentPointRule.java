package drr.standards.iosco.cde.version3.index.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(CDSIndexAttachmentPointRule.CDSIndexAttachmentPointRuleDefault.class)
public abstract class CDSIndexAttachmentPointRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.index.reports.CDSIndexAttachmentPointRule cDSIndexAttachmentPointRule;

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

	public static class CDSIndexAttachmentPointRuleDefault extends CDSIndexAttachmentPointRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstructionBase input) {
			output = cDSIndexAttachmentPointRule.evaluate(input);
			
			return output;
		}
	}
}
