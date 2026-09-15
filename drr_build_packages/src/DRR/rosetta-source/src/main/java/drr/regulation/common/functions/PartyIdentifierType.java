package drr.regulation.common.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.PersonIdentifier;
import cdm.base.staticdata.party.PersonIdentifierTypeEnum;
import cdm.base.staticdata.party.metafields.FieldWithMetaPersonIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.party.functions.NaturalPersonBuyerOrSeller;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PartyIdentifierType.PartyIdentifierTypeDefault.class)
public abstract class PartyIdentifierType implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected NaturalPersonBuyerOrSeller naturalPersonBuyerOrSeller;

	/**
	* @param party 
	* @return partyIdentifierFormat 
	*/
	public List<String> evaluate(Party party) {
		List<String> partyIdentifierFormat = doEvaluate(party);
		
		return partyIdentifierFormat;
	}

	protected abstract List<String> doEvaluate(Party party);

	protected abstract MapperC<? extends FieldWithMetaPersonIdentifier> personId(Party party);

	public static class PartyIdentifierTypeDefault extends PartyIdentifierType {
		@Override
		protected List<String> doEvaluate(Party party) {
			List<String> partyIdentifierFormat = new ArrayList<>();
			return assignOutput(partyIdentifierFormat, party);
		}
		
		protected List<String> assignOutput(List<String> partyIdentifierFormat, Party party) {
			if (areEqual(personId(party).<PersonIdentifier>map("Type coercion", fieldWithMetaPersonIdentifier -> fieldWithMetaPersonIdentifier.getValue()).<PersonIdentifierTypeEnum>map("getIdentifierType", personIdentifier -> personIdentifier.getIdentifierType()), MapperS.of(PersonIdentifierTypeEnum.NPID), CardinalityOperator.Any).getOrDefault(false)) {
				partyIdentifierFormat.addAll(MapperS.of(PersonIdentifierTypeEnum.NPID).map("to-string", PersonIdentifierTypeEnum::toDisplayString).getMulti());
			} else if (areEqual(personId(party).<PersonIdentifier>map("Type coercion", fieldWithMetaPersonIdentifier -> fieldWithMetaPersonIdentifier.getValue()).<PersonIdentifierTypeEnum>map("getIdentifierType", personIdentifier -> personIdentifier.getIdentifierType()), MapperS.of(PersonIdentifierTypeEnum.PLID), CardinalityOperator.Any).getOrDefault(false)) {
				partyIdentifierFormat.addAll(MapperS.of(PersonIdentifierTypeEnum.PLID).map("to-string", PersonIdentifierTypeEnum::toDisplayString).getMulti());
			} else {
				partyIdentifierFormat.addAll(MapperS.of(PartyIdentifierTypeEnum.LEI).map("to-string", PartyIdentifierTypeEnum::toDisplayString).getMulti());
			}
			
			return partyIdentifierFormat;
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaPersonIdentifier> personId(Party party) {
			return MapperS.of(naturalPersonBuyerOrSeller.evaluate(party)).<FieldWithMetaPersonIdentifier>mapC("getPersonId", naturalPerson -> naturalPerson.getPersonId());
		}
	}
}
