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

@ImplementedBy(IsMicXXXX.IsMicXXXXDefault.class)
public abstract class IsMicXXXX implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetTransactionInformationForRegime getTransactionInformationForRegime;
	@Inject protected GetVenueOfExecution getVenueOfExecution;

	/**
	* @param transaction 
	* @return isMicXXXX 
	*/
	public Boolean evaluate(TransactionReportInstruction transaction) {
		Boolean isMicXXXX = doEvaluate(transaction);
		
		return isMicXXXX;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction transaction);

	public static class IsMicXXXXDefault extends IsMicXXXX {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction transaction) {
			Boolean isMicXXXX = null;
			return assignOutput(isMicXXXX, transaction);
		}
		
		protected Boolean assignOutput(Boolean isMicXXXX, TransactionReportInstruction transaction) {
			isMicXXXX = notExists(MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformation -> reportableInformation.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData())).andNullSafe(notExists(MapperS.of(getVenueOfExecution.evaluate(MapperS.of(transaction).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get())))).andNullSafe(areEqual(MapperS.of(getTransactionInformationForRegime.evaluate(transaction, RegimeNameEnum.EMIR, SupervisoryBodyEnum.ESMA)).<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<TradableOnTradingVenueEnum>map("getTradableOnTradingVenue", transactionInformation -> transactionInformation.getTradableOnTradingVenue()), MapperS.of(TradableOnTradingVenueEnum.NOT_ADMITTED), CardinalityOperator.All)).get();
			
			return isMicXXXX;
		}
	}
}
