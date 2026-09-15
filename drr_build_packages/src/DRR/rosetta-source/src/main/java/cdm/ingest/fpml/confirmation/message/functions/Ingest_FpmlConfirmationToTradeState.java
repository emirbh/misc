package cdm.ingest.fpml.confirmation.message.functions;

import cdm.event.common.TradeState;
import cdm.ingest.fpml.confirmation.message.labels.Ingest_FpmlConfirmationToTradeStateLabelProvider;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.transform.Ingest;
import com.rosetta.model.lib.transform.SerializationFormat;
import fpml.consolidated.confirmation.processes.ConfirmationAgreed;
import fpml.consolidated.confirmation.processes.ExecutionNotification;
import fpml.consolidated.confirmation.processes.RequestClearing;
import fpml.consolidated.confirmation.processes.RequestConfirmation;
import fpml.consolidated.doc.Document;
import fpml.consolidated.main.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@RuneLabelProvider(labelProvider=Ingest_FpmlConfirmationToTradeStateLabelProvider.class)
@Ingest(format = SerializationFormat.XML)
@ImplementedBy(Ingest_FpmlConfirmationToTradeState.Ingest_FpmlConfirmationToTradeStateDefault.class)
public abstract class Ingest_FpmlConfirmationToTradeState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapConfirmationAgreedToTradeState mapConfirmationAgreedToTradeState;
	@Inject protected MapDataDocumentToTradeState mapDataDocumentToTradeState;
	@Inject protected MapExecutionNotificationToTradeState mapExecutionNotificationToTradeState;
	@Inject protected MapRequestClearingToTradeState mapRequestClearingToTradeState;
	@Inject protected MapRequestConfirmationToTradeState mapRequestConfirmationToTradeState;

	/**
	* @param fpmlDocument 
	* @return tradeState 
	*/
	public TradeState evaluate(Document fpmlDocument) {
		TradeState.TradeStateBuilder tradeStateBuilder = doEvaluate(fpmlDocument);
		
		final TradeState tradeState;
		if (tradeStateBuilder == null) {
			tradeState = null;
		} else {
			tradeState = tradeStateBuilder.build();
			objectValidator.validate(TradeState.class, tradeState);
		}
		
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(Document fpmlDocument);

	public static class Ingest_FpmlConfirmationToTradeStateDefault extends Ingest_FpmlConfirmationToTradeState {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(Document fpmlDocument) {
			TradeState.TradeStateBuilder tradeState = TradeState.builder();
			return assignOutput(tradeState, fpmlDocument);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, Document fpmlDocument) {
			if (fpmlDocument == null) {
				tradeState = null;
			} else if (fpmlDocument instanceof ConfirmationAgreed) {
				final ConfirmationAgreed confirmationAgreed = (ConfirmationAgreed) fpmlDocument;
				tradeState = toBuilder(mapConfirmationAgreedToTradeState.evaluate(confirmationAgreed));
			} else if (fpmlDocument instanceof DataDocument) {
				final DataDocument dataDocument = (DataDocument) fpmlDocument;
				tradeState = toBuilder(mapDataDocumentToTradeState.evaluate(dataDocument));
			} else if (fpmlDocument instanceof ExecutionNotification) {
				final ExecutionNotification executionNotification = (ExecutionNotification) fpmlDocument;
				tradeState = toBuilder(mapExecutionNotificationToTradeState.evaluate(executionNotification));
			} else if (fpmlDocument instanceof RequestClearing) {
				final RequestClearing requestClearing = (RequestClearing) fpmlDocument;
				tradeState = toBuilder(mapRequestClearingToTradeState.evaluate(requestClearing));
			} else if (fpmlDocument instanceof RequestConfirmation) {
				final RequestConfirmation requestConfirmation = (RequestConfirmation) fpmlDocument;
				tradeState = toBuilder(mapRequestConfirmationToTradeState.evaluate(requestConfirmation));
			} else {
				tradeState = null;
			}
			
			return Optional.ofNullable(tradeState)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
