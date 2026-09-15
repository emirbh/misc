package drr.base.util.party.functions;

import cdm.base.staticdata.party.NaturalPerson;
import cdm.base.staticdata.party.NaturalPersonRole;
import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.FieldWithMetaNaturalPersonRoleEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaNaturalPerson;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NaturalPersonBuyerOrSeller.NaturalPersonBuyerOrSellerDefault.class)
public abstract class NaturalPersonBuyerOrSeller implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PartyIdentifierNaturalPersonRoles partyIdentifierNaturalPersonRoles;

	/**
	* @param party 
	* @return naturalPerson 
	*/
	public NaturalPerson evaluate(Party party) {
		NaturalPerson.NaturalPersonBuilder naturalPersonBuilder = doEvaluate(party);
		
		final NaturalPerson naturalPerson;
		if (naturalPersonBuilder == null) {
			naturalPerson = null;
		} else {
			naturalPerson = naturalPersonBuilder.build();
			objectValidator.validate(NaturalPerson.class, naturalPerson);
		}
		
		return naturalPerson;
	}

	protected abstract NaturalPerson.NaturalPersonBuilder doEvaluate(Party party);

	public static class NaturalPersonBuyerOrSellerDefault extends NaturalPersonBuyerOrSeller {
		@Override
		protected NaturalPerson.NaturalPersonBuilder doEvaluate(Party party) {
			NaturalPerson.NaturalPersonBuilder naturalPerson = NaturalPerson.builder();
			return assignOutput(naturalPerson, party);
		}
		
		protected NaturalPerson.NaturalPersonBuilder assignOutput(NaturalPerson.NaturalPersonBuilder naturalPerson, Party party) {
			final MapperC<NaturalPersonRole> thenArg0 = MapperS.of(party).<NaturalPersonRole>mapC("getPersonRole", _party -> _party.getPersonRole())
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaNaturalPersonRoleEnum>mapC("getRole", naturalPersonRole -> naturalPersonRole.getRole())
					.mapItem(r -> contains(MapperC.<NaturalPersonRoleEnum>of(partyIdentifierNaturalPersonRoles.evaluate()), r.<NaturalPersonRoleEnum>map("Type coercion", fieldWithMetaNaturalPersonRoleEnum -> fieldWithMetaNaturalPersonRoleEnum == null ? null : fieldWithMetaNaturalPersonRoleEnum.getValue())).asMapper()), MapperS.of(true), CardinalityOperator.Any).get());
			final MapperS<NaturalPersonRole> thenArg1 = MapperS.of(thenArg0.get());
			final ReferenceWithMetaNaturalPerson referenceWithMetaNaturalPerson = thenArg1
				.mapSingleToItem(item -> item.<ReferenceWithMetaNaturalPerson>map("getPersonReference", naturalPersonRole -> naturalPersonRole.getPersonReference())).get();
			if (referenceWithMetaNaturalPerson == null) {
				naturalPerson = null;
			} else {
				naturalPerson = toBuilder(referenceWithMetaNaturalPerson.getValue());
			}
			
			return Optional.ofNullable(naturalPerson)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
