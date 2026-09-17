package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapPartyRoleList.MapPartyRoleListDefault.class)
public abstract class MapPartyRoleList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyReference mapPartyReference;
	@Inject protected MapRelatedPartyToPartyRole mapRelatedPartyToPartyRole;

	/**
	* @param fpmlTrade 
	* @return partyRoleList 
	*/
	public List<? extends PartyRole> evaluate(Trade fpmlTrade) {
		List<PartyRole.PartyRoleBuilder> partyRoleListBuilder = doEvaluate(fpmlTrade);
		
		final List<? extends PartyRole> partyRoleList;
		if (partyRoleListBuilder == null) {
			partyRoleList = null;
		} else {
			partyRoleList = partyRoleListBuilder.stream().map(PartyRole::build).collect(Collectors.toList());
			objectValidator.validate(PartyRole.class, partyRoleList);
		}
		
		return partyRoleList;
	}

	protected abstract List<PartyRole.PartyRoleBuilder> doEvaluate(Trade fpmlTrade);

	public static class MapPartyRoleListDefault extends MapPartyRoleList {
		@Override
		protected List<PartyRole.PartyRoleBuilder> doEvaluate(Trade fpmlTrade) {
			List<PartyRole.PartyRoleBuilder> partyRoleList = new ArrayList<>();
			return assignOutput(partyRoleList, fpmlTrade);
		}
		
		protected List<PartyRole.PartyRoleBuilder> assignOutput(List<PartyRole.PartyRoleBuilder> partyRoleList, Trade fpmlTrade) {
			partyRoleList.addAll(toBuilder(MapperS.of(fpmlTrade).<PartyReference>mapC("getDeterminingParty", trade -> trade.getDeterminingParty())
				.mapItem(item -> MapperS.of(PartyRole.builder()
					.setPartyReference(mapPartyReference.evaluate(item.<String>map("getHref", partyReference -> partyReference.getHref()).get()))
					.setRole(PartyRoleEnum.DETERMINING_PARTY)
					.build())).getMulti()));
			
			partyRoleList.addAll(toBuilder(MapperS.of(fpmlTrade).<PartyReference>map("getBarrierDeterminationAgent", trade -> trade.getBarrierDeterminationAgent())
				.mapSingleToItem(item -> MapperS.of(PartyRole.builder()
					.setPartyReference(mapPartyReference.evaluate(item.<String>map("getHref", partyReference -> partyReference.getHref()).get()))
					.setRole(PartyRoleEnum.BARRIER_DETERMINATION_AGENT)
					.build())).getMulti()));
			
			partyRoleList.addAll(toBuilder(MapperS.of(fpmlTrade).<PartyReference>mapC("getHedgingParty", trade -> trade.getHedgingParty())
				.mapItem(item -> MapperS.of(PartyRole.builder()
					.setPartyReference(mapPartyReference.evaluate(item.<String>map("getHref", partyReference -> partyReference.getHref()).get()))
					.setRole(PartyRoleEnum.HEDGING_PARTY)
					.build())).getMulti()));
			
			partyRoleList.addAll(toBuilder(MapperS.of(fpmlTrade).<PartyReference>mapC("getBrokerPartyReference", trade -> trade.getBrokerPartyReference())
				.mapItem(item -> MapperS.of(PartyRole.builder()
					.setPartyReference(mapPartyReference.evaluate(item.<String>map("getHref", partyReference -> partyReference.getHref()).get()))
					.setRole(PartyRoleEnum.ARRANGING_BROKER)
					.build())).getMulti()));
			
			final MapperListOfLists<PartyRole> thenArg = MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation())
				.mapItemToList(item -> MapperC.<PartyRole>of(mapRelatedPartyToPartyRole.evaluate(item.get())));
			partyRoleList.addAll(toBuilder(thenArg
				.flattenList().getMulti()));
			
			return Optional.ofNullable(partyRoleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
