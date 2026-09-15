package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import cdm.ingest.fpml.confirmation.party.functions.MapPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PartyInformation;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
import fpml.consolidated.shared.RelatedPerson;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPartyTradeInformationToPartyInformation.MapPartyTradeInformationToPartyInformationDefault.class)
public abstract class MapPartyTradeInformationToPartyInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyReference mapPartyReference;
	@Inject protected MapRelatedParty mapRelatedParty;
	@Inject protected MapRelatedPersonToNaturalPersonRole mapRelatedPersonToNaturalPersonRole;

	/**
	* @param fpmlPartyTradeInformation 
	* @param fpmlPartyList 
	* @param fpmlRequestMessageHeader 
	* @return partyInformation 
	*/
	public PartyInformation evaluate(PartyTradeInformation fpmlPartyTradeInformation, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
		PartyInformation.PartyInformationBuilder partyInformationBuilder = doEvaluate(fpmlPartyTradeInformation, fpmlPartyList, fpmlRequestMessageHeader);
		
		final PartyInformation partyInformation;
		if (partyInformationBuilder == null) {
			partyInformation = null;
		} else {
			partyInformation = partyInformationBuilder.build();
			objectValidator.validate(PartyInformation.class, partyInformation);
		}
		
		return partyInformation;
	}

	protected abstract PartyInformation.PartyInformationBuilder doEvaluate(PartyTradeInformation fpmlPartyTradeInformation, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	protected abstract MapperS<? extends Party> fpmlParty(PartyTradeInformation fpmlPartyTradeInformation, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader);

	public static class MapPartyTradeInformationToPartyInformationDefault extends MapPartyTradeInformationToPartyInformation {
		@Override
		protected PartyInformation.PartyInformationBuilder doEvaluate(PartyTradeInformation fpmlPartyTradeInformation, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			if (fpmlPartyList == null) {
				fpmlPartyList = Collections.emptyList();
			}
			PartyInformation.PartyInformationBuilder partyInformation = PartyInformation.builder();
			return assignOutput(partyInformation, fpmlPartyTradeInformation, fpmlPartyList, fpmlRequestMessageHeader);
		}
		
		protected PartyInformation.PartyInformationBuilder assignOutput(PartyInformation.PartyInformationBuilder partyInformation, PartyTradeInformation fpmlPartyTradeInformation, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			partyInformation = toBuilder(PartyInformation.builder()
				.setPartyReference(mapPartyReference.evaluate(MapperS.of(fpmlPartyTradeInformation).<PartyReference>map("getPartyReference", partyTradeInformation -> partyTradeInformation.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get()))
				.setRelatedPerson(MapperS.of(fpmlPartyTradeInformation).<RelatedPerson>mapC("getRelatedPerson", partyTradeInformation -> partyTradeInformation.getRelatedPerson())
					.mapItem(item -> MapperS.of(mapRelatedPersonToNaturalPersonRole.evaluate(item.get()))).getMulti())
				.setRelatedParty(MapperS.of(fpmlPartyTradeInformation).<RelatedParty>mapC("getRelatedParty", partyTradeInformation -> partyTradeInformation.getRelatedParty())
					.mapItem(item -> MapperS.of(mapRelatedParty.evaluate(item.get()))).getMulti())
				.build());
			
			return Optional.ofNullable(partyInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Party> fpmlParty(PartyTradeInformation fpmlPartyTradeInformation, List<? extends Party> fpmlPartyList, RequestMessageHeader fpmlRequestMessageHeader) {
			final MapperC<Party> thenArg = MapperC.<Party>of(fpmlPartyList)
				.filterItemNullSafe(item -> areEqual(item.<String>map("getId", party -> party.getId()), MapperS.of(fpmlPartyTradeInformation).<PartyReference>map("getPartyReference", partyTradeInformation -> partyTradeInformation.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()), CardinalityOperator.All).get());
			return thenArg
				.first();
		}
	}
}
