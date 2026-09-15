package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.regulation.common.ReportableExecutionVenue;
import drr.regulation.common.TransactionInformation;
import fpml.consolidated.business.events.WithdrawalPartyTradeInformation;
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapWithdrawalTransactionInformation.MapWithdrawalTransactionInformationDefault.class)
public abstract class MapWithdrawalTransactionInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlWithdrawalPartyTradeInformation 
	* @param fpmlReportingRegime 
	* @return transactionInformation 
	*/
	public TransactionInformation evaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime) {
		TransactionInformation.TransactionInformationBuilder transactionInformationBuilder = doEvaluate(fpmlWithdrawalPartyTradeInformation, fpmlReportingRegime);
		
		final TransactionInformation transactionInformation;
		if (transactionInformationBuilder == null) {
			transactionInformation = null;
		} else {
			transactionInformation = transactionInformationBuilder.build();
			objectValidator.validate(TransactionInformation.class, transactionInformation);
		}
		
		return transactionInformation;
	}

	protected abstract TransactionInformation.TransactionInformationBuilder doEvaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime);

	public static class MapWithdrawalTransactionInformationDefault extends MapWithdrawalTransactionInformation {
		@Override
		protected TransactionInformation.TransactionInformationBuilder doEvaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime) {
			TransactionInformation.TransactionInformationBuilder transactionInformation = TransactionInformation.builder();
			return assignOutput(transactionInformation, fpmlWithdrawalPartyTradeInformation, fpmlReportingRegime);
		}
		
		protected TransactionInformation.TransactionInformationBuilder assignOutput(TransactionInformation.TransactionInformationBuilder transactionInformation, WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation, ReportingRegimeIdentifier fpmlReportingRegime) {
			transactionInformation = toBuilder(TransactionInformation.builder()
				.setTransactionIdentifier(null)
				.setPriorTransactionIdentifier(null)
				.setReportableExecutionVenue(ReportableExecutionVenue.builder()
					.setExecutionVenueType(ExecutionVenueTypeEnum.OFF_FACILITY)
					.build())
				.setLargeSizeTrade(null)
				.setDuration(null)
				.build());
			
			return Optional.ofNullable(transactionInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
