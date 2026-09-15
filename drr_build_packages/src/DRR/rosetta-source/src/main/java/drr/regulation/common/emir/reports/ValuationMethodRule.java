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
import drr.base.trade.valuation.functions.GetValuation;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.ValuationType1Code;
import javax.inject.Inject;


@ImplementedBy(ValuationMethodRule.ValuationMethodRuleDefault.class)
public abstract class ValuationMethodRule implements ReportFunction<TransactionReportInstruction, ValuationType1Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetValuation getValuation;
	@Inject protected IsActionTypeCORR isActionTypeCORR;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
	@Inject protected IsActionTypePOSC isActionTypePOSC;
	@Inject protected IsActionTypeREVI isActionTypeREVI;
	@Inject protected IsActionTypeVALU isActionTypeVALU;
	@Inject protected drr.standards.iosco.cde.version3.valuation.reports.ValuationMethodRule valuationMethodRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ValuationType1Code evaluate(TransactionReportInstruction input) {
		ValuationType1Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract ValuationType1Code doEvaluate(TransactionReportInstruction input);

	public static class ValuationMethodRuleDefault extends ValuationMethodRule {
		@Override
		protected ValuationType1Code doEvaluate(TransactionReportInstruction input) {
			ValuationType1Code output = null;
			return assignOutput(output, input);
		}
		
		protected ValuationType1Code assignOutput(ValuationType1Code output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isActionTypeNEWT.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeVALU.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeCORR.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeREVI.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePOSC.evaluate(item.get())))).get());
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(valuationMethodRule.evaluate(getValuation.evaluate(item.get())))).get();
			
			return output;
		}
	}
}
