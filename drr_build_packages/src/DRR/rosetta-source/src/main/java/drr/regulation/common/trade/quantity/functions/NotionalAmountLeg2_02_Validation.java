package drr.regulation.common.trade.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.Direction2Enum;
import java.math.BigDecimal;
import java.math.BigInteger;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalAmountLeg2_02_Validation.NotionalAmountLeg2_02_ValidationDefault.class)
public abstract class NotionalAmountLeg2_02_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param assetClass 
	* @param direction2Leg2 
	* @param notionalAmountLeg2 
	* @param contractType 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, Direction2Enum direction2Leg2, BigDecimal notionalAmountLeg2, CommonContractType contractType) {
		Boolean result = doEvaluate(actionType, assetClass, direction2Leg2, notionalAmountLeg2, contractType);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, Direction2Enum direction2Leg2, BigDecimal notionalAmountLeg2, CommonContractType contractType);

	public static class NotionalAmountLeg2_02_ValidationDefault extends NotionalAmountLeg2_02_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonAssetClass assetClass, Direction2Enum direction2Leg2, BigDecimal notionalAmountLeg2, CommonContractType contractType) {
			Boolean result = null;
			return assignOutput(result, actionType, assetClass, direction2Leg2, notionalAmountLeg2, contractType);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonAssetClass assetClass, Direction2Enum direction2Leg2, BigDecimal notionalAmountLeg2, CommonContractType contractType) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(assetClass), MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.CFDS), MapperS.of(CommonContractType.FRAS), MapperS.of(CommonContractType.FORW), MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OTHR)), MapperS.of(contractType), CardinalityOperator.Any))).getOrDefault(false)) {
				final ComparisonResult ifThenElseResult;
				if (exists(MapperS.of(direction2Leg2)).getOrDefault(false)) {
					ifThenElseResult = exists(MapperS.of(notionalAmountLeg2));
				} else {
					ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(false));
				}
				final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
				result = ifThenElseResult.orNullSafe(areEqual(MapperS.of(notionalAmountLeg2), (bigInteger == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(new BigDecimal(bigInteger))), CardinalityOperator.All)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
