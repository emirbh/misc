package drr.regulation.common.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(StrikePriceCurrencyPair02_Validation.StrikePriceCurrencyPair02_ValidationDefault.class)
public abstract class StrikePriceCurrencyPair02_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param contractType 
	* @param strikePriceCurrency 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, String strikePriceCurrency) {
		Boolean result = doEvaluate(actionType, assetClass, contractType, strikePriceCurrency);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, String strikePriceCurrency);

	public static class StrikePriceCurrencyPair02_ValidationDefault extends StrikePriceCurrencyPair02_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, String strikePriceCurrency) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, contractType, strikePriceCurrency);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, String strikePriceCurrency) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.INTR), MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.CURR), MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM)), MapperS.of(assetClass), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(contractType), MapperS.of(CommonContractType.SWAP), CardinalityOperator.All)).getOrDefault(false)) {
				if (areEqual(MapperC.<String>of(MapperS.of("XAG"), MapperS.of("XAU"), MapperS.of("XBA"), MapperS.of("XBB"), MapperS.of("XBC"), MapperS.of("XBD"), MapperS.of("XDR"), MapperS.of("XEU"), MapperS.of("XFU"), MapperS.of("XPD"), MapperS.of("XPT"), MapperS.of("XTS")), MapperS.of(strikePriceCurrency), CardinalityOperator.Any).getOrDefault(false)) {
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
