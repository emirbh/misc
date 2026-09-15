package drr.regulation.hkma.rewrite.trade.functions;

import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PartyBIC.PartyBICDefault.class)
public abstract class PartyBIC implements RosettaFunction {

	/**
	* @param partyIdentifier 
	* @return partyBIC 
	*/
	public String evaluate(PartyIdentifier partyIdentifier) {
		String partyBIC = doEvaluate(partyIdentifier);
		
		return partyBIC;
	}

	protected abstract String doEvaluate(PartyIdentifier partyIdentifier);

	public static class PartyBICDefault extends PartyBIC {
		@Override
		protected String doEvaluate(PartyIdentifier partyIdentifier) {
			String partyBIC = null;
			return assignOutput(partyBIC, partyIdentifier);
		}
		
		protected String assignOutput(String partyBIC, PartyIdentifier partyIdentifier) {
			final MapperS<PartyIdentifier> thenArg = MapperS.of(partyIdentifier)
				.filterSingleNullSafe(item -> areEqual(item.<PartyIdentifierTypeEnum>map("getIdentifierType", _partyIdentifier -> _partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.BIC), CardinalityOperator.All).get());
			final FieldWithMetaString fieldWithMetaString = thenArg.<FieldWithMetaString>map("getIdentifier", _partyIdentifier -> _partyIdentifier.getIdentifier()).get();
			if (fieldWithMetaString == null) {
				partyBIC = null;
			} else {
				partyBIC = fieldWithMetaString.getValue();
			}
			
			return partyBIC;
		}
	}
}
