package drr.standards.iosco.cde.version3.collateral.functions;

import cdm.base.staticdata.party.Party;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.margin.ReportableCollateralBase;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(VariationMarginPostedByReportingCounterpartyPreHaircut.VariationMarginPostedByReportingCounterpartyPreHaircutDefault.class)
public abstract class VariationMarginPostedByReportingCounterpartyPreHaircut implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.collateral.functions.VariationMarginPostedByReportingCounterpartyPreHaircut variationMarginPostedByReportingCounterpartyPreHaircut;

	/**
	* @param reportableCollateral 
	* @param reportingCounterparty 
	* @return marginValue 
	*/
	public BigDecimal evaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
		BigDecimal marginValue = doEvaluate(reportableCollateral, reportingCounterparty);
		
		return marginValue;
	}

	protected abstract BigDecimal doEvaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty);

	public static class VariationMarginPostedByReportingCounterpartyPreHaircutDefault extends VariationMarginPostedByReportingCounterpartyPreHaircut {
		@Override
		protected BigDecimal doEvaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			BigDecimal marginValue = null;
			return assignOutput(marginValue, reportableCollateral, reportingCounterparty);
		}
		
		protected BigDecimal assignOutput(BigDecimal marginValue, ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			marginValue = variationMarginPostedByReportingCounterpartyPreHaircut.evaluate(reportableCollateral, reportingCounterparty);
			
			return marginValue;
		}
	}
}
