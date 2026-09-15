package drr.standards.iosco.cde.version3.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralReportInstructionBase;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(ExcessCollateralPostedByTheReportingCounterpartyRule.ExcessCollateralPostedByTheReportingCounterpartyRuleDefault.class)
public abstract class ExcessCollateralPostedByTheReportingCounterpartyRule implements ReportFunction<CollateralReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.collateral.reports.ExcessCollateralPostedByTheReportingCounterpartyRule excessCollateralPostedByTheReportingCounterpartyRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(CollateralReportInstructionBase input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(CollateralReportInstructionBase input);

	public static class ExcessCollateralPostedByTheReportingCounterpartyRuleDefault extends ExcessCollateralPostedByTheReportingCounterpartyRule {
		@Override
		protected BigDecimal doEvaluate(CollateralReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, CollateralReportInstructionBase input) {
			output = excessCollateralPostedByTheReportingCounterpartyRule.evaluate(input);
			
			return output;
		}
	}
}
