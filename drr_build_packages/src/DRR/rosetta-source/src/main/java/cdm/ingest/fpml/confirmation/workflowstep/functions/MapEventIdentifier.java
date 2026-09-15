package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.ingest.fpml.confirmation.party.functions.MapPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.EventId;
import fpml.consolidated.business.events.TradingEventSummary;
import fpml.consolidated.msg.MessageId;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapEventIdentifier.MapEventIdentifierDefault.class)
public abstract class MapEventIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyReference mapPartyReference;

	/**
	* @param fpmlMessageId 
	* @param fpmlTradeEvent 
	* @return eventIdentifier 
	*/
	public List<? extends Identifier> evaluate(MessageId fpmlMessageId, TradingEventSummary fpmlTradeEvent) {
		List<Identifier.IdentifierBuilder> eventIdentifierBuilder = doEvaluate(fpmlMessageId, fpmlTradeEvent);
		
		final List<? extends Identifier> eventIdentifier;
		if (eventIdentifierBuilder == null) {
			eventIdentifier = null;
		} else {
			eventIdentifier = eventIdentifierBuilder.stream().map(Identifier::build).collect(Collectors.toList());
			objectValidator.validate(Identifier.class, eventIdentifier);
		}
		
		return eventIdentifier;
	}

	protected abstract List<Identifier.IdentifierBuilder> doEvaluate(MessageId fpmlMessageId, TradingEventSummary fpmlTradeEvent);

	public static class MapEventIdentifierDefault extends MapEventIdentifier {
		@Override
		protected List<Identifier.IdentifierBuilder> doEvaluate(MessageId fpmlMessageId, TradingEventSummary fpmlTradeEvent) {
			List<Identifier.IdentifierBuilder> eventIdentifier = new ArrayList<>();
			return assignOutput(eventIdentifier, fpmlMessageId, fpmlTradeEvent);
		}
		
		protected List<Identifier.IdentifierBuilder> assignOutput(List<Identifier.IdentifierBuilder> eventIdentifier, MessageId fpmlMessageId, TradingEventSummary fpmlTradeEvent) {
			final AssignedIdentifier assignedIdentifier = AssignedIdentifier.builder()
				.setIdentifierValue(MapperS.of(fpmlMessageId).<String>map("getValue", messageId -> messageId.getValue()).get())
				.build();
			final Identifier identifier = Identifier.builder()
				.setAssignedIdentifier((assignedIdentifier == null ? Collections.<AssignedIdentifier>emptyList() : Collections.singletonList(assignedIdentifier)))
				.build();
			if (identifier == null) {
				eventIdentifier.addAll(toBuilder(Collections.<Identifier>emptyList()));
			} else {
				eventIdentifier.addAll(toBuilder(Collections.singletonList(identifier)));
			}
			
			eventIdentifier.addAll(toBuilder(MapperS.of(fpmlTradeEvent).<BusinessEventIdentifier>mapC("getEventIdentifier", tradingEventSummary -> tradingEventSummary.getEventIdentifier())
				.mapItem(item -> {
					final AssignedIdentifier _assignedIdentifier = AssignedIdentifier.builder()
						.setIdentifierValue(item.<EventId>map("getEventId", businessEventIdentifier -> businessEventIdentifier.getEventId()).<String>map("getValue", eventId -> eventId.getValue()).get())
						.build();
					return MapperS.of(Identifier.builder()
						.setAssignedIdentifier((_assignedIdentifier == null ? Collections.<AssignedIdentifier>emptyList() : Collections.singletonList(_assignedIdentifier)))
						.setIssuerReference(mapPartyReference.evaluate(item.<PartyReference>map("getPartyReference", businessEventIdentifier -> businessEventIdentifier.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get()))
						.build());
				}).getMulti()));
			
			return Optional.ofNullable(eventIdentifier)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
