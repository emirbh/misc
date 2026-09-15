package cdm.ingest.fpml.confirmation.header.functions;

import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.TradeHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapTradeIdentifierList.MapTradeIdentifierListDefault.class)
public abstract class MapTradeIdentifierList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyTradeIdentifierToTradeIdentifierList mapPartyTradeIdentifierToTradeIdentifierList;

	/**
	* @param fpmlTradeHeader 
	* @param fpmlPartyTradeIdentifierList 
	* @return cdmTradeIdentifierList 
	*/
	public List<? extends TradeIdentifier> evaluate(TradeHeader fpmlTradeHeader, List<? extends PartyTradeIdentifier> fpmlPartyTradeIdentifierList) {
		List<TradeIdentifier.TradeIdentifierBuilder> cdmTradeIdentifierListBuilder = doEvaluate(fpmlTradeHeader, fpmlPartyTradeIdentifierList);
		
		final List<? extends TradeIdentifier> cdmTradeIdentifierList;
		if (cdmTradeIdentifierListBuilder == null) {
			cdmTradeIdentifierList = null;
		} else {
			cdmTradeIdentifierList = cdmTradeIdentifierListBuilder.stream().map(TradeIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(TradeIdentifier.class, cdmTradeIdentifierList);
		}
		
		return cdmTradeIdentifierList;
	}

	protected abstract List<TradeIdentifier.TradeIdentifierBuilder> doEvaluate(TradeHeader fpmlTradeHeader, List<? extends PartyTradeIdentifier> fpmlPartyTradeIdentifierList);

	public static class MapTradeIdentifierListDefault extends MapTradeIdentifierList {
		@Override
		protected List<TradeIdentifier.TradeIdentifierBuilder> doEvaluate(TradeHeader fpmlTradeHeader, List<? extends PartyTradeIdentifier> fpmlPartyTradeIdentifierList) {
			if (fpmlPartyTradeIdentifierList == null) {
				fpmlPartyTradeIdentifierList = Collections.emptyList();
			}
			List<TradeIdentifier.TradeIdentifierBuilder> cdmTradeIdentifierList = new ArrayList<>();
			return assignOutput(cdmTradeIdentifierList, fpmlTradeHeader, fpmlPartyTradeIdentifierList);
		}
		
		protected List<TradeIdentifier.TradeIdentifierBuilder> assignOutput(List<TradeIdentifier.TradeIdentifierBuilder> cdmTradeIdentifierList, TradeHeader fpmlTradeHeader, List<? extends PartyTradeIdentifier> fpmlPartyTradeIdentifierList) {
			final MapperListOfLists<TradeIdentifier> thenArg0 = MapperS.of(fpmlTradeHeader).<PartyTradeIdentifier>mapC("getPartyTradeIdentifier", tradeHeader -> tradeHeader.getPartyTradeIdentifier())
				.mapItemToList(item -> MapperC.<TradeIdentifier>of(mapPartyTradeIdentifierToTradeIdentifierList.evaluate(item.get())));
			cdmTradeIdentifierList.addAll(toBuilder(thenArg0
				.flattenList().getMulti()));
			
			final MapperListOfLists<TradeIdentifier> thenArg1 = MapperC.<PartyTradeIdentifier>of(fpmlPartyTradeIdentifierList)
				.mapItemToList(item -> MapperC.<TradeIdentifier>of(mapPartyTradeIdentifierToTradeIdentifierList.evaluate(item.get())));
			cdmTradeIdentifierList.addAll(toBuilder(thenArg1
				.flattenList().getMulti()));
			
			return Optional.ofNullable(cdmTradeIdentifierList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
