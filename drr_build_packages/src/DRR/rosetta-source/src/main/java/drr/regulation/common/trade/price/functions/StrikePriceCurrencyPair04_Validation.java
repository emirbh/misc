package drr.regulation.common.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.string.functions.SubString;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(StrikePriceCurrencyPair04_Validation.StrikePriceCurrencyPair04_ValidationDefault.class)
public abstract class StrikePriceCurrencyPair04_Validation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected SubString subString;

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

	public static class StrikePriceCurrencyPair04_ValidationDefault extends StrikePriceCurrencyPair04_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, String strikePriceCurrency) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, contractType, strikePriceCurrency);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, String strikePriceCurrency) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(assetClass), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All)).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT)), MapperS.of(contractType), CardinalityOperator.Any)).getOrDefault(false)) {
				if (areEqual(MapperC.<String>of(MapperS.of("XAG"), MapperS.of("XAU"), MapperS.of("XBA"), MapperS.of("XBB"), MapperS.of("XBC"), MapperS.of("XBD"), MapperS.of("XDR"), MapperS.of("XEU"), MapperS.of("XFU"), MapperS.of("XPD"), MapperS.of("XPT"), MapperS.of("XTS")), MapperS.of(subString.evaluate(strikePriceCurrency, 5, 3)), CardinalityOperator.Any).getOrDefault(false)) {
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
