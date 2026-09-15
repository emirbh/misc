package drr.regulation.common.trade.price.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.trade.CommonLeg;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SpreadCurrencyLeg1_Validation.SpreadCurrencyLeg1_ValidationDefault.class)
public abstract class SpreadCurrencyLeg1_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param spreadLeg1 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonLeg spreadLeg1) {
		Boolean result = doEvaluate(actionType, spreadLeg1);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonLeg spreadLeg1);

	public static class SpreadCurrencyLeg1_ValidationDefault extends SpreadCurrencyLeg1_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonLeg spreadLeg1) {
			Boolean result = null;
			return assignOutput(result, actionType, spreadLeg1);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonLeg spreadLeg1) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				if (areEqual(MapperS.of(spreadLeg1).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
					result = exists(MapperS.of(spreadLeg1).<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency())).get();
				} else if (areEqual(MapperS.of(spreadLeg1).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation()), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(spreadLeg1).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation()), MapperS.of(PriceNotationEnum.BASIS), CardinalityOperator.All)).andNullSafe(notEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XTS), MapperS.of(ISOCurrencyCodeEnum.XXX)), MapperS.of(spreadLeg1).<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency()), CardinalityOperator.Any)).getOrDefault(false)) {
					result = notExists(MapperS.of(spreadLeg1).<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency())).get();
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
