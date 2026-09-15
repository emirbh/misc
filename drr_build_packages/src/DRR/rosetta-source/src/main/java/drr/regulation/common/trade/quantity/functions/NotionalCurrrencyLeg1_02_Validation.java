package drr.regulation.common.trade.quantity.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalCurrrencyLeg1_02_Validation.NotionalCurrrencyLeg1_02_ValidationDefault.class)
public abstract class NotionalCurrrencyLeg1_02_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param notionalAmountLeg1 
	* @param notionalCurrencyLeg1 
	* @param contractType 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalAmountLeg1, ISOCurrencyCodeEnum notionalCurrencyLeg1, CommonContractType contractType) {
		Boolean result = doEvaluate(actionType, assetClass, notionalAmountLeg1, notionalCurrencyLeg1, contractType);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalAmountLeg1, ISOCurrencyCodeEnum notionalCurrencyLeg1, CommonContractType contractType);

	public static class NotionalCurrrencyLeg1_02_ValidationDefault extends NotionalCurrrencyLeg1_02_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalAmountLeg1, ISOCurrencyCodeEnum notionalCurrencyLeg1, CommonContractType contractType) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, notionalAmountLeg1, notionalCurrencyLeg1, contractType);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalAmountLeg1, ISOCurrencyCodeEnum notionalCurrencyLeg1, CommonContractType contractType) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.CFDS), MapperS.of(CommonContractType.FRAS), MapperS.of(CommonContractType.FORW), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.OTHR)), MapperS.of(contractType), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(assetClass), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All)).getOrDefault(false)) {
				if (exists(MapperS.of(notionalAmountLeg1)).getOrDefault(false)) {
					result = exists(MapperS.of(notionalCurrencyLeg1)).andNullSafe(notEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XTS)), MapperS.of(notionalCurrencyLeg1), CardinalityOperator.All)).get();
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
