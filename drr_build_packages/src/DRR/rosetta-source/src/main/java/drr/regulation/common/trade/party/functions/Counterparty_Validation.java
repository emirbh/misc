package drr.regulation.common.trade.party.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty_Validation.Counterparty_ValidationDefault.class)
public abstract class Counterparty_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param counterparty2 
	* @param counterparty1 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, String counterparty2, String counterparty1) {
		Boolean result = doEvaluate(actionType, counterparty2, counterparty1);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, String counterparty2, String counterparty1);

	public static class Counterparty_ValidationDefault extends Counterparty_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, String counterparty2, String counterparty1) {
			Boolean result = null;
			return assignOutput(result, actionType, counterparty2, counterparty1);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, String counterparty2, String counterparty1) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.MARU), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.PRTO), MapperS.of(ActionTypeEnum.EROR), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.VALU)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				result = notEqual(MapperS.of(counterparty1), MapperS.of(counterparty2), CardinalityOperator.Any).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
