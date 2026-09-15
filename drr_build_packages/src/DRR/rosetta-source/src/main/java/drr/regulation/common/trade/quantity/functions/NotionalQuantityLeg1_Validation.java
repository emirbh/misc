package drr.regulation.common.trade.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalQuantityLeg1_Validation.NotionalQuantityLeg1_ValidationDefault.class)
public abstract class NotionalQuantityLeg1_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param notionalQuantityLeg1 
	* @param totalNotionalQuantityLeg1 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg1, BigDecimal totalNotionalQuantityLeg1) {
		Boolean result = doEvaluate(actionType, assetClass, notionalQuantityLeg1, totalNotionalQuantityLeg1);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg1, BigDecimal totalNotionalQuantityLeg1);

	public static class NotionalQuantityLeg1_ValidationDefault extends NotionalQuantityLeg1_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg1, BigDecimal totalNotionalQuantityLeg1) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, notionalQuantityLeg1, totalNotionalQuantityLeg1);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg1, BigDecimal totalNotionalQuantityLeg1) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(CommonAssetClass.COMM), MapperS.of(assetClass), CardinalityOperator.All)).getOrDefault(false)) {
				result = exists(MapperS.of(notionalQuantityLeg1)).andNullSafe(lessThanEquals(MapperS.of(notionalQuantityLeg1), MapperS.of(totalNotionalQuantityLeg1), CardinalityOperator.All)).andNullSafe(greaterThan(MapperS.of(notionalQuantityLeg1), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
