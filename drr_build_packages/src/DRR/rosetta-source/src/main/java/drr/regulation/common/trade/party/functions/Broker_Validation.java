package drr.regulation.common.trade.party.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Broker_Validation.Broker_ValidationDefault.class)
public abstract class Broker_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param broker 
	* @param counterparty2 
	* @param counterparty1 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, String broker, String counterparty2, String counterparty1) {
		Boolean result = doEvaluate(actionType, broker, counterparty2, counterparty1);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, String broker, String counterparty2, String counterparty1);

	public static class Broker_ValidationDefault extends Broker_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, String broker, String counterparty2, String counterparty1) {
			Boolean result = null;
			return assignOutput(result, actionType, broker, counterparty2, counterparty1);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, String broker, String counterparty2, String counterparty1) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				result = notEqual(MapperS.of(broker), MapperS.of(counterparty1), CardinalityOperator.Any).andNullSafe(notEqual(MapperS.of(broker), MapperS.of(counterparty2), CardinalityOperator.Any)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
