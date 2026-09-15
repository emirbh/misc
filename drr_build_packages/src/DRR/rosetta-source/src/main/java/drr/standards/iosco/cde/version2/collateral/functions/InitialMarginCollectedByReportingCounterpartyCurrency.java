package drr.standards.iosco.cde.version2.collateral.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.Party;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.margin.ReportableCollateralBase;
import javax.inject.Inject;


@ImplementedBy(InitialMarginCollectedByReportingCounterpartyCurrency.InitialMarginCollectedByReportingCounterpartyCurrencyDefault.class)
public abstract class InitialMarginCollectedByReportingCounterpartyCurrency implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.collateral.functions.InitialMarginCollectedByReportingCounterpartyCurrency initialMarginCollectedByReportingCounterpartyCurrency;

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

	public static class InitialMarginCollectedByReportingCounterpartyCurrencyDefault extends InitialMarginCollectedByReportingCounterpartyCurrency {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			ISOCurrencyCodeEnum marginCurrency = null;
			return assignOutput(marginCurrency, reportableCollateral, reportingCounterparty);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum marginCurrency, ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			marginCurrency = initialMarginCollectedByReportingCounterpartyCurrency.evaluate(reportableCollateral, reportingCounterparty);
			
			return marginCurrency;
		}
	}
}
