package drr.regulation.hkma.rewrite.trade.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Filter_HKMAPriorityPartyIdentifiers.Filter_HKMAPriorityPartyIdentifiersDefault.class)
public abstract class Filter_HKMAPriorityPartyIdentifiers implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param party 
	* @return partyIdentifier 
	*/
	public PartyIdentifier evaluate(Party party) {
		PartyIdentifier.PartyIdentifierBuilder partyIdentifierBuilder = doEvaluate(party);
		
		final PartyIdentifier partyIdentifier;
		if (partyIdentifierBuilder == null) {
			partyIdentifier = null;
		} else {
			partyIdentifier = partyIdentifierBuilder.build();
			objectValidator.validate(PartyIdentifier.class, partyIdentifier);
		}
		
		return partyIdentifier;
	}

	protected abstract PartyIdentifier.PartyIdentifierBuilder doEvaluate(Party party);

	public static class Filter_HKMAPriorityPartyIdentifiersDefault extends Filter_HKMAPriorityPartyIdentifiers {
		@Override
		protected PartyIdentifier.PartyIdentifierBuilder doEvaluate(Party party) {
			PartyIdentifier.PartyIdentifierBuilder partyIdentifier = PartyIdentifier.builder();
			return assignOutput(partyIdentifier, party);
		}
		
		protected PartyIdentifier.PartyIdentifierBuilder assignOutput(PartyIdentifier.PartyIdentifierBuilder partyIdentifier, Party party) {
			if (areEqual(MapperS.of(party).<PartyIdentifier>mapC("getPartyId", _party -> _party.getPartyId()).<PartyIdentifierTypeEnum>map("getIdentifierType", _partyIdentifier -> _partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.BIC), CardinalityOperator.Any).getOrDefault(false)) {
				final MapperC<PartyIdentifier> thenArg = MapperS.of(party).<PartyIdentifier>mapC("getPartyId", _party -> _party.getPartyId())
					.filterItemNullSafe(item -> areEqual(item.<PartyIdentifierTypeEnum>map("getIdentifierType", _partyIdentifier -> _partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.BIC), CardinalityOperator.All).get());
				partyIdentifier = toBuilder(thenArg
					.first().get());
			} else {
				partyIdentifier = toBuilder(MapperS.of(party).<PartyIdentifier>mapC("getPartyId", _party -> _party.getPartyId())
					.first().get());
			}
			
			return Optional.ofNullable(partyIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
