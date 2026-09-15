package drr.regulation.common.trade.quantity.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalCurrencyLeg2_Validation.NotionalCurrencyLeg2_ValidationDefault.class)
public abstract class NotionalCurrencyLeg2_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param notionalAmountLeg2 
	* @param notionalCurrencyLeg2 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalAmountLeg2, ISOCurrencyCodeEnum notionalCurrencyLeg2) {
		Boolean result = doEvaluate(actionType, assetClass, notionalAmountLeg2, notionalCurrencyLeg2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalAmountLeg2, ISOCurrencyCodeEnum notionalCurrencyLeg2);

	public static class NotionalCurrencyLeg2_ValidationDefault extends NotionalCurrencyLeg2_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalAmountLeg2, ISOCurrencyCodeEnum notionalCurrencyLeg2) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, notionalAmountLeg2, notionalCurrencyLeg2);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalAmountLeg2, ISOCurrencyCodeEnum notionalCurrencyLeg2) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				if (exists(MapperS.of(notionalAmountLeg2)).getOrDefault(false)) {
					result = exists(MapperS.of(notionalCurrencyLeg2)).andNullSafe(notEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XTS)), MapperS.of(notionalCurrencyLeg2), CardinalityOperator.All)).get();
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
