package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeCORR;
import drr.base.qualification.event.functions.IsActionTypeNEWT;
import drr.base.qualification.event.functions.IsActionTypePOSC;
import drr.base.qualification.event.functions.IsActionTypeREVI;
import drr.base.qualification.event.functions.IsActionTypeVALU;
import drr.regulation.common.TransactionReportInstruction;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(ValuationAmountRule.ValuationAmountRuleDefault.class)
public abstract class ValuationAmountRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeCORR isActionTypeCORR;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
	@Inject protected IsActionTypePOSC isActionTypePOSC;
	@Inject protected IsActionTypeREVI isActionTypeREVI;
	@Inject protected IsActionTypeVALU isActionTypeVALU;
	@Inject protected drr.standards.iosco.cde.version3.valuation.reports.ValuationAmountRule valuationAmountRule;

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

	public static class ValuationAmountRuleDefault extends ValuationAmountRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isActionTypeNEWT.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeVALU.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeCORR.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeREVI.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePOSC.evaluate(item.get())))).get());
			output = MapperS.of(valuationAmountRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
