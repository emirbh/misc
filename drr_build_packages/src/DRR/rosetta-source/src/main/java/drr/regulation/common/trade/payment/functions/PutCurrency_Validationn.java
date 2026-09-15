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

@ImplementedBy(PutCurrency_Validationn.PutCurrency_ValidationnDefault.class)
public abstract class PutCurrency_Validationn implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param putAmount 
	* @param putCurrency 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal putAmount, ISOCurrencyCodeEnum putCurrency) {
		Boolean result = doEvaluate(actionType, assetClass, putAmount, putCurrency);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal putAmount, ISOCurrencyCodeEnum putCurrency);

	public static class PutCurrency_ValidationnDefault extends PutCurrency_Validationn {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal putAmount, ISOCurrencyCodeEnum putCurrency) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, putAmount, putCurrency);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal putAmount, ISOCurrencyCodeEnum putCurrency) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(assetClass), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All)).andNullSafe(exists(MapperS.of(putAmount))).getOrDefault(false)) {
				result = exists(MapperS.of(putCurrency)).get();
			} else {
				result = true;
			}
			
			return result;
		}
	}
}
