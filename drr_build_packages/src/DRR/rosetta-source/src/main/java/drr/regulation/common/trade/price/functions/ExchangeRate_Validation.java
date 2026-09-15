package drr.regulation.common.trade.price.functions;

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

@ImplementedBy(ExchangeRate_Validation.ExchangeRate_ValidationDefault.class)
public abstract class ExchangeRate_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param exchangeRate 
	* @param contractType 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal exchangeRate, CommonContractType contractType) {
		Boolean result = doEvaluate(actionType, assetClass, exchangeRate, contractType);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal exchangeRate, CommonContractType contractType);

	public static class ExchangeRate_ValidationDefault extends ExchangeRate_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal exchangeRate, CommonContractType contractType) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, exchangeRate, contractType);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal exchangeRate, CommonContractType contractType) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.CFDS), MapperS.of(CommonContractType.FORW), MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OTHR), MapperS.of(CommonContractType.OPTN)), MapperS.of(contractType), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(assetClass), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All)).getOrDefault(false)) {
				result = exists(MapperS.of(exchangeRate)).andNullSafe(greaterThan(MapperS.of(exchangeRate), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
