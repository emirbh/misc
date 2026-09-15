package drr.standards.iosco.cde.version3.collateral.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.Party;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.margin.ReportableCollateralBase;
import javax.inject.Inject;


@ImplementedBy(InitialMarginPostedByReportingCounterpartyCurrency.InitialMarginPostedByReportingCounterpartyCurrencyDefault.class)
public abstract class InitialMarginPostedByReportingCounterpartyCurrency implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.collateral.functions.InitialMarginPostedByReportingCounterpartyCurrency initialMarginPostedByReportingCounterpartyCurrency;

	/**
	* @param reportableCollateral 
	* @param reportingCounterparty 
	* @return marginCurrency 
	*/
	public ISOCurrencyCodeEnum evaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
		ISOCurrencyCodeEnum marginCurrency = doEvaluate(reportableCollateral, reportingCounterparty);
		
		return marginCurrency;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty);

	public static class InitialMarginPostedByReportingCounterpartyCurrencyDefault extends InitialMarginPostedByReportingCounterpartyCurrency {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			ISOCurrencyCodeEnum marginCurrency = null;
			return assignOutput(marginCurrency, reportableCollateral, reportingCounterparty);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum marginCurrency, ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			marginCurrency = initialMarginPostedByReportingCounterpartyCurrency.evaluate(reportableCollateral, reportingCounterparty);
			
			return marginCurrency;
		}
	}
}
