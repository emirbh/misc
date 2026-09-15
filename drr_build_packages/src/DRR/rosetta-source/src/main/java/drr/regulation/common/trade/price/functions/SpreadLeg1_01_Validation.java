package drr.regulation.common.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SpreadLeg1_01_Validation.SpreadLeg1_01_ValidationDefault.class)
public abstract class SpreadLeg1_01_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param contractType 
	* @param fixedRateLeg1 
	* @param fixedRateLeg2 
	* @param spreadLeg1 
	* @param spreadLeg2 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, BigDecimal fixedRateLeg1, BigDecimal fixedRateLeg2, PriceFormat spreadLeg1, PriceFormat spreadLeg2) {
		Boolean result = doEvaluate(actionType, assetClass, contractType, fixedRateLeg1, fixedRateLeg2, spreadLeg1, spreadLeg2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, BigDecimal fixedRateLeg1, BigDecimal fixedRateLeg2, PriceFormat spreadLeg1, PriceFormat spreadLeg2);

	public static class SpreadLeg1_01_ValidationDefault extends SpreadLeg1_01_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, BigDecimal fixedRateLeg1, BigDecimal fixedRateLeg2, PriceFormat spreadLeg1, PriceFormat spreadLeg2) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, contractType, fixedRateLeg1, fixedRateLeg2, spreadLeg1, spreadLeg2);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, CommonContractType contractType, BigDecimal fixedRateLeg1, BigDecimal fixedRateLeg2, PriceFormat spreadLeg1, PriceFormat spreadLeg2) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(assetClass), MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(contractType), MapperS.of(CommonContractType.SWAP), CardinalityOperator.All))).getOrDefault(false)) {
				if (notExists(MapperS.of(fixedRateLeg1)).andNullSafe(notExists(MapperS.of(fixedRateLeg2))).andNullSafe(notExists(MapperS.of(spreadLeg2))).getOrDefault(false)) {
					result = exists(MapperS.of(spreadLeg1)).get();
				} else if (exists(MapperS.of(fixedRateLeg1)).getOrDefault(false)) {
					result = notExists(MapperS.of(spreadLeg1)).get();
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
