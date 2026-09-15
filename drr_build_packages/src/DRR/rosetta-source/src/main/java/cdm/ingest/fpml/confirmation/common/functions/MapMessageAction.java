package cdm.ingest.fpml.confirmation.common.functions;

import cdm.event.common.ActionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapMessageAction.MapMessageActionDefault.class)
public abstract class MapMessageAction implements RosettaFunction {

	/**
	* @param isCorrection 
	* @param reason 
	* @return action 
	*/
	public ActionEnum evaluate(Boolean isCorrection, String reason) {
		ActionEnum action = doEvaluate(isCorrection, reason);
		
		return action;
	}

	protected abstract ActionEnum doEvaluate(Boolean isCorrection, String reason);

	public static class MapMessageActionDefault extends MapMessageAction {
		@Override
		protected ActionEnum doEvaluate(Boolean isCorrection, String reason) {
			ActionEnum action = null;
			return assignOutput(action, isCorrection, reason);
		}
		
		protected ActionEnum assignOutput(ActionEnum action, Boolean isCorrection, String reason) {
			if (areEqual(MapperS.of(reason), MapperS.of("RaisedInError"), CardinalityOperator.All).getOrDefault(false)) {
				action = ActionEnum.CANCEL;
			} else {
				final MapperS<Boolean> switchArgument = MapperS.of(isCorrection);
				if (switchArgument.get() == null) {
					action = null;
				} else if (areEqual(switchArgument, MapperS.of(true), CardinalityOperator.All).get()) {
					action = ActionEnum.CORRECT;
				} else if (areEqual(switchArgument, MapperS.of(false), CardinalityOperator.All).get()) {
					action = ActionEnum.NEW;
				} else {
					action = null;
				}
			}
			
			return action;
		}
	}
}
