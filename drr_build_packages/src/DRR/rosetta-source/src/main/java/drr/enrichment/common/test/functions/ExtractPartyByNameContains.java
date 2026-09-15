package drr.enrichment.common.test.functions;

import cdm.base.staticdata.party.Party;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.util.string.functions.StringContains;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ExtractPartyByNameContains.ExtractPartyByNameContainsDefault.class)
public abstract class ExtractPartyByNameContains implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected StringContains stringContains;

	/**
	* @param parties The list of parties to filter.
	* @param partyName The party name to filter by .
	* @return party The party with specified party name.
	*/
	public Party evaluate(List<? extends Party> parties, String partyName) {
		Party.PartyBuilder partyBuilder = doEvaluate(parties, partyName);
		
		final Party party;
		if (partyBuilder == null) {
			party = null;
		} else {
			party = partyBuilder.build();
			objectValidator.validate(Party.class, party);
		}
		
		return party;
	}

	protected abstract Party.PartyBuilder doEvaluate(List<? extends Party> parties, String partyName);

	public static class ExtractPartyByNameContainsDefault extends ExtractPartyByNameContains {
		@Override
		protected Party.PartyBuilder doEvaluate(List<? extends Party> parties, String partyName) {
			if (parties == null) {
				parties = Collections.emptyList();
			}
			Party.PartyBuilder party = Party.builder();
			return assignOutput(party, parties, partyName);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder party, List<? extends Party> parties, String partyName) {
			final MapperC<Party> thenArg = MapperC.<Party>of(parties)
				.filterItemNullSafe(item -> {
					final FieldWithMetaString fieldWithMetaString = item.<FieldWithMetaString>map("getName", _party -> _party.getName()).get();
					return stringContains.evaluate((fieldWithMetaString == null ? null : fieldWithMetaString.getValue()), MapperMaths.<String, String, String>add(MapperMaths.<String, String, String>add(MapperS.of(".*"), MapperS.of(partyName)), MapperS.of(".*")).get());
				});
			party = toBuilder(MapperS.of(thenArg.get()).get());
			
			return Optional.ofNullable(party)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
