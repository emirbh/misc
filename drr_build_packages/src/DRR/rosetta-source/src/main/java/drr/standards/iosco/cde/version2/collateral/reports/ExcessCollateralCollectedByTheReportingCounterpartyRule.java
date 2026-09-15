package drr.standards.iosco.cde.version2.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralReportInstructionBase;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(ExcessCollateralCollectedByTheReportingCounterpartyRule.ExcessCollateralCollectedByTheReportingCounterpartyRuleDefault.class)
public abstract class ExcessCollateralCollectedByTheReportingCounterpartyRule implements ReportFunction<CollateralReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.collateral.reports.ExcessCollateralCollectedByTheReportingCounterpartyRule excessCollateralCollectedByTheReportingCounterpartyRule;

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

	public static class ExcessCollateralCollectedByTheReportingCounterpartyRuleDefault extends ExcessCollateralCollectedByTheReportingCounterpartyRule {
		@Override
		protected BigDecimal doEvaluate(CollateralReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, CollateralReportInstructionBase input) {
			output = excessCollateralCollectedByTheReportingCounterpartyRule.evaluate(input);
			
			return output;
		}
	}
}
