package drr.regulation.common.trade.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.math.BigInteger;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalQuantityLeg2_Validation.NotionalQuantityLeg2_ValidationDefault.class)
public abstract class NotionalQuantityLeg2_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param notionalQuantityLeg2 
	* @param totalNotionalQuantityLeg2 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg2, BigDecimal totalNotionalQuantityLeg2) {
		Boolean result = doEvaluate(actionType, assetClass, notionalQuantityLeg2, totalNotionalQuantityLeg2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg2, BigDecimal totalNotionalQuantityLeg2);

	public static class NotionalQuantityLeg2_ValidationDefault extends NotionalQuantityLeg2_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg2, BigDecimal totalNotionalQuantityLeg2) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, notionalQuantityLeg2, totalNotionalQuantityLeg2);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg2, BigDecimal totalNotionalQuantityLeg2) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(CommonAssetClass.COMM), MapperS.of(assetClass), CardinalityOperator.All)).getOrDefault(false)) {
				final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
				if (exists(MapperS.of(notionalQuantityLeg2)).andNullSafe(notEqual(MapperS.of(totalNotionalQuantityLeg2), (bigInteger == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(new BigDecimal(bigInteger))), CardinalityOperator.Any)).getOrDefault(false)) {
					result = lessThanEquals(MapperS.of(notionalQuantityLeg2), MapperS.of(totalNotionalQuantityLeg2), CardinalityOperator.All).get();
				} else if (lessThan(MapperS.of(notionalQuantityLeg2), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
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
