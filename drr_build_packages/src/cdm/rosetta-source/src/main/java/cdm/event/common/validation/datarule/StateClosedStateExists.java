package cdm.event.common.validation.datarule;

import cdm.event.common.ClosedState;
import cdm.event.common.State;
import cdm.event.position.PositionStatusEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("StateClosedStateExists")
@ImplementedBy(StateClosedStateExists.Default.class)
public interface StateClosedStateExists extends Validator<State> {
	
	String NAME = "StateClosedStateExists";
	String DEFINITION = "if positionState = PositionStatusEnum -> Closed then closedState exists";
	
	class Default implements StateClosedStateExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, State state) {
			ComparisonResult result = executeDataRule(state);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "State", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "State", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(State state) {
			try {
				if (areEqual(MapperS.of(state).<PositionStatusEnum>map("getPositionState", _state -> _state.getPositionState()), MapperS.of(PositionStatusEnum.CLOSED), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(state).<ClosedState>map("getClosedState", _state -> _state.getClosedState()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StateClosedStateExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, State state) {
			return Collections.emptyList();
		}
	}
}
