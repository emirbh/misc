package cdm.ingest.fpml.confirmation.header.functions;

import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.TradeIdentifierChoice;
import fpml.consolidated.doc.VersionedTradeId;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTradeIdentifierSequenceToTradeIdentifier.MapTradeIdentifierSequenceToTradeIdentifierDefault.class)
public abstract class MapTradeIdentifierSequenceToTradeIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapTradeIdToAssignedIdentifier mapTradeIdToAssignedIdentifier;
	@Inject protected MapTradeIdToIdentifierType mapTradeIdToIdentifierType;

	/**
	* @param fpmlNewTradeIdentifier 
	* @return cdmTradeIdentifier 
	*/
	public TradeIdentifier evaluate(PartyTradeIdentifier fpmlNewTradeIdentifier) {
		TradeIdentifier.TradeIdentifierBuilder cdmTradeIdentifierBuilder = doEvaluate(fpmlNewTradeIdentifier);
		
		final TradeIdentifier cdmTradeIdentifier;
		if (cdmTradeIdentifierBuilder == null) {
			cdmTradeIdentifier = null;
		} else {
			cdmTradeIdentifier = cdmTradeIdentifierBuilder.build();
			objectValidator.validate(TradeIdentifier.class, cdmTradeIdentifier);
		}
		
		return cdmTradeIdentifier;
	}

	protected abstract TradeIdentifier.TradeIdentifierBuilder doEvaluate(PartyTradeIdentifier fpmlNewTradeIdentifier);

	protected abstract MapperS<? extends PartyReference> fpmlPartyReference(PartyTradeIdentifier fpmlNewTradeIdentifier);

	protected abstract MapperC<? extends TradeIdentifierChoice> fpmlTradeIdentifierChoice(PartyTradeIdentifier fpmlNewTradeIdentifier);

	public static class MapTradeIdentifierSequenceToTradeIdentifierDefault extends MapTradeIdentifierSequenceToTradeIdentifier {
		@Override
		protected TradeIdentifier.TradeIdentifierBuilder doEvaluate(PartyTradeIdentifier fpmlNewTradeIdentifier) {
			TradeIdentifier.TradeIdentifierBuilder cdmTradeIdentifier = TradeIdentifier.builder();
			return assignOutput(cdmTradeIdentifier, fpmlNewTradeIdentifier);
		}
		
		protected TradeIdentifier.TradeIdentifierBuilder assignOutput(TradeIdentifier.TradeIdentifierBuilder cdmTradeIdentifier, PartyTradeIdentifier fpmlNewTradeIdentifier) {
			cdmTradeIdentifier
				.getOrCreateIssuerReference()
				.setExternalReference(fpmlPartyReference(fpmlNewTradeIdentifier).<String>map("getHref", partyReference -> partyReference.getHref()).get());
			
			cdmTradeIdentifier
				.addAssignedIdentifier(fpmlTradeIdentifierChoice(fpmlNewTradeIdentifier)
					.mapItem(item -> MapperS.of(mapTradeIdToAssignedIdentifier.evaluate(item.<TradeId>map("getTradeId", tradeIdentifierChoice -> tradeIdentifierChoice.getTradeId()).get(), null))).getMulti());
			
			cdmTradeIdentifier
				.addAssignedIdentifier(fpmlTradeIdentifierChoice(fpmlNewTradeIdentifier)
					.mapItem(item -> MapperS.of(mapTradeIdToAssignedIdentifier.evaluate(item.<VersionedTradeId>map("getVersionedTradeId", tradeIdentifierChoice -> tradeIdentifierChoice.getVersionedTradeId()).<TradeId>map("getTradeId", versionedTradeId -> versionedTradeId.getTradeId()).get(), item.<VersionedTradeId>map("getVersionedTradeId", tradeIdentifierChoice -> tradeIdentifierChoice.getVersionedTradeId()).<Integer>map("getVersion", versionedTradeId -> versionedTradeId.getVersion()).get()))).getMulti());
			
			final MapperC<TradeIdentifierTypeEnum> thenArg = fpmlTradeIdentifierChoice(fpmlNewTradeIdentifier).<TradeId>map("getTradeId", tradeIdentifierChoice -> tradeIdentifierChoice.getTradeId())
				.mapItem(item -> MapperS.of(mapTradeIdToIdentifierType.evaluate(item.get())));
			cdmTradeIdentifier
				.setIdentifierType(thenArg
					.first().get());
			
			return Optional.ofNullable(cdmTradeIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends PartyReference> fpmlPartyReference(PartyTradeIdentifier fpmlNewTradeIdentifier) {
			return MapperS.of(fpmlNewTradeIdentifier).<PartyReference>map("getPartyReference", partyTradeIdentifier -> partyTradeIdentifier.getPartyReference());
		}
		
		@Override
		protected MapperC<? extends TradeIdentifierChoice> fpmlTradeIdentifierChoice(PartyTradeIdentifier fpmlNewTradeIdentifier) {
			return MapperS.of(fpmlNewTradeIdentifier).<TradeIdentifierChoice>mapC("getTradeIdentifierChoice", partyTradeIdentifier -> partyTradeIdentifier.getTradeIdentifierChoice());
		}
	}
}
