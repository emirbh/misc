package drr.base.qualification.event.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsVRAllowedForActionType.IsVRAllowedForActionTypeDefault.class)
public abstract class IsVRAllowedForActionType implements RosettaFunction {

	/**
	* @param actionTypefromTrade 
	* @return validActionType 
	*/
	public Boolean evaluate(ActionTypeEnum actionTypefromTrade) {
		Boolean validActionType = doEvaluate(actionTypefromTrade);
		
		return validActionType;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionTypefromTrade);

	public static class IsVRAllowedForActionTypeDefault extends IsVRAllowedForActionType {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionTypefromTrade) {
			Boolean validActionType = null;
			return assignOutput(validActionType, actionTypefromTrade);
		}
		
		protected Boolean assignOutput(Boolean validActionType, ActionTypeEnum actionTypefromTrade) {
			validActionType = areEqual(MapperS.of(actionTypefromTrade), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(actionTypefromTrade), MapperS.of(ActionTypeEnum.MODI), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(actionTypefromTrade), MapperS.of(ActionTypeEnum.CORR), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(actionTypefromTrade), MapperS.of(ActionTypeEnum.REVI), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(actionTypefromTrade), MapperS.of(ActionTypeEnum.POSC), CardinalityOperator.All)).get();
			
			return validActionType;
		}
	}
}
