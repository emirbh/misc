package drr.regulation.common.margin.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iosco.cde.version2.collateral.reports.ExcessCollateralPostedByTheReportingCounterpartyRule;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(ExcessCollateralPostedByTheCounterparty1Rule.ExcessCollateralPostedByTheCounterparty1RuleDefault.class)
public abstract class ExcessCollateralPostedByTheCounterparty1Rule implements ReportFunction<CollateralReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExcessCollateralPostedByTheReportingCounterpartyRule excessCollateralPostedByTheReportingCounterpartyRule;

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

	public static class ExcessCollateralPostedByTheCounterparty1RuleDefault extends ExcessCollateralPostedByTheCounterparty1Rule {
		@Override
		protected BigDecimal doEvaluate(CollateralReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, CollateralReportInstruction input) {
			output = excessCollateralPostedByTheReportingCounterpartyRule.evaluate(input);
			
			return output;
		}
	}
}
