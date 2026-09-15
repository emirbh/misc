package drr.base.util.party.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PersonIdentifier;
import cdm.base.staticdata.party.metafields.FieldWithMetaPersonIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.util.party.PartyIdentifierFormatEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PartyIdentifierFormat.PartyIdentifierFormatDefault.class)
public abstract class PartyIdentifierFormat implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected NaturalPersonBuyerOrSeller naturalPersonBuyerOrSeller;

	/**
	* @param party 
	* @return partyIdentifierFormat 
	*/
	public PartyIdentifierFormatEnum evaluate(Party party) {
		PartyIdentifierFormatEnum partyIdentifierFormat = doEvaluate(party);
		
		return partyIdentifierFormat;
	}

	protected abstract PartyIdentifierFormatEnum doEvaluate(Party party);

	protected abstract MapperC<? extends FieldWithMetaString> personId(Party party);

	public static class PartyIdentifierFormatDefault extends PartyIdentifierFormat {
		@Override
		protected PartyIdentifierFormatEnum doEvaluate(Party party) {
			PartyIdentifierFormatEnum partyIdentifierFormat = null;
			return assignOutput(partyIdentifierFormat, party);
		}
		
		protected PartyIdentifierFormatEnum assignOutput(PartyIdentifierFormatEnum partyIdentifierFormat, Party party) {
			if (exists(personId(party)).getOrDefault(false)) {
				partyIdentifierFormat = PartyIdentifierFormatEnum.LEI_AND_PERSON;
			} else {
				partyIdentifierFormat = PartyIdentifierFormatEnum.LEI;
			}
			
			return partyIdentifierFormat;
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaString> personId(Party party) {
			return MapperS.of(naturalPersonBuyerOrSeller.evaluate(party)).<FieldWithMetaPersonIdentifier>mapC("getPersonId", naturalPerson -> naturalPerson.getPersonId()).<PersonIdentifier>map("Type coercion", fieldWithMetaPersonIdentifier -> fieldWithMetaPersonIdentifier.getValue()).<FieldWithMetaString>map("getIdentifier", personIdentifier -> personIdentifier.getIdentifier());
		}
	}
}
