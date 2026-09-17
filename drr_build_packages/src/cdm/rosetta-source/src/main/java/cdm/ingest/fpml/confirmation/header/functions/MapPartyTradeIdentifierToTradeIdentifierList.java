package cdm.ingest.fpml.confirmation.header.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.TradeIdentifier;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import cdm.ingest.fpml.confirmation.party.functions.MapPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.TradeIdentifierChoice;
import fpml.consolidated.doc.VersionedTradeId;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapPartyTradeIdentifierToTradeIdentifierList.MapPartyTradeIdentifierToTradeIdentifierListDefault.class)
public abstract class MapPartyTradeIdentifierToTradeIdentifierList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyReference mapPartyReference;
	@Inject protected MapStringWithScheme mapStringWithScheme;
	@Inject protected MapTradeIdToAssignedIdentifier mapTradeIdToAssignedIdentifier;
	@Inject protected MapTradeIdToIdentifierType mapTradeIdToIdentifierType;

	/**
	* @param fpmlPartyTradeIdentifierList 
	* @return cdmTradeIdentifier 
	*/
	public List<? extends TradeIdentifier> evaluate(PartyTradeIdentifier fpmlPartyTradeIdentifierList) {
		List<TradeIdentifier.TradeIdentifierBuilder> cdmTradeIdentifierBuilder = doEvaluate(fpmlPartyTradeIdentifierList);
		
		final List<? extends TradeIdentifier> cdmTradeIdentifier;
		if (cdmTradeIdentifierBuilder == null) {
			cdmTradeIdentifier = null;
		} else {
			cdmTradeIdentifier = cdmTradeIdentifierBuilder.stream().map(TradeIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(TradeIdentifier.class, cdmTradeIdentifier);
		}
		
		return cdmTradeIdentifier;
	}

	protected abstract List<TradeIdentifier.TradeIdentifierBuilder> doEvaluate(PartyTradeIdentifier fpmlPartyTradeIdentifierList);

	protected abstract MapperS<? extends FieldWithMetaString> issuer(PartyTradeIdentifier fpmlPartyTradeIdentifierList);

	protected abstract MapperS<? extends AssignedIdentifier> identifierForIssuer(PartyTradeIdentifier fpmlPartyTradeIdentifierList);

	protected abstract MapperC<? extends AssignedIdentifier> identifierForTrade(PartyTradeIdentifier fpmlPartyTradeIdentifierList);

	protected abstract MapperS<TradeIdentifierTypeEnum> identifierTypeForIssuer(PartyTradeIdentifier fpmlPartyTradeIdentifierList);

	protected abstract MapperS<TradeIdentifierTypeEnum> identifierTypeForTrade(PartyTradeIdentifier fpmlPartyTradeIdentifierList);

	protected abstract MapperS<? extends ReferenceWithMetaParty> issuerReference(PartyTradeIdentifier fpmlPartyTradeIdentifierList);

	public static class MapPartyTradeIdentifierToTradeIdentifierListDefault extends MapPartyTradeIdentifierToTradeIdentifierList {
		@Override
		protected List<TradeIdentifier.TradeIdentifierBuilder> doEvaluate(PartyTradeIdentifier fpmlPartyTradeIdentifierList) {
			List<TradeIdentifier.TradeIdentifierBuilder> cdmTradeIdentifier = new ArrayList<>();
			return assignOutput(cdmTradeIdentifier, fpmlPartyTradeIdentifierList);
		}
		
		protected List<TradeIdentifier.TradeIdentifierBuilder> assignOutput(List<TradeIdentifier.TradeIdentifierBuilder> cdmTradeIdentifier, PartyTradeIdentifier fpmlPartyTradeIdentifierList) {
			final TradeIdentifier tradeIdentifier = TradeIdentifier.builder()
				.setIssuer(issuer(fpmlPartyTradeIdentifierList).get())
				.setIssuerReference(issuerReference(fpmlPartyTradeIdentifierList).get())
				.setAssignedIdentifier((identifierForTrade(fpmlPartyTradeIdentifierList).getMulti().isEmpty() ? new ArrayList<>(identifierForIssuer(fpmlPartyTradeIdentifierList).getMulti()) : new ArrayList<>(identifierForTrade(fpmlPartyTradeIdentifierList).getMulti())))
				.setIdentifierType(identifierTypeForTrade(fpmlPartyTradeIdentifierList).getOrDefault(identifierTypeForIssuer(fpmlPartyTradeIdentifierList).get()))
				.build();
			if (tradeIdentifier == null) {
				cdmTradeIdentifier = toBuilder(Collections.<TradeIdentifier>emptyList());
			} else {
				cdmTradeIdentifier = toBuilder(Collections.singletonList(tradeIdentifier));
			}
			
			return Optional.ofNullable(cdmTradeIdentifier)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> issuer(PartyTradeIdentifier fpmlPartyTradeIdentifierList) {
			return MapperS.of(mapStringWithScheme.evaluate(MapperS.of(fpmlPartyTradeIdentifierList).<IssuerId>map("getIssuer", partyTradeIdentifier -> partyTradeIdentifier.getIssuer()).<String>map("getValue", issuerId -> issuerId.getValue()).get(), MapperS.of(fpmlPartyTradeIdentifierList).<IssuerId>map("getIssuer", partyTradeIdentifier -> partyTradeIdentifier.getIssuer()).<String>map("getIssuerIdScheme", issuerId -> issuerId.getIssuerIdScheme()).get()));
		}
		
		@Override
		protected MapperS<? extends AssignedIdentifier> identifierForIssuer(PartyTradeIdentifier fpmlPartyTradeIdentifierList) {
			return MapperS.of(mapTradeIdToAssignedIdentifier.evaluate(MapperS.of(fpmlPartyTradeIdentifierList).<TradeId>map("getTradeId", partyTradeIdentifier -> partyTradeIdentifier.getTradeId()).get(), null));
		}
		
		@Override
		protected MapperC<? extends AssignedIdentifier> identifierForTrade(PartyTradeIdentifier fpmlPartyTradeIdentifierList) {
			return MapperS.of(fpmlPartyTradeIdentifierList).<TradeIdentifierChoice>mapC("getTradeIdentifierChoice", partyTradeIdentifier -> partyTradeIdentifier.getTradeIdentifierChoice())
				.mapItem(item -> MapperS.of(mapTradeIdToAssignedIdentifier.evaluate(item.<TradeId>map("getTradeId", tradeIdentifierChoice -> tradeIdentifierChoice.getTradeId()).getOrDefault(item.<VersionedTradeId>map("getVersionedTradeId", tradeIdentifierChoice -> tradeIdentifierChoice.getVersionedTradeId()).<TradeId>map("getTradeId", versionedTradeId -> versionedTradeId.getTradeId()).get()), item.<VersionedTradeId>map("getVersionedTradeId", tradeIdentifierChoice -> tradeIdentifierChoice.getVersionedTradeId()).<Integer>map("getVersion", versionedTradeId -> versionedTradeId.getVersion()).get())));
		}
		
		@Override
		protected MapperS<TradeIdentifierTypeEnum> identifierTypeForIssuer(PartyTradeIdentifier fpmlPartyTradeIdentifierList) {
			return MapperS.of(mapTradeIdToIdentifierType.evaluate(MapperS.of(fpmlPartyTradeIdentifierList).<TradeId>map("getTradeId", partyTradeIdentifier -> partyTradeIdentifier.getTradeId()).get()));
		}
		
		@Override
		protected MapperS<TradeIdentifierTypeEnum> identifierTypeForTrade(PartyTradeIdentifier fpmlPartyTradeIdentifierList) {
			final MapperC<TradeIdentifierTypeEnum> thenArg = MapperS.of(fpmlPartyTradeIdentifierList).<TradeIdentifierChoice>mapC("getTradeIdentifierChoice", partyTradeIdentifier -> partyTradeIdentifier.getTradeIdentifierChoice()).<TradeId>map("getTradeId", tradeIdentifierChoice -> tradeIdentifierChoice.getTradeId())
				.mapItem(item -> MapperS.of(mapTradeIdToIdentifierType.evaluate(item.get())));
			return thenArg
				.first();
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> issuerReference(PartyTradeIdentifier fpmlPartyTradeIdentifierList) {
			return MapperS.of(mapPartyReference.evaluate(MapperS.of(fpmlPartyTradeIdentifierList).<PartyReference>map("getPartyReference", partyTradeIdentifier -> partyTradeIdentifier.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get()));
		}
	}
}
