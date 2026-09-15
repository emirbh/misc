package drr.standards.iosco.cde.version2.collateral.functions;

import cdm.base.staticdata.party.Party;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.margin.ReportableCollateralBase;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(InitialMarginPostedByReportingCounterpartyPostHaircut.InitialMarginPostedByReportingCounterpartyPostHaircutDefault.class)
public abstract class InitialMarginPostedByReportingCounterpartyPostHaircut implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.collateral.functions.InitialMarginPostedByReportingCounterpartyPostHaircut initialMarginPostedByReportingCounterpartyPostHaircut;

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

	public static class InitialMarginPostedByReportingCounterpartyPostHaircutDefault extends InitialMarginPostedByReportingCounterpartyPostHaircut {
		@Override
		protected BigDecimal doEvaluate(ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			BigDecimal marginValue = null;
			return assignOutput(marginValue, reportableCollateral, reportingCounterparty);
		}
		
		protected BigDecimal assignOutput(BigDecimal marginValue, ReportableCollateralBase reportableCollateral, Party reportingCounterparty) {
			marginValue = initialMarginPostedByReportingCounterpartyPostHaircut.evaluate(reportableCollateral, reportingCounterparty);
			
			return marginValue;
		}
	}
}
