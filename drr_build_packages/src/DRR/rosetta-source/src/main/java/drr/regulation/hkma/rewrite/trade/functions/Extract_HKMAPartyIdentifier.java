package drr.regulation.hkma.rewrite.trade.functions;

import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Extract_HKMAPartyIdentifier.Extract_HKMAPartyIdentifierDefault.class)
public abstract class Extract_HKMAPartyIdentifier implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PartyBIC partyBIC;

	/**
	* @param partyIdentifier 
	* @return hkmaPartyIdentifiers 
	*/
	public String evaluate(PartyIdentifier partyIdentifier) {
		String hkmaPartyIdentifiers = doEvaluate(partyIdentifier);
		
		return hkmaPartyIdentifiers;
	}

	protected abstract String doEvaluate(PartyIdentifier partyIdentifier);

	public static class Extract_HKMAPartyIdentifierDefault extends Extract_HKMAPartyIdentifier {
		@Override
		protected String doEvaluate(PartyIdentifier partyIdentifier) {
			String hkmaPartyIdentifiers = null;
			return assignOutput(hkmaPartyIdentifiers, partyIdentifier);
		}
		
		protected String assignOutput(String hkmaPartyIdentifiers, PartyIdentifier partyIdentifier) {
			if (areEqual(MapperS.of(partyIdentifier).<PartyIdentifierTypeEnum>map("getIdentifierType", _partyIdentifier -> _partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.BIC), CardinalityOperator.All).getOrDefault(false)) {
				hkmaPartyIdentifiers = partyBIC.evaluate(partyIdentifier);
			} else {
				final FieldWithMetaString fieldWithMetaString = MapperS.of(partyIdentifier).<FieldWithMetaString>map("getIdentifier", _partyIdentifier -> _partyIdentifier.getIdentifier()).get();
				if (fieldWithMetaString == null) {
					hkmaPartyIdentifiers = null;
				} else {
					hkmaPartyIdentifiers = fieldWithMetaString.getValue();
				}
			}
			
			return hkmaPartyIdentifiers;
		}
	}
}
