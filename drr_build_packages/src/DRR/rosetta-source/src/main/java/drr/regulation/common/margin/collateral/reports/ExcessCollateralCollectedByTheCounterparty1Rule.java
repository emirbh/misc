package drr.regulation.common.margin.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iosco.cde.version2.collateral.reports.ExcessCollateralCollectedByTheReportingCounterpartyRule;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(ExcessCollateralCollectedByTheCounterparty1Rule.ExcessCollateralCollectedByTheCounterparty1RuleDefault.class)
public abstract class ExcessCollateralCollectedByTheCounterparty1Rule implements ReportFunction<CollateralReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExcessCollateralCollectedByTheReportingCounterpartyRule excessCollateralCollectedByTheReportingCounterpartyRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(CollateralReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(CollateralReportInstruction input);

	public static class ExcessCollateralCollectedByTheCounterparty1RuleDefault extends ExcessCollateralCollectedByTheCounterparty1Rule {
		@Override
		protected BigDecimal doEvaluate(CollateralReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, CollateralReportInstruction input) {
			output = excessCollateralCollectedByTheReportingCounterpartyRule.evaluate(input);
			
			return output;
		}
	}
}
