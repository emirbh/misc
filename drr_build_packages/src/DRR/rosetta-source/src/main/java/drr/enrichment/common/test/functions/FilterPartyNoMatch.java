package drr.enrichment.common.test.functions;

import cdm.base.staticdata.party.Party;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FilterPartyNoMatch.FilterPartyNoMatchDefault.class)
public abstract class FilterPartyNoMatch implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param parties The list of parties to filter.
	* @param party The party name to filter by .
	* @return filteredParties The party with specified party name.
	*/
	public List<? extends Party> evaluate(List<? extends Party> parties, Party party) {
		List<Party.PartyBuilder> filteredPartiesBuilder = doEvaluate(parties, party);
		
		final List<? extends Party> filteredParties;
		if (filteredPartiesBuilder == null) {
			filteredParties = null;
		} else {
			filteredParties = filteredPartiesBuilder.stream().map(Party::build).collect(Collectors.toList());
			objectValidator.validate(Party.class, filteredParties);
		}
		
		return filteredParties;
	}

	protected abstract List<Party.PartyBuilder> doEvaluate(List<? extends Party> parties, Party party);

	public static class FilterPartyNoMatchDefault extends FilterPartyNoMatch {
		@Override
		protected List<Party.PartyBuilder> doEvaluate(List<? extends Party> parties, Party party) {
			if (parties == null) {
				parties = Collections.emptyList();
			}
			List<Party.PartyBuilder> filteredParties = new ArrayList<>();
			return assignOutput(filteredParties, parties, party);
		}
		
		protected List<Party.PartyBuilder> assignOutput(List<Party.PartyBuilder> filteredParties, List<? extends Party> parties, Party party) {
			filteredParties = toBuilder(MapperC.<Party>of(parties)
				.filterItemNullSafe(item -> notEqual(item, MapperS.of(party), CardinalityOperator.Any).get()).getMulti());
			
			return Optional.ofNullable(filteredParties)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
