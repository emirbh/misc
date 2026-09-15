package drr.regulation.common.trade.party.functions;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CountryOfCounterparty2_Validation.CountryOfCounterparty2_ValidationDefault.class)
public abstract class CountryOfCounterparty2_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param counterparty2IdentifierTypeIndicator 
	* @param countryOfTheCounterParty2 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, Boolean counterparty2IdentifierTypeIndicator, ISOCountryCodeEnum countryOfTheCounterParty2) {
		Boolean result = doEvaluate(actionType, counterparty2IdentifierTypeIndicator, countryOfTheCounterParty2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, Boolean counterparty2IdentifierTypeIndicator, ISOCountryCodeEnum countryOfTheCounterParty2);

	public static class CountryOfCounterparty2_ValidationDefault extends CountryOfCounterparty2_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, Boolean counterparty2IdentifierTypeIndicator, ISOCountryCodeEnum countryOfTheCounterParty2) {
			Boolean result = null;
			return assignOutput(result, actionType, counterparty2IdentifierTypeIndicator, countryOfTheCounterParty2);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, Boolean counterparty2IdentifierTypeIndicator, ISOCountryCodeEnum countryOfTheCounterParty2) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(counterparty2IdentifierTypeIndicator), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
				result = exists(MapperS.of(countryOfTheCounterParty2)).get();
			} else {
				result = notExists(MapperS.of(countryOfTheCounterParty2)).get();
			}
			
			return result;
		}
	}
}
