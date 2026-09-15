package drr.standards.iosco.cde.version1.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralReportInstructionBase;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(ExcessCollateralCollectedByTheReportingCounterpartyRule.ExcessCollateralCollectedByTheReportingCounterpartyRuleDefault.class)
public abstract class ExcessCollateralCollectedByTheReportingCounterpartyRule implements ReportFunction<CollateralReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;

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
			final MapperS<Integer> thenArg = MapperS.of(0);
			final Integer integer = thenArg.get();
			output = MapperS.of(formatToShortFraction5DecimalNumber.evaluate((integer == null ? null : BigDecimal.valueOf(integer)))).get();
			
			return output;
		}
	}
}
