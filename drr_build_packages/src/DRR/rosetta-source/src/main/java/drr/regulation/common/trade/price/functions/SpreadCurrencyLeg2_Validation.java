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

@ImplementedBy(SpreadCurrencyLeg2_Validation.SpreadCurrencyLeg2_ValidationDefault.class)
public abstract class SpreadCurrencyLeg2_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param spreadLeg2 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonLeg spreadLeg2) {
		Boolean result = doEvaluate(actionType, spreadLeg2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonLeg spreadLeg2);

	public static class SpreadCurrencyLeg2_ValidationDefault extends SpreadCurrencyLeg2_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonLeg spreadLeg2) {
			Boolean result = null;
			return assignOutput(result, actionType, spreadLeg2);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonLeg spreadLeg2) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				if (areEqual(MapperS.of(spreadLeg2).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
					result = exists(MapperS.of(spreadLeg2).<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency())).get();
				} else if (areEqual(MapperS.of(spreadLeg2).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation()), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(spreadLeg2).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation()), MapperS.of(PriceNotationEnum.BASIS), CardinalityOperator.All)).getOrDefault(false)) {
					result = notExists(MapperS.of(spreadLeg2).<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency())).get();
				} else if (areEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XTS), MapperS.of(ISOCurrencyCodeEnum.XXX)), MapperS.of(spreadLeg2).<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency()), CardinalityOperator.Any).getOrDefault(false)) {
					result = false;
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
