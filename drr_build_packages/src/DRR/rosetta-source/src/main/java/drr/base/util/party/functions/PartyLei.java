package drr.base.util.party.functions;

import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PartyLei.PartyLeiDefault.class)
public abstract class PartyLei implements RosettaFunction {

	/**
	* @param partyIdentifier 
	* @return partyLei 
	*/
	public String evaluate(List<? extends PartyIdentifier> partyIdentifier) {
		String partyLei = doEvaluate(partyIdentifier);
		
		return partyLei;
	}

	protected abstract String doEvaluate(List<? extends PartyIdentifier> partyIdentifier);

	public static class PartyLeiDefault extends PartyLei {
		@Override
		protected String doEvaluate(List<? extends PartyIdentifier> partyIdentifier) {
			if (partyIdentifier == null) {
				partyIdentifier = Collections.emptyList();
			}
			String partyLei = null;
			return assignOutput(partyLei, partyIdentifier);
		}
		
		protected String assignOutput(String partyLei, List<? extends PartyIdentifier> partyIdentifier) {
			final MapperC<PartyIdentifier> thenArg = MapperC.<PartyIdentifier>of(partyIdentifier)
				.filterItemNullSafe(item -> areEqual(item.<PartyIdentifierTypeEnum>map("getIdentifierType", _partyIdentifier -> _partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.All).get());
			final FieldWithMetaString fieldWithMetaString = MapperS.of(distinctIgnoringPrecision(thenArg.<FieldWithMetaString>map("getIdentifier", _partyIdentifier -> _partyIdentifier.getIdentifier())).get()).get();
			if (fieldWithMetaString == null) {
				partyLei = null;
			} else {
				partyLei = fieldWithMetaString.getValue();
			}
			
			return partyLei;
		}
	}
}
