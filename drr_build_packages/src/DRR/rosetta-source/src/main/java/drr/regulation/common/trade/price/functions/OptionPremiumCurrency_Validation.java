package drr.regulation.common.trade.price.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OptionPremiumCurrency_Validation.OptionPremiumCurrency_ValidationDefault.class)
public abstract class OptionPremiumCurrency_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param optionPremiumAmount 
	* @param contractType 
	* @param optionPremiumCurrency 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, BigDecimal optionPremiumAmount, CommonContractType contractType, ISOCurrencyCodeEnum optionPremiumCurrency) {
		Boolean result = doEvaluate(actionType, optionPremiumAmount, contractType, optionPremiumCurrency);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, BigDecimal optionPremiumAmount, CommonContractType contractType, ISOCurrencyCodeEnum optionPremiumCurrency);

	public static class OptionPremiumCurrency_ValidationDefault extends OptionPremiumCurrency_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, BigDecimal optionPremiumAmount, CommonContractType contractType, ISOCurrencyCodeEnum optionPremiumCurrency) {
			Boolean result = null;
			return assignOutput(result, actionType, optionPremiumAmount, contractType, optionPremiumCurrency);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, BigDecimal optionPremiumAmount, CommonContractType contractType, ISOCurrencyCodeEnum optionPremiumCurrency) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT)), MapperS.of(contractType), CardinalityOperator.Any)).getOrDefault(false)) {
				if (exists(MapperS.of(optionPremiumAmount)).getOrDefault(false)) {
					result = exists(MapperS.of(optionPremiumCurrency)).andNullSafe(notEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XTS), MapperS.of(ISOCurrencyCodeEnum.XXX)), MapperS.of(optionPremiumCurrency), CardinalityOperator.All)).get();
				} else {
					result = null;
				}
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
