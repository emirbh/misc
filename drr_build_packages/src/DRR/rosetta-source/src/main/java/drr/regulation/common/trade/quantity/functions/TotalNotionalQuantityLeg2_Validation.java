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

@ImplementedBy(TotalNotionalQuantityLeg2_Validation.TotalNotionalQuantityLeg2_ValidationDefault.class)
public abstract class TotalNotionalQuantityLeg2_Validation implements RosettaFunction {

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

	public static class TotalNotionalQuantityLeg2_ValidationDefault extends TotalNotionalQuantityLeg2_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg2, BigDecimal totalNotionalQuantityLeg2) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, notionalQuantityLeg2, totalNotionalQuantityLeg2);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg2, BigDecimal totalNotionalQuantityLeg2) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM)), MapperS.of(assetClass), CardinalityOperator.Any)).getOrDefault(false)) {
				if (lessThan(MapperS.of(notionalQuantityLeg2), MapperS.of(totalNotionalQuantityLeg2), CardinalityOperator.All).getOrDefault(false)) {
					if (notEqual(MapperS.of(notionalQuantityLeg2), MapperS.of(totalNotionalQuantityLeg2), CardinalityOperator.Any).getOrDefault(false)) {
						result = true;
					} else if (lessThan(MapperS.of(totalNotionalQuantityLeg2), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
						result = false;
					} else {
						result = null;
					}
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
