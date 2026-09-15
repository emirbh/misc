package drr.regulation.common.trade.execution.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SettlementCurrency_Validation.SettlementCurrency_ValidationDefault.class)
public abstract class SettlementCurrency_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param settlementCurrencyLeg1 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, ISOCurrencyCodeEnum settlementCurrencyLeg1) {
		Boolean result = doEvaluate(actionType, settlementCurrencyLeg1);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, ISOCurrencyCodeEnum settlementCurrencyLeg1);

	public static class SettlementCurrency_ValidationDefault extends SettlementCurrency_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, ISOCurrencyCodeEnum settlementCurrencyLeg1) {
			Boolean result = null;
			return assignOutput(result, actionType, settlementCurrencyLeg1);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, ISOCurrencyCodeEnum settlementCurrencyLeg1) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XTS), MapperS.of(ISOCurrencyCodeEnum.XXX)), MapperS.of(settlementCurrencyLeg1), CardinalityOperator.Any)).getOrDefault(false)) {
				result = false;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
