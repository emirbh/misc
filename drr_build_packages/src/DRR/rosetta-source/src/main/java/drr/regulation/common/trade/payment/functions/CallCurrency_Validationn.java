package drr.regulation.common.trade.payment.functions;

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

@ImplementedBy(CallCurrency_Validationn.CallCurrency_ValidationnDefault.class)
public abstract class CallCurrency_Validationn implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param callAmount 
	* @param callCurrency 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal callAmount, ISOCurrencyCodeEnum callCurrency) {
		Boolean result = doEvaluate(actionType, assetClass, callAmount, callCurrency);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal callAmount, ISOCurrencyCodeEnum callCurrency);

	public static class CallCurrency_ValidationnDefault extends CallCurrency_Validationn {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal callAmount, ISOCurrencyCodeEnum callCurrency) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, callAmount, callCurrency);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal callAmount, ISOCurrencyCodeEnum callCurrency) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(assetClass), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All)).andNullSafe(exists(MapperS.of(callAmount))).getOrDefault(false)) {
				result = exists(MapperS.of(callCurrency)).get();
			} else {
				result = true;
			}
			
			return result;
		}
	}
}
