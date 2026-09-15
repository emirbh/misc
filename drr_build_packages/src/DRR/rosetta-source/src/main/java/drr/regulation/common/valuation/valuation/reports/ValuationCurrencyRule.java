package drr.regulation.common.valuation.valuation.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.event.common.Valuation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.standards.iosco.cde.version1.valuation.functions.ValuationCurrencyFromValuation;
import javax.inject.Inject;


@ImplementedBy(ValuationCurrencyRule.ValuationCurrencyRuleDefault.class)
public abstract class ValuationCurrencyRule implements ReportFunction<ValuationReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ValuationCurrencyFromValuation valuationCurrencyFromValuation;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(ValuationReportInstruction input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(ValuationReportInstruction input);

	public static class ValuationCurrencyRuleDefault extends ValuationCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(ValuationReportInstruction input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(valuationCurrencyFromValuation.evaluate(item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<Valuation>map("getValuation", valuationDetails -> valuationDetails.getValuation()).get()))).get();
			
			return output;
		}
	}
}
