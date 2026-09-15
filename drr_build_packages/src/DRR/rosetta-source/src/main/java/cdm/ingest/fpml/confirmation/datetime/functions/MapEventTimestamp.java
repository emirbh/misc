package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestampQualificationEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.doc.TradeProcessingTimestamps;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapEventTimestamp.MapEventTimestampDefault.class)
public abstract class MapEventTimestamp implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param creationTimestamp 
	* @param fpmlTrade 
	* @return eventTimestamp 
	*/
	public List<? extends EventTimestamp> evaluate(ZonedDateTime creationTimestamp, Trade fpmlTrade) {
		List<EventTimestamp.EventTimestampBuilder> eventTimestampBuilder = doEvaluate(creationTimestamp, fpmlTrade);
		
		final List<? extends EventTimestamp> eventTimestamp;
		if (eventTimestampBuilder == null) {
			eventTimestamp = null;
		} else {
			eventTimestamp = eventTimestampBuilder.stream().map(EventTimestamp::build).collect(Collectors.toList());
			objectValidator.validate(EventTimestamp.class, eventTimestamp);
		}
		
		return eventTimestamp;
	}

	protected abstract List<EventTimestamp.EventTimestampBuilder> doEvaluate(ZonedDateTime creationTimestamp, Trade fpmlTrade);

	protected abstract MapperC<? extends PartyTradeInformation> partyTradeInformation(ZonedDateTime creationTimestamp, Trade fpmlTrade);

	public static class MapEventTimestampDefault extends MapEventTimestamp {
		@Override
		protected List<EventTimestamp.EventTimestampBuilder> doEvaluate(ZonedDateTime creationTimestamp, Trade fpmlTrade) {
			List<EventTimestamp.EventTimestampBuilder> eventTimestamp = new ArrayList<>();
			return assignOutput(eventTimestamp, creationTimestamp, fpmlTrade);
		}
		
		protected List<EventTimestamp.EventTimestampBuilder> assignOutput(List<EventTimestamp.EventTimestampBuilder> eventTimestamp, ZonedDateTime creationTimestamp, Trade fpmlTrade) {
			if (exists(MapperS.of(creationTimestamp)).getOrDefault(false)) {
				final EventTimestamp _eventTimestamp = EventTimestamp.builder()
					.setDateTime(creationTimestamp)
					.setQualification(EventTimestampQualificationEnum.EVENT_CREATION_DATE_TIME)
					.build();
				if (_eventTimestamp == null) {
					eventTimestamp.addAll(toBuilder(Collections.<EventTimestamp>emptyList()));
				} else {
					eventTimestamp.addAll(toBuilder(Collections.singletonList(_eventTimestamp)));
				}
			} else {
				eventTimestamp.addAll(toBuilder(Collections.<EventTimestamp>emptyList()));
			}
			
			eventTimestamp.addAll(toBuilder(partyTradeInformation(creationTimestamp, fpmlTrade)
				.mapItem(item -> {
					if (exists(item.<ExecutionDateTime>map("getExecutionDateTime", _partyTradeInformation -> _partyTradeInformation.getExecutionDateTime())).getOrDefault(false)) {
						return MapperS.of(EventTimestamp.builder()
							.setDateTime(item.<ExecutionDateTime>map("getExecutionDateTime", _partyTradeInformation -> _partyTradeInformation.getExecutionDateTime()).<ZonedDateTime>map("getValue", executionDateTime -> executionDateTime.getValue()).get())
							.setQualification(EventTimestampQualificationEnum.EXECUTION_DATE_TIME)
							.build());
					}
					return MapperS.<EventTimestamp>ofNull();
				}).getMulti()));
			
			eventTimestamp.addAll(toBuilder(partyTradeInformation(creationTimestamp, fpmlTrade)
				.mapItem(item -> {
					if (exists(item.<TradeProcessingTimestamps>map("getTimestamps", _partyTradeInformation -> _partyTradeInformation.getTimestamps()).<ZonedDateTime>map("getConfirmed", tradeProcessingTimestamps -> tradeProcessingTimestamps.getConfirmed())).getOrDefault(false)) {
						return MapperS.of(EventTimestamp.builder()
							.setDateTime(item.<TradeProcessingTimestamps>map("getTimestamps", _partyTradeInformation -> _partyTradeInformation.getTimestamps()).<ZonedDateTime>map("getConfirmed", tradeProcessingTimestamps -> tradeProcessingTimestamps.getConfirmed()).get())
							.setQualification(EventTimestampQualificationEnum.CONFIRMATION_DATE_TIME)
							.build());
					}
					return MapperS.<EventTimestamp>ofNull();
				}).getMulti()));
			
			eventTimestamp.addAll(toBuilder(partyTradeInformation(creationTimestamp, fpmlTrade)
				.mapItem(item -> {
					if (exists(item.<TradeProcessingTimestamps>map("getTimestamps", _partyTradeInformation -> _partyTradeInformation.getTimestamps()).<ZonedDateTime>map("getSubmittedForClearing", tradeProcessingTimestamps -> tradeProcessingTimestamps.getSubmittedForClearing())).getOrDefault(false)) {
						return MapperS.of(EventTimestamp.builder()
							.setDateTime(item.<TradeProcessingTimestamps>map("getTimestamps", _partyTradeInformation -> _partyTradeInformation.getTimestamps()).<ZonedDateTime>map("getSubmittedForClearing", tradeProcessingTimestamps -> tradeProcessingTimestamps.getSubmittedForClearing()).get())
							.setQualification(EventTimestampQualificationEnum.CLEARING_RECEIPT_DATE_TIME)
							.build());
					}
					return MapperS.<EventTimestamp>ofNull();
				}).getMulti()));
			
			eventTimestamp.addAll(toBuilder(partyTradeInformation(creationTimestamp, fpmlTrade)
				.mapItem(item -> {
					if (exists(item.<TradeProcessingTimestamps>map("getTimestamps", _partyTradeInformation -> _partyTradeInformation.getTimestamps()).<ZonedDateTime>map("getCleared", tradeProcessingTimestamps -> tradeProcessingTimestamps.getCleared())).getOrDefault(false)) {
						return MapperS.of(EventTimestamp.builder()
							.setDateTime(item.<TradeProcessingTimestamps>map("getTimestamps", _partyTradeInformation -> _partyTradeInformation.getTimestamps()).<ZonedDateTime>map("getCleared", tradeProcessingTimestamps -> tradeProcessingTimestamps.getCleared()).get())
							.setQualification(EventTimestampQualificationEnum.CLEARING_DATE_TIME)
							.build());
					}
					return MapperS.<EventTimestamp>ofNull();
				}).getMulti()));
			
			return Optional.ofNullable(eventTimestamp)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends PartyTradeInformation> partyTradeInformation(ZonedDateTime creationTimestamp, Trade fpmlTrade) {
			return MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation());
		}
	}
}
