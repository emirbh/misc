package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TradableOnTradingVenueEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetTransactionInformationForRegime;
import drr.regulation.common.functions.GetVenueOfExecution;
import drr.standards.iso.MicData;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsMicXOFF.IsMicXOFFDefault.class)
public abstract class IsMicXOFF implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetTransactionInformationForRegime getTransactionInformationForRegime;
	@Inject protected GetVenueOfExecution getVenueOfExecution;

	/**
	* @param transaction 
	* @return isMicXOFF 
	*/
	public Boolean evaluate(TransactionReportInstruction transaction) {
		Boolean isMicXOFF = doEvaluate(transaction);
		
		return isMicXOFF;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction transaction);

	public static class IsMicXOFFDefault extends IsMicXOFF {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction transaction) {
			Boolean isMicXOFF = null;
			return assignOutput(isMicXOFF, transaction);
		}
		
		protected Boolean assignOutput(Boolean isMicXOFF, TransactionReportInstruction transaction) {
			isMicXOFF = notExists(MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformation -> reportableInformation.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData())).andNullSafe(notExists(MapperS.of(getVenueOfExecution.evaluate(MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get())))).andNullSafe(areEqual(MapperS.of(getTransactionInformationForRegime.evaluate(transaction, RegimeNameEnum.EMIR, SupervisoryBodyEnum.ESMA)).<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<TradableOnTradingVenueEnum>map("getTradableOnTradingVenue", transactionInformation -> transactionInformation.getTradableOnTradingVenue()), MapperS.of(TradableOnTradingVenueEnum.ADMITTED), CardinalityOperator.All)).get();
			
			return isMicXOFF;
		}
	}
}
