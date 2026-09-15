package drr.regulation.common.trade.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.Direction2Enum;
import java.math.BigDecimal;
import java.math.BigInteger;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalAmountLeg2_01_Validation.NotionalAmountLeg2_01_ValidationDefault.class)
public abstract class NotionalAmountLeg2_01_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param direction2Leg2 
	* @param notionalAmountLeg2 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, Direction2Enum direction2Leg2, BigDecimal notionalAmountLeg2) {
		Boolean result = doEvaluate(actionType, assetClass, direction2Leg2, notionalAmountLeg2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, Direction2Enum direction2Leg2, BigDecimal notionalAmountLeg2);

	public static class NotionalAmountLeg2_01_ValidationDefault extends NotionalAmountLeg2_01_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, Direction2Enum direction2Leg2, BigDecimal notionalAmountLeg2) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, direction2Leg2, notionalAmountLeg2);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, Direction2Enum direction2Leg2, BigDecimal notionalAmountLeg2) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.INTR), MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.CURR), MapperS.of(CommonAssetClass.EQUI)), MapperS.of(assetClass), CardinalityOperator.Any)).getOrDefault(false)) {
				if (exists(MapperS.of(direction2Leg2)).getOrDefault(false)) {
					final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
					result = exists(MapperS.of(notionalAmountLeg2)).andNullSafe(greaterThanEquals(MapperS.of(notionalAmountLeg2), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(notionalAmountLeg2), (bigInteger == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(new BigDecimal(bigInteger))), CardinalityOperator.All)).get();
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
