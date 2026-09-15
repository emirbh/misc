package drr.regulation.common.trade.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(QuantityUnitOfMeasureLeg_Validation.QuantityUnitOfMeasureLeg_ValidationDefault.class)
public abstract class QuantityUnitOfMeasureLeg_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param totalNotionalQuantityLeg 
	* @param quantityUnitOfMeasureLeg 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, BigDecimal totalNotionalQuantityLeg, String quantityUnitOfMeasureLeg) {
		Boolean result = doEvaluate(actionType, totalNotionalQuantityLeg, quantityUnitOfMeasureLeg);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, BigDecimal totalNotionalQuantityLeg, String quantityUnitOfMeasureLeg);

	public static class QuantityUnitOfMeasureLeg_ValidationDefault extends QuantityUnitOfMeasureLeg_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, BigDecimal totalNotionalQuantityLeg, String quantityUnitOfMeasureLeg) {
			Boolean result = null;
			return assignOutput(result, actionType, totalNotionalQuantityLeg, quantityUnitOfMeasureLeg);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, BigDecimal totalNotionalQuantityLeg, String quantityUnitOfMeasureLeg) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				if (exists(MapperS.of(totalNotionalQuantityLeg)).getOrDefault(false)) {
					result = exists(MapperS.of(quantityUnitOfMeasureLeg)).get();
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
