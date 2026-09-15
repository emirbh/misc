package drr.regulation.cftc.rewrite.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.base.util.string.functions.StringLength;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ValidatePartyIdentifierFormat.ValidatePartyIdentifierFormatDefault.class)
public abstract class ValidatePartyIdentifierFormat implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected StringLength stringLength;

	/**
	* @param partyIdentifier 
	* @param format 
	* @return validOrEmpty 
	*/
	public Boolean evaluate(String partyIdentifier, PartyIdentifierFormatEnum format) {
		Boolean validOrEmpty = doEvaluate(partyIdentifier, format);
		
		return validOrEmpty;
	}

	protected abstract Boolean doEvaluate(String partyIdentifier, PartyIdentifierFormatEnum format);

	public static class ValidatePartyIdentifierFormatDefault extends ValidatePartyIdentifierFormat {
		@Override
		protected Boolean doEvaluate(String partyIdentifier, PartyIdentifierFormatEnum format) {
			Boolean validOrEmpty = null;
			return assignOutput(validOrEmpty, partyIdentifier, format);
		}
		
		protected Boolean assignOutput(Boolean validOrEmpty, String partyIdentifier, PartyIdentifierFormatEnum format) {
			if (notExists(MapperS.of(partyIdentifier)).getOrDefault(false)) {
				validOrEmpty = true;
			} else if (areEqual(MapperS.of(format), MapperS.of(PartyIdentifierFormatEnum.LEI), CardinalityOperator.All).getOrDefault(false)) {
				validOrEmpty = areEqual(MapperS.of(stringLength.evaluate(partyIdentifier)), MapperS.of(20), CardinalityOperator.All).get();
			} else if (areEqual(MapperS.of(format), MapperS.of(PartyIdentifierFormatEnum.LEI_AND_PERSON), CardinalityOperator.All).getOrDefault(false)) {
				validOrEmpty = greaterThan(MapperS.of(stringLength.evaluate(partyIdentifier)), MapperS.of(20), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(stringLength.evaluate(partyIdentifier)), MapperS.of(72), CardinalityOperator.All)).get();
			} else {
				validOrEmpty = false;
			}
			
			return validOrEmpty;
		}
	}
}
