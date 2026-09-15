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

@ImplementedBy(TotalNotionalQuantityLeg1_Validation.TotalNotionalQuantityLeg1_ValidationDefault.class)
public abstract class TotalNotionalQuantityLeg1_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param notionalQuantityLeg1 
	* @param totalNotionalQuantity 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg1, BigDecimal totalNotionalQuantity) {
		Boolean result = doEvaluate(actionType, assetClass, notionalQuantityLeg1, totalNotionalQuantity);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg1, BigDecimal totalNotionalQuantity);

	public static class TotalNotionalQuantityLeg1_ValidationDefault extends TotalNotionalQuantityLeg1_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg1, BigDecimal totalNotionalQuantity) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, notionalQuantityLeg1, totalNotionalQuantity);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, BigDecimal notionalQuantityLeg1, BigDecimal totalNotionalQuantity) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM)), MapperS.of(assetClass), CardinalityOperator.Any)).getOrDefault(false)) {
				final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
				if (greaterThan(MapperS.of(totalNotionalQuantity), MapperS.of(notionalQuantityLeg1), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(totalNotionalQuantity), (bigInteger == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(new BigDecimal(bigInteger))), CardinalityOperator.All)).getOrDefault(false)) {
					result = true;
				} else if (lessThan(MapperS.of(totalNotionalQuantity), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
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
